package com.teachmeskills.lesson_8.model.document;

import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты
// TODO создать метод для вывода информации о чеке на экран
public class Check {
    private final double transferAmount;
    private final Date transferDate;
    private final String cardNumber;
    private final String comment;

    public Check(String cardNumber, Date transferDate, double transferAmount, String comment) {
        this.cardNumber = cardNumber;
        this.transferDate = transferDate;
        this.transferAmount = transferAmount;
        this.comment = comment;
    }

    public void showCheckInfo() {
        System.out.println("Card number: " + cardNumber);
        System.out.println("Transfer amount: " + transferAmount);
        System.out.println("Transfer date: " + transferDate);
        System.out.println("Comment: " + comment);
        System.out.println();
    }
}
