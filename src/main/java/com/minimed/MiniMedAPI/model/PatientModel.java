package com.minimed.MiniMedAPI.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PatientModel{
    private Long id;
    private String firstName; //Өөрийн нэр
    private String lastName; //Овог
    private String cardNo; //Өвчтөний картын дугаар
    private String mail; //Имэйл хаяг
    private String phone; //Гар утасны дугаар
    private String regNum; //Регистрийн дугаар
    private String city;
    private String district;
    private String khoroo;
    private String block; //Хороолол/гудамж
    private String number; //Тоот
    private String house; //Байр/хашаа
    private LocalDateTime created; //Өвчтөнийг бүртгэж авсан огноо
}
