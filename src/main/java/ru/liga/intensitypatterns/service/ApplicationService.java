package ru.liga.intensitypatterns.service;

import lombok.RequiredArgsConstructor;
import ru.liga.intensitypatterns.factory.ApproverFactory;
import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.role.Approver;

@RequiredArgsConstructor
public class ApplicationService {

    private final ApproverFactory approverFactory;

    /**
     * Отправляем заявку на одобрение менеджером/вип-менеджером или директором и происходит процесс работы сотрудником с заявкой
     *
     * @param application - заявка
     */
    public void sendOnApprove(Application application) {
        Approver approver = approverFactory.getApprover(application.getCreditAmount());
        approver.review(application);
        approver.approve(application);
        approver.sign(application);

        System.out.println("Заявка на кредит была обработана, одобрена и подписана. ");
        System.out.println("Должность/подпись");
        System.out.println(application.getApprovedBy());
        System.out.println("________________________________________________________");
    }

    public void createAgreement(Application application) {
        System.out.println("Создаем договор по заявке " + application.getName());
    }
}