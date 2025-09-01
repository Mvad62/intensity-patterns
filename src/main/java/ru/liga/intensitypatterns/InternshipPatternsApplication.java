package ru.liga.intensitypatterns;

import ru.liga.intensitypatterns.factory.ApproverFactory;
import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ApplicationStatus;
import ru.liga.intensitypatterns.model.Client;
import ru.liga.intensitypatterns.model.ScoringResult;
import ru.liga.intensitypatterns.model.ScoringResultType;
import ru.liga.intensitypatterns.service.ApplicationService;
import ru.liga.intensitypatterns.service.ScoringService;
import ru.liga.intensitypatterns.service.ScoringServiceCachedProxyImpl;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class InternshipPatternsApplication {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

        Client client = new Client("Коваленко Эдуард Вячеславович", 29, "1212", "123123");
        Application application = client.createApplication(BigDecimal.valueOf(10), 12);

        ApplicationService applicationService = new ApplicationService(
                new ApproverFactory()
        );
        applicationService.sendOnApprove(application);

        ScoringService scoringService = new ScoringServiceCachedProxyImpl();
        ScoringResult result = scoringService.getScoringResult(application);
        ScoringResult result2 = scoringService.getScoringResult(application);
        ScoringResult result3 = scoringService.getScoringResult(application);

        if (anyResultIsApproved(result, result2, result3)) {
            applicationService.createAgreement(application);
            application.setStatus(ApplicationStatus.DONE);
        }
    }

    private static boolean anyResultIsApproved(ScoringResult... results) {
        return Arrays.stream(results)
                .anyMatch(scoringResult -> scoringResult.resultType().equals(ScoringResultType.APPROVED));
    }
}