package com.minimed.MiniMedAPI.model;

import java.time.LocalDateTime;

public class HospitalModel {
    private Long id;
    private String name; //Эмнэлгийн нэр
    private String city;
    private String district;
    private String khoroo;
    private String block; //Хороолол/гудамж
    private String number; //Тоот
    private String house; //Байр/хашаа
    private LocalDateTime created; //Э
}
