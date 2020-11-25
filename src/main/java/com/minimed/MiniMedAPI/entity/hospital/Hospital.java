package com.minimed.MiniMedAPI.entity.hospital;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author Б. Гэрэлцэцэг
 * @since 2020.11.02
 * <p>
 * Эмнэлэг
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Hospital extends BaseModel {
    private String name; //Эмнэлгийн нэр
    private String addressUuid; //Эмнэлгийн хаяг
    private LocalDateTime created; //Эмнэлгийг бүртгэж авсан огноо
}
