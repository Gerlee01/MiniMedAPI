package com.minimed.MiniMedAPI.entity.payment;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Б. Гэрэлцэцэг
 * @since 2020.11.02
 * <p>
 * Төлбөрийн түүх, мэдээлэл
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Payment extends BaseModel {

    @NotNull
    private Long patientID; //Өвчтөний дугаар

    @NotNull
    private Long hospitalID; //Эмнэлгийн дугаар

    private int price; //Төлбөр
    private Type type; //Төлбөрийн төрөл
    private LocalDateTime created; //Төлбөр хийгдсэн огноо

    public enum Type {
        person("Өөрөө"), clinic("Тасгийн хөнгөлөлт"), diagnosis("Оношийн хөнгөлөлт");
        private String type;
        Type(String type) { this.type = type; }
        public String getType() { return type; }
    }
}
