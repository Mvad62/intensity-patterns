package ru.liga.intensitypatterns.model.role.impl;


import lombok.RequiredArgsConstructor;
import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.role.Approver;

@RequiredArgsConstructor
public class Director extends Approver {

    private final String fio;

    @Override
    public void sign(Application application) {
        application.setApprovedBy("Директор филиала: " + fio);
    }
}