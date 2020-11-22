package com.minimed.MiniMedAPI.service.util;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

@Slf4j
public class PrefixPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {


    private String addUnderscores(String name) {
        final StringBuilder buf = new StringBuilder(name.replace('.', '_'));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1)) &&
                    Character.isUpperCase(buf.charAt(i)) &&
                    Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase(Locale.ROOT);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        String prefix = "";
        try (ScanResult scanResult =                // Assign scanResult in try-with-resources
                     new ClassGraph()                    // Create a new ClassGraph instance
                             //.verbose()                      // If you want to enable logging to stderr
                             //.enableAllInfo()                // Scan classes, methods, fields, annotations
                             .acceptPackages("com.minimed.MiniMedAPI.entity")   // Scan com.xyz and subpackages
                             .scan()) {                      // Perform the scan and return a ScanResult
            ClassInfoList allClasses = scanResult.getAllClasses();
            for (Class c : allClasses.loadClasses()) {
                if (c.getSimpleName().equals(name.getText())) {
                    prefix = c.getPackage().getName().substring(30);
                }
            }
        }
        return new Identifier(addUnderscores(prefix + name.getText()), name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return new Identifier(addUnderscores(name.getText()), name.isQuoted());
    }
}