package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) {
//        if (providers.length < 1 | providers.length == 0 | providers == null) // don't valid
//        if (providers == null) // don't valid
        if (providers == null || view == null || providers.length == 0) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
//        List<Vacancy> javaVacancies = new ArrayList<>();
//        for (Provider item : providers) {
////            javaVacancies = item.getJavaVacancies(city);  // don't valid
//            javaVacancies.addAll(item.getJavaVacancies(city));
//        }
//        view.update(javaVacancies);

        // or
//        Arrays.stream(providers).map(p -> p.getJavaVacancies(city))
//                .forEach(javaVacancies::addAll); // don't valid

        view.update(Arrays.stream(providers)
                .map(provider -> provider.getJavaVacancies(city))
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }
}
