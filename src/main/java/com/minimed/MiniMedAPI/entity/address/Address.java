package com.minimed.MiniMedAPI.entity.address;

import com.minimed.MiniMedAPI.entity.BaseModel;
import com.minimed.MiniMedAPI.entity.settings.Settings;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Б. Гэрэлцэцэг
 * @since 2020.11.02
 * <p>
 * Хаяг
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Address extends BaseModel   {
    @NotNull
    @NotEmpty
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true)
    private String uuid;

    @ManyToOne
    private Settings city;
    @ManyToOne
    private Settings district;
    @ManyToOne
    private Settings khoroo;

    private String block;//Хороолол/гудамж
    private String house;//Байр/хашаа
    private String number;//Тоот
}

