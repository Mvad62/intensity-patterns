package ru.liga.intensitypatterns.model;

import java.math.BigDecimal;


public record Client(String fio,
                     int age,
                     String passportSeries,
                     String passportNumber) {

    /**
     * Клиент приходит на сайт банка и вбивает свои данные для получения кредита
     *
     * @param creditAmount - сумма кредита
     * @param creditTerm   - срок кредита
     * @return предзаполненная заявка/анкета
     */
    public Application createApplication(BigDecimal creditAmount, int creditTerm) {

        Application application = new Application(
                "Кредитная заявка для клиента " + fio,
                this,
                creditAmount,
                creditTerm,
                null,
                ApplicationStatus.NEW,
                null,
                null,
                null,
                null);


        System.out.println("Клиент завел заявку на кредит: " + application);
        System.out.println("________________________________________________________");
        return application;
    }
}