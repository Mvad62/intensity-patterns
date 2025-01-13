package ru.liga.intensitypatterns.factory;

import ru.liga.intensitypatterns.model.role.Approver;
import ru.liga.intensitypatterns.model.role.impl.Director;
import ru.liga.intensitypatterns.model.role.impl.Manager;
import ru.liga.intensitypatterns.model.role.impl.VipManager;

import java.math.BigDecimal;

public class ApproverFactory {

    private static final BigDecimal MANAGER_LIMIT = BigDecimal.valueOf(10000);
    private static final BigDecimal VIP_MANAGER_LIMIT = BigDecimal.valueOf(50000);

    private static final String MANAGER_NAME = "Иван Иванович ОбычныйМенеджер";
    private static final String VIP_MANAGER_NAME = "Василий Константинович Випов";
    private static final String DIRECTOR_NAME = "Борис Алексеевич Директоров";

    public Approver getApprover(BigDecimal creditAmount) {
        if (creditAmount.compareTo(MANAGER_LIMIT) < 0) {
            return new Manager(MANAGER_NAME);
        } else if (creditAmount.compareTo(VIP_MANAGER_LIMIT) < 0) {
            return new VipManager(VIP_MANAGER_NAME);
        } else {
            return new Director(DIRECTOR_NAME);
        }
    }
}