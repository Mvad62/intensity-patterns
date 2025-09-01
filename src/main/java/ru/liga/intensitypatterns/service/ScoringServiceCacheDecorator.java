package ru.liga.intensitypatterns.service;

import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ScoringResult;

import java.util.HashMap;
import java.util.Map;

public class ScoringServiceCacheDecorator implements ScoringService {

    private static final Map<Application, ScoringResult> applicationScoringResult = new HashMap<>();
    private final ScoringService scoringService;

    public ScoringServiceCacheDecorator(ScoringService scoringService) {
        this.scoringService = scoringService;
    }

    @Override
    public ScoringResult getScoringResult(Application application) {
        if (applicationScoringResult.containsKey(application)) {
            System.out.println("Результат из кеша");
            return applicationScoringResult.get(application);
        }

        ScoringResult result = scoringService.getScoringResult(application);
        applicationScoringResult.put(application, result);

        return result;
    }
}
