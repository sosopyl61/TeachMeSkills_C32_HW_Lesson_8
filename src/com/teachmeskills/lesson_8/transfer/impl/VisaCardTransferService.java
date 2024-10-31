package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;

import java.util.Date;

// TODO реализовать имплементацию интерфейса
public class VisaCardTransferService implements CardTransferService {

    @Override
    public Check transferFromCardToCard(BaseCard cardFrom, BaseCard cardTo, double transferAmount) {
        if (cardFrom.checkCardLimitTransfer(transferAmount)) {
            cardFrom.amount -= transferAmount;
            cardTo.amount += transferAmount;
            return new Check(cardFrom.cardNumber, new Date(), transferAmount, "Transfer successful.");
        }
        else {
            return new Check(cardFrom.cardNumber, new Date(), transferAmount, "Transfer failed, limit exceeded.");
        }
    }

    @Override
    public Check transferFromCardToAccount(BaseCard cardFrom, Account accountTo, double transferAmount) {
        if (cardFrom.checkCardLimitTransfer(transferAmount)) {
            cardFrom.amount -= transferAmount;
            accountTo.amount += transferAmount;
            return new Check(cardFrom.cardNumber, new Date(), transferAmount, "Transfer successful.");
        }
        else {
            return new Check(cardFrom.cardNumber, new Date(), transferAmount, "Transfer failed, limit exceeded.");
        }
    }
}
