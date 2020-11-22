package com.minimed.MiniMedAPI.entity.settings;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Б. Гэрэлцэцэг
 * @since 2020.11.02
 * <p>
 * Setting
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Settings extends BaseModel {
    @NotNull
    @NotEmpty
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true)
    private String uuid; //өөрийн нь давхардахгүй дугаар
    private String parentUuid; //харьялалыг тодотгоно. ЖШ: дүүргийг илэрхийж байгаа бол тухайн дүүргийн харьялагдах хотын uuid г хадгална.

    @NotEmpty
    @NotNull
    private String module;
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    @Column(columnDefinition = "text")
    private String value;
    private String code;
    @Column(columnDefinition = "text")
    private String description;
    private int daraalal;
}
