package com.teachmeskills.lesson_8.model.card;

import java.util.Date;

public class VisaCard extends BaseCard{

    int cashback;

    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, double amount, int cashback) {
        super(cardNumber, cvv, validDate, cardHolder, currency, amount);
        this.cashback = cashback;
    }

    @Override
    public boolean checkCardLimitTransfer(double transferAmount) {
        // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит
        return !(transferAmount <= 0) && !(transferAmount > maxTransferAmountForVisa);
    }
}
