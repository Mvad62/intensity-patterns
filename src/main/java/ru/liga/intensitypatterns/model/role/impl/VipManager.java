package ru.liga.intensitypatterns.model.role.impl;


import lombok.RequiredArgsConstructor;
import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ApplicationStatus;
import ru.liga.intensitypatterns.model.role.Approver;

@RequiredArgsConstructor
public class VipManager implements Approver {

    private final String fio;

    @Override
    public void review(Application application) {
        application.setStatus(ApplicationStatus.PROCESSING);
    }

    @Override
    public void approve(Application application) {
        application.setStatus(ApplicationStatus.APPROVED);
    }

    @Override
    public void sign(Application application) {
        application.setApprovedBy("Менеджер VIP клиентов: " + fio);
    }
}