package ru.liga.intensitypatterns.service;

import lombok.extern.slf4j.Slf4j;
import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ScoringResult;

@Slf4j
public class ScoringServiceTimingDecorator implements ScoringService {

    private final ScoringService scoringService;

    public ScoringServiceTimingDecorator(ScoringService scoringService) {
        this.scoringService = scoringService;
    }

    @Override
    public ScoringResult getScoringResult(Application application) {
        long startTime = System.currentTimeMillis();
        ScoringResult result = scoringService.getScoringResult(application);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Скорринг завершен. Время выполнения: {} мс", duration);

        return result;
    }
}