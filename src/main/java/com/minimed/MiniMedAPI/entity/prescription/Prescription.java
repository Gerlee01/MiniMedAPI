package com.minimed.MiniMedAPI.entity.prescription;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
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

    @Column(columnDefinition = "TEXT")
    private String rp;// тайлбар
    @Column(columnDefinition = "TEXT")
    private String note;// тайлбар
    @Column(columnDefinition = "TEXT")
    private String parmokokinetik; // Фармакокинетик үйлдэл
    @Column(columnDefinition = "TEXT")
    private String parmakodinamik; // Фармакодинамик үйлдэл
    @Column(columnDefinition = "TEXT")
    private String arga; // Хэрэглэх арга
    @Column(columnDefinition = "TEXT")
    private String usedtun;
    @Column(columnDefinition = "TEXT")
    private String usedtunMax;//Тун хэтэрсэн үед илрэх шинж, авах арга хэмжээ
    @Column(columnDefinition = "TEXT")
    private String nuloo; // Гаж нөлөө
    @Column(columnDefinition = "TEXT")
    private String tseerlelt; // Цээрлэлт
    @Column(columnDefinition = "TEXT")
    private String nemelt;  // Нэмэлт мэдлэг
    @Column(columnDefinition = "TEXT")
    private String uilchlel;  // Үйлчлэл  Харилцан үйлчилгээ
    @Column(columnDefinition = "TEXT")
    private String zaalt;  // Хэрэглэх заалт
    @Column(columnDefinition = "TEXT")
    private String pregnantZaalt;//Жирэмсэн ба хөхүүл үеийн хэрэглээ
    @Column(columnDefinition = "TEXT")
    private String olgoh;  // Олгох нөхцөл
    @Column(columnDefinition = "TEXT")
    private String hadgalah;  // Хадгалах нөхцөл

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

    public int getTypeIndex(){
        switch (this.type){
            case normal: return 0;
            case setgets: return 1;
            case mansuuruulah: return 2;
            default: return 3;
        }
    }
}


