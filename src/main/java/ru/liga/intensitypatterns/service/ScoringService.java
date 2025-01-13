package ru.liga.intensitypatterns.service;


import ru.liga.intensitypatterns.model.Application;
import ru.liga.intensitypatterns.model.ScoringResult;

public interface ScoringService {

    ScoringResult getScoringResult(Application application);
}