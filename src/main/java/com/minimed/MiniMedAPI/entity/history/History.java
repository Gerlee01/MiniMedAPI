package com.minimed.MiniMedAPI.entity.history;

import com.minimed.MiniMedAPI.entity.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Б. Гэрэлцэцэг
 * @since 2020.11.02
 * <p>
 * Үзлэг, оношилгоо, шинжилгээний түүх
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class History extends BaseModel {
    private String historyUuid; //
    @NotNull
    private Long patientID; //Өвчтөний дугаар

    @NotNull
    private Long hospitalID; //Эмнэлгийн дугаар

    @NotNull
    private LocalDate targetDate; //Цаг авсан өдөр

    private LocalTime targetTime; //Авсан цаг

    @Column(columnDefinition = "int default 0")
    private int targetNumber; //Авсан дугаар

    @Column(columnDefinition = "LONG TEXT")
    private String pdf; //Үзлэгийн дэлгэрэнгүй мэдээлэлтэй pdf файл

    private Status status; //Төлөв
    private Type type; //Төрөл
    private LocalDateTime created; //Цаг өгөгдсөн огноо

    public enum Status {
        active("Ирсэн"), inactive("Ирээгүй");
        private String status;
        Status(String status) { this.status = status; }
        public String getStatus() { return status; }
    }

    public enum Type {
        ambulatory("Үзлэг"), analysis("Шинжилгээ"), pacs("Оношилгоо");
        private String type;
        Type(String type) { this.type = type; }
        public String getType() { return type; }
    }
}
