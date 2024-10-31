package com.teachmeskills.lesson_8;

import com.teachmeskills.lesson_8.fabric.ParserFabric;
import com.teachmeskills.lesson_8.model.account.Account;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.card.MasterCard;
import com.teachmeskills.lesson_8.model.card.VisaCard;
import com.teachmeskills.lesson_8.model.client.IndividualClient;
import com.teachmeskills.lesson_8.model.client.LegalClient;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.VisaCardTransferService;

import java.util.Date;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        // TODO запросить с консоли путь и имя файла
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter path and name of the file: ");
        String fileName = scanner.nextLine();
        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric
        // TODO заменить "" на имя файла, полученное со сканера
        try {
            ParserFabric.createParser(fileName).parseFile(fileName);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // TODO реализовать тестовый сценарий
        // создать двух клиентов
        // каждому клиенту создать два счета и две карты
        IndividualClient individualClient = new IndividualClient("Ilya Rymtsov",
                new Account[]{new Account("100", 1000), new Account("101", 2000)},
                new BaseCard[]{new MasterCard("1234", 132, new Date(), "ILLIA RYMTSOU", "BYN", 1500, "Belarus"),
                        new VisaCard("5678", 565, new Date(), "ILLIA RYMTSOU", "USD", 2000,5)},
                "4327697");
        LegalClient legalClient = new LegalClient("Andrey Makarevich",
                new Account[]{new Account("200", 1500), new Account("201", 2500)},
                new BaseCard[]{new MasterCard("1357", 232, new Date(), "ANDREY MAKAREVICH", "BYN", 2500, "Belarus"),
                        new VisaCard("2468", 665, new Date(), "ANDREY MAKAREVICH", "USD", 3000,8)},
                "8739168");

        BaseCard[] clientCards1 = individualClient.getCards();
        MasterCard masterCard1 = (MasterCard) clientCards1[0];
        VisaCard visaCard1 = (VisaCard) clientCards1[1];

        BaseCard[] clientCards2 = legalClient.getCards();
        MasterCard masterCard2 = (MasterCard) clientCards2[0];
        VisaCard visaCard2 = (VisaCard) clientCards2[1];

        Account[] accounts2 = legalClient.getAccounts();
        Account account2 = (Account) accounts2[0];

        // перевести с карты одного клиента на карту другого сумму денег
        masterCard1.showBaseInfo();
        masterCard2.showBaseInfo();
        MasterCardTransferService  masterCardTransferService = new MasterCardTransferService();
        Check check1 = masterCardTransferService.transferFromCardToCard(masterCard1, masterCard2, 501);
        check1.showCheckInfo();
        masterCard1.showBaseInfo();
        masterCard2.showBaseInfo();

        // перевести с карты одного клинента на счет другого клиента сумму денег
        visaCard1.showBaseInfo();
        account2.showAccountInfo();
        VisaCardTransferService visaCardTransferService = new VisaCardTransferService();
        Check check2 = visaCardTransferService.transferFromCardToAccount(visaCard1, account2, 251);
        check2.showCheckInfo();
        visaCard1.showBaseInfo();
        account2.showAccountInfo();
    }
}
