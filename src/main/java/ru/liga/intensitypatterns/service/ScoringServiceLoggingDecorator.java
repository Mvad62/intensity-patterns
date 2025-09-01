package ru.liga.intensitypatterns.service;

import lombok.extern.slf4j.Slf4j;
import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ScoringResult;

@Slf4j
public class ScoringServiceLoggingDecorator implements ScoringService {

    private final ScoringService scoringService;

    public ScoringServiceLoggingDecorator(ScoringService scoringService) {
        this.scoringService = scoringService;
    }

    @Override
    public ScoringResult getScoringResult(Application application) {

        log.info("Получен запрос на скорринг {}", application);

        return scoringService.getScoringResult(application);
    }
}