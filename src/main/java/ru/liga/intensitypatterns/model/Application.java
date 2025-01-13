package ru.liga.intensitypatterns.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Application {

    private final String name;
    private final Client client;
    private BigDecimal creditAmount;
    private Integer creditTerm;
    private String product;
    private ApplicationStatus status;
    private String approvedBy;
    private String creditPurpose;
    private Double rate;
    private Double eir;

    public Application(String name, Client client, BigDecimal creditAmount, Integer creditTerm, String product, ApplicationStatus status, String approvedBy, String creditPurpose, Double rate, Double eir) {
        assert name != null;
        assert client != null;
        assert creditAmount != null;
        assert creditTerm != null;

        this.name = name;
        this.client = client;
        this.creditAmount = creditAmount;
        this.creditTerm = creditTerm;
        this.product = product;
        this.status = status;
        this.approvedBy = approvedBy;
        this.creditPurpose = creditPurpose;
        this.rate = rate;
        this.eir = eir;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", client=" + client.fio() +
                ", creditAmount=" + creditAmount +
                ", creditTerm=" + creditTerm +
                ", product='" + product + '\'' +
                ", status=" + status +
                ", approvedBy='" + approvedBy + '\'' +
                ", creditPurpose='" + creditPurpose + '\'' +
                ", rate=" + rate +
                ", eir=" + eir +
                '}';
    }
}