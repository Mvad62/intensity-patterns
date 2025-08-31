package ru.liga.intensitypatterns.model.role;

import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ApplicationStatus;

public abstract class Approver {

    public void review(Application application) {
        application.setStatus(ApplicationStatus.PROCESSING);
    }

    public void approve(Application application) {
        application.setStatus(ru.liga.intensitypatterns.model.ApplicationStatus.APPROVED);
    }

    public abstract void sign(Application application);

    public void processApplication(Application application) {
        review(application);
        approve(application);
        sign(application);
    }
}