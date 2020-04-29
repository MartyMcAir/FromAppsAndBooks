package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy_V2 implements Strategy {
    // котор будет передав в String.format. String.format(URL_FORMAT, "Kiev", 3) должно равняться
    //"http://hh.ua/search/vacancy?text=java+Kiev&page=3" или //"http://hh.ru/search/vacancy?text=java+Kiev&page=3"
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> listVacancy = new ArrayList<>();
        Document doc = null;
        for (int page = 0; ; page++) {
            try {
                doc = getDocument(searchString, page);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // в диве на сайте hh - этот vacancy-serp__vacancy - это контейнер каждой найденной вакансии
            Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (elements.size() == 0) {
                break;
            }

            // перебираем элементы полученного контейнера,
            // и авнутр каждого элемента контейнера, перебираем его под "контейнеры"
            // т.е. мой пасер работал по не верному алгоритму
            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                // в контейнере: название должности vacancy-serp__vacancy-title
                vacancy.setTitle(element.getElementsByAttributeValueContaining("data-qa",
                        "vacancy-serp__vacancy-title").text().trim());
                // в контейнере: город вакансии и его улица
                vacancy.setCity(element.getElementsByAttributeValueContaining("data-qa",
                        "vacancy-serp__vacancy-address").text().trim());
                // vacancy-serp__vacancy-employer - название компании нанимателя
                vacancy.setCompanyName(element.getElementsByAttributeValueContaining("data-qa",
                        "vacancy-serp__vacancy-employer").text().trim());

                // опять: название должности vacancy-serp__vacancy-title _ зачем повторно!?
                vacancy.setUrl(element.getElementsByAttributeValueContaining("data-qa",
                        "vacancy-serp__vacancy-title").attr("href").trim());
                // vacancy-serp__vacancy-compensation - предлагаемая з.п. от нанимателя
                vacancy.setSalary(element.getElementsByAttributeValueContaining("data-qa",
                        "vacancy-serp__vacancy-compensati on").text().trim());
                vacancy.setSiteName(URL_FORMAT);
                listVacancy.add(vacancy);
            }
        }
        return listVacancy;
    }

    public List<Vacancy> getVacancies_MockForValid(String searchString) {
        try {
            Document doc = Jsoup.connect("http://hh.ua/search/vacancy?text=java+%s&page=%d")
                    // Set the request user-agent header.
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36" +
                            " (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                    // Set the request referrer (aka "referer") header.
                    .referrer("no-referrer-when-downgrade")
                    .get();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        // в формат подставляется в URL, вместо %s - "Uzhorod", и вместо %d int page
        String html = String.format(URL_FORMAT, "Uzhorod", page);
        Document doc = Jsoup.connect(html)  //
                // Set the request user-agent header.
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36" +
                        " (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                // Set the request referrer (aka "referer") header.
                .referrer("no-referrer-when-downgrade")
                .get();   // Execute the request as a GET, and parse the result
        String shtml = doc.html();
        return doc;
    }
}

// Aggregator 8
// 1. Работаем только со строкой
//URL_FORMAT =  "http://hh.ua/search/vacancy?text=java+%s&page=%d";
//
//Накой ляд втирают дичь про кешированную версию я так и не понял. Привет разрабам.
//2. Подсказку по зарплате туда же в помойку. Снова пламенный привет.
//
//Пояснения к пунктам задания:
//2.2 "Получи список элементов с атрибутом "vacancy-serp__vacancy"". Ну тут снова привет. "vacancy-serp__vacancy" - это значение атрибута. Сам атрибут называется data-qa. В итоге селект будет такой:
//"[data-qa=vacancy-serp__vacancy]"