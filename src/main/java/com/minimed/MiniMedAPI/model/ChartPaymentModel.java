package com.minimed.MiniMedAPI.model;

import lombok.Data;


@Data
public class ChartPaymentModel {
    private double price; // төлөх төлбөр
    private double discountPack; // Багцын хөнгөлөлт // 1.
    private double discountVip; // Эрхийн хөнгөлөлт // 2.
    private double discountEmergency; // Яаралтай цагийн төрлийн хөнгөлөлт // 3.
    private double discountOutPatient; // Тасгийн хөнгөлөлт // 4.
    private double discountDiagnosis; // A B C Z оношийн хөнгөлөлт // 5.
    private double discountInsurance; // Даатгалын хөнгөлөлт // 6.
    private double discountRepeat; // Давтан үзлэгийн хөнгөлөлт // 7.
    private double discountFamily; // Гэр бүлийн хөнгөлөлт // 8.
    private double discountPercent; // Хувьчилсан буюу гараараа хөнгөлсөн 9.
    private double mainPrice; // Үндсэн дүн буюу хөнгөлөгдөөгүй дүн
    private double mainPriceDis;
}
