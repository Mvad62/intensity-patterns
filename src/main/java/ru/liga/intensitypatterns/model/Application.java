package ru.liga.intensitypatterns.model;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Application {

    private final String name;
    private final Client client;
    private final BigDecimal creditAmount;
    private final Integer creditTerm;
    private String product;
    private ApplicationStatus status;
    private String approvedBy;
    private String creditPurpose;
    private Double rate;
    private Double eir;

    private Application(Builder builder) {
        this.name = builder.name;
        this.client = builder.client;
        this.creditAmount = builder.creditAmount;
        this.creditTerm = builder.creditTerm;
        this.product = builder.product;
        this.status = builder.status;
        this.approvedBy = builder.approvedBy;
        this.creditPurpose = builder.creditPurpose;
        this.rate = builder.rate;
        this.eir = builder.eir;
    }

    public static Builder builder(String name, Client client, BigDecimal creditAmount, Integer creditTerm) {
        return new Builder(name, client, creditAmount, creditTerm);
    }

    public String getName() {
        return name;
    }

    public Client getClient() {
        return client;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public Integer getCreditTerm() {
        return creditTerm;
    }

    public String getProduct() {
        return product;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public String getCreditPurpose() {
        return creditPurpose;
    }

    public Double getRate() {
        return rate;
    }

    public Double getEir() {
        return eir;
    }

    public static class Builder {
        private final String name;
        private final Client client;
        private final BigDecimal creditAmount;
        private final Integer creditTerm;

        private String product = "";
        private ApplicationStatus status = null;
        private String approvedBy = "";
        private String creditPurpose = "";
        private Double rate = null;
        private Double eir = null;

        public Builder(String name, Client client, BigDecimal creditAmount, Integer creditTerm) {
            if (name == null) throw new IllegalArgumentException("Name cannot be null");
            if (client == null) throw new IllegalArgumentException("Client cannot be null");
            if (creditAmount == null) throw new IllegalArgumentException("Credit amount cannot be null");
            if (creditTerm == null) throw new IllegalArgumentException("Credit term cannot be null");

            this.name = name;
            this.client = client;
            this.creditAmount = creditAmount;
            this.creditTerm = creditTerm;
        }

        public Builder product(String product) {
            this.product = product != null ? product : "";
            return this;
        }

        public Builder status(ApplicationStatus status) {
            this.status = status;
            return this;
        }

        public Builder approvedBy(String approvedBy) {
            this.approvedBy = approvedBy != null ? approvedBy : "";
            return this;
        }

        public Builder creditPurpose(String creditPurpose) {
            this.creditPurpose = creditPurpose != null ? creditPurpose : "";
            return this;
        }

        public Builder rate(Double rate) {
            this.rate = rate;
            return this;
        }

        public Builder eir(Double eir) {
            this.eir = eir;
            return this;
        }

        public Application build() {
            return new Application(this);
        }
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