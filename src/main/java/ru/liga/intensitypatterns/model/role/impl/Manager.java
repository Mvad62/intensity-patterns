package ru.liga.intensitypatterns.model.role.impl;


import lombok.RequiredArgsConstructor;
import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.role.Approver;

@RequiredArgsConstructor
public class Manager extends Approver {

    private final String fio;

    @Override
    public void sign(Application application) {
        application.setApprovedBy("Менеджер Иванов И.И.");
    }
}