package ru.liga.intensitypatterns.model.role;

import ru.liga.intensitypatterns.model.Application;

public interface Approver {

    void review(Application application);

    void approve(Application application);

    void sign(Application application);
}