package com.minimed.MiniMedAPI.entity.prescription;

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
 * Эмийн жорын маягт
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Prescription extends BaseModel {

    @NotNull
    private Long patientID; //Өвчтөний дугаар
    @NotNull
    private Long hospitalID; //Эмнэлгийн дугаар
    private String formam1bUuid;
    private String pillName; //Эмийн нэр
    private String diagnosis;//Онош

    private String rp;// тайлбар эмийн нэрс болон хэрэглэх заавар г.м
    private String note;// тайлбар эмийн нэрс болон хэрэглэх заавар г.м

    private String doctorFullName; //Жор бичсэн эмчийн бүтэн нэр
    private String doctorWorkPlace; //Жор бичсэн эмчийн ажлын байрны нэршил
    private String doctorRegNum; //Жор бичсэн эмчийн регистрийн дугаар
    private Type type; //Эмийн төрөл
    private LocalDateTime created; //Жор бичсэн өдөр

    public enum Type {
        normal("Энгийн"), setgets("Сэтгэцэд нөлөөт"), mansuuruulah("Мансууруулах");
        private String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}


