package com.minimed.MiniMedAPI.entity.hospital;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
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
    private String nickname; //Эмнэлгийн товчилсон нэр
    private String code;//Эмнэлгийн код
    private String addressUuid; //Эмнэлгийн хаяг
    @Column(columnDefinition = "double default 0")
    private double lat;
    @Column(columnDefinition = "double default 0")
    private double lng;
    private LocalDateTime created; //Эмнэлгийг бүртгэж авсан огноо
}
