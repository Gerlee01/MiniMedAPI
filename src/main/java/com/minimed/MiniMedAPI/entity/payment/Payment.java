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

    private String mainUuid; //

    private double mainPrice;// нийт төлбөр
    private double price; // төлөх төлбөр
    private double discount; // хөнгөлөлт
    private Status discountStatus;// хөнгөлөлтийн төрөл
    private LocalDateTime created; //Төлбөр хийгдсэн огноо

    public enum Status {
        insuranceDiscount("даатгал"), organizationDiscount("байгууллага"), outPatientDiscount("Тасгийн хөнгөлөлт"), emergencyDiscount("яаралтай хөнгөлөлт");
        private String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}
