package ru.liga.intensitypatterns.service;

import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ScoringResult;

import java.util.HashMap;
import java.util.Map;

public class ScoringServiceCachedProxyImpl implements ScoringService {

    private static final Map<Application, ScoringResult> applicationScoringResult = new HashMap<>();
    private final ScoringService scoringService;

    public ScoringServiceCachedProxyImpl() {
        this.scoringService = new ScoringServiceImpl();
    }

    @Override
    public ScoringResult getScoringResult(Application application) {
        if (applicationScoringResult.containsKey(application)) {
            ScoringResult cachedResult = applicationScoringResult.get(application);
            System.out.println("Результат взят из кэша: " + cachedResult);
            return cachedResult;
        } else {
            ScoringResult result = scoringService.getScoringResult(application);
            applicationScoringResult.put(application, result);
            return result;
        }
    }
}