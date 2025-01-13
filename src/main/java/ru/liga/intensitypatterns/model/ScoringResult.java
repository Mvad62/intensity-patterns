package ru.liga.intensitypatterns.model;

import java.math.BigDecimal;


public record ScoringResult(Application application,
                            ScoringResultType resultType,
                            BigDecimal amount,
                            Integer term,
                            Double rate, Double eir) {
    @Override
    public String toString() {
        return "ScoringResult{" +
                "application=" + application.getName() +
                ", resultType=" + resultType +
                ", amount=" + amount +
                ", term=" + term +
                ", rate=" + rate +
                ", eir=" + eir +
                '}';
    }
}