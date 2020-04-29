package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Provider {
    Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString) {
        List<Vacancy> resultList = new ArrayList<>();
        // реализуй его логику из расчета, что всех данных хватает.
        if (strategy == null)
            return Collections.emptyList();
        return strategy.getVacancies(searchString);
    }

    /////////
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
