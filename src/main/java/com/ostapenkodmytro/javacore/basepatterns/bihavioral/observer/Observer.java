package com.ostapenkodmytro.javacore.basepatterns.bihavioral.observer;

import java.util.List;

public interface Observer {
    void handleEvent(List<String> vacancies);
}
