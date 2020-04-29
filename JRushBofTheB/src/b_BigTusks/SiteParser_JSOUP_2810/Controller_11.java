package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller_11 {
    private Provider[] providers;

    public Controller_11(Provider... providers) {
        if (providers == null | providers.length < 1)
            throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        // пройдись по всем провайдерам и собери с них все вакансии, добавь их в список.
        // Выведи количество вакансий в консоль.
//        List<Vacancy> vacancies = new ArrayList<>();
//        try {
//            vacancies = Arrays.stream(providers)
//                    .map(provider -> provider.getJavaVacancies(""))
//                    .flatMap(Collection::stream)
//                    .collect(Collectors.toList());
//        } finally {
//            System.out.println(vacancies.size());
//        }
//        System.out.println(vacancies.size());
        ArrayList<Vacancy> allVacancies = new ArrayList<>();
        try {
            for (Provider provider : providers)
                allVacancies.addAll(provider.getJavaVacancies(""));
        } catch (NullPointerException e) {

        }
        System.out.println(allVacancies.size());
    }
}
