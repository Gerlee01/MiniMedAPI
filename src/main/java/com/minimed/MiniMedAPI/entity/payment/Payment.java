package com.minimed.MiniMedAPI.entity.payment;

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
 * Төлбөрийн түүх, мэдээлэл
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Payment extends BaseModel {
    private String mainUuid; //байж болох утгууд: TimeTableUUID, AM1BUUID, AnalysisUUID, PacsUUID

    @Column(columnDefinition = "double default 0")
    private double price; // төлөх төлбөр
    @Column(columnDefinition = "double default 0")
    private double discountPack; // Багцын хөнгөлөлт // 1.
    @Column(columnDefinition = "double default 0")
    private double discountVip; // Эрхийн хөнгөлөлт // 2.
    @Column(columnDefinition = "double default 0")
    private double discountEmergency; // Яаралтай цагийн төрлийн хөнгөлөлт // 3.
    @Column(columnDefinition = "double default 0")
    private double discountOutPatient; // Тасгийн хөнгөлөлт // 4.
    @Column(columnDefinition = "double default 0")
    private double discountDiagnosis; // A B C Z оношийн хөнгөлөлт // 5.
    @Column(columnDefinition = "double default 0")
    private double discountInsurance; // Даатгалын хөнгөлөлт // 6.
    @Column(columnDefinition = "double default 0")
    private double discountRepeat; // Давтан үзлэгийн хөнгөлөлт // 7.
    @Column(columnDefinition = "double default 0")
    private double discountFamily; // Гэр бүлийн хөнгөлөлт // 8.
    @Column(columnDefinition = "double default 0")
    private double discountPercent; // Хувьчилсан буюу гараараа хөнгөлсөн 9.
    @Column(columnDefinition = "double default 0")
    private double mainPrice; // Үндсэн дүн буюу хөнгөлөгдөөгүй дүн

    private LocalDateTime created; //Төлбөр хийгдсэн огноо
}
