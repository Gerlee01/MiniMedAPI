package com.minimed.MiniMedAPI.entity.user;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @author Б. Гэрэлцэцэг
 * @since 2020.11.02
 * <p>
 * Нэвтрэх хэрэглэгч
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseModel {
    @NotNull
    @NotEmpty
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true)
    private String uuid;

    @NotNull
    @NotEmpty
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(unique = true)
    private String parentUuid; //хувийн мэдээллийг олж болох uuid

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 20)
    @Column(unique = true)
    private String username;//Нэвтрэх нэр
    @NotEmpty
    @NotNull
    @Size(min = 6)
    private String password;//Нууц үг

    @Type(type = "json")
    @Column(columnDefinition = "text")
    private List<String> roles;

    private LocalDateTime created; //бүртгэж авсан огноо
}
