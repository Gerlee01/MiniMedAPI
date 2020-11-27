package com.minimed.MiniMedAPI.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PrescriptionModel {
    private  Long id;
    private  String pillName; //Эмийн нэр
    private  String diagnosis; //Онош

    private  String rp; // тайлбар
    private  String note; // тайлбар
    private  String parmokokinetik; // Фармакокинетик үйлдэл
    private  String parmakodinamik; // Фармакодинамик үйлдэл
    private  String arga; // Хэрэглэх арга
    private  String usedtun;
    private  String usedtunMax; //Тун хэтэрсэн үед илрэх шинж, авах арга хэмжээ
    private  String nuloo; // Гаж нөлөө
    private  String tseerlelt; // Цээрлэлт
    private  String nemelt; // Нэмэлт мэдлэг
    private  String uilchlel; // Үйлчлэл  Харилцан үйлчилгээ
    private  String zaalt; // Хэрэглэх заалт
    private  String pregnantZaalt; //Жирэмсэн ба хөхүүл үеийн хэрэглээ
    private  String olgoh; // Олгох нөхцөл
    private  String hadgalah; // Хадгалах нөхцөл

    private  String doctorFullName; //Жор бичсэн эмчийн бүтэн нэр
    private  String doctorWorkPlace; //Жор бичсэн эмчийн ажлын байрны нэршил
    private  String doctorRegNum; //Жор бичсэн эмчийн регистрийн дугаар
    private  int type; //Эмийн төрөл
    private LocalDateTime created; //Жор бичсэн өдөр
}
