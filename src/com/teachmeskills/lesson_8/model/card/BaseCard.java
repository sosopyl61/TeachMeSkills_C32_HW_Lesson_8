package com.teachmeskills.lesson_8.model.card;

import com.teachmeskills.lesson_8.utils.Constants;

import java.util.Date;

public abstract class BaseCard implements Constants {
    public String cardNumber;
    public int cvv;
    public Date validDate;
    public String cardHolder;
    public String currency;
    public double amount;

    public BaseCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.validDate = validDate;
        this.cardHolder = cardHolder;
        this.currency = currency;
        this.amount = amount;
    }

    // TODO добавить в метод входной параметр "сумма для трансфера"

    /**
     *  Метод проверки лимита карты перед переводом
     *  Метод должен проверять превышает ли сумма перевода лимит для карты
     *  Для каждой карты должна быть своя реализиция с проверкой лимитов в соотвествии с типом карты
     *
     * @return  true - если сумма перевода укладывается в лимиты
     *          false - если сумма перевода больше лимита для карты
     */
    public abstract boolean checkCardLimitTransfer(double transferAmount);

    public void showBaseInfo(){
        System.out.println("Card number: " + cardNumber);
        System.out.println("Amount: " + amount);
        System.out.println("Valid date: " + validDate);
        System.out.println();
    }

}
