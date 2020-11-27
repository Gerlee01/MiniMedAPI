package com.minimed.MiniMedAPI.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoryModel {
    private Long id;
    private LocalDateTime targetDate; //Цаг авсан өдөр
    private LocalDateTime targetTime; //Авсан цаг
    private int targetNumber; //Авсан дугаар
    private String pdf; //Үзлэгийн дэлгэрэнгүй мэдээлэлтэй pdf файл
    private int status; //Төлөв
    private int type; //Төрөл
    private LocalDateTime created; //Цаг өгөгдсөн огноо
}
