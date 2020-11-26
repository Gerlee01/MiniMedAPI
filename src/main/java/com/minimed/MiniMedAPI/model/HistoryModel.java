package com.minimed.MiniMedAPI.model;

import com.minimed.MiniMedAPI.entity.history.History;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HistoryModel {
    private Long id;
    private LocalDateTime targetDate; //Цаг авсан өдөр
    private LocalTime targetTime; //Авсан цаг
    private int targetNumber; //Авсан дугаар
    private String pdf; //Үзлэгийн дэлгэрэнгүй мэдээлэлтэй pdf файл
    private History.Status status; //Төлөв
    private History.Type type; //Төрөл
    private LocalDateTime created; //Цаг өгөгдсөн огноо
}
