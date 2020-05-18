package b_BigTusks.SiteParser_JSOUP_2810.model;

import b_BigTusks.SiteParser_JSOUP_2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy_My implements Strategy {
    // https://moikrug.ru/vacancies?q=java+Dnepropetrovsk    // for examples
    // https://moikrug.ru/vacancies/560164256
    // при реализации задания воспользуйся закешированной версией страницы: http://javarush.ru/testdata/big28data2.html.
//    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s"; // s- city _ wrong
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d"; // right
    // new page is.. d- number for page
//    private static final String URL_FORMAT = "https://career.habr.com/vacancies?page=%d&q=java%20%s&type=all";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> resultList = new ArrayList<>();
        String siteName = "https://moikrug.ru";

        for (int page = 0; ; page++) {
            Document document = getDocument(searchString, page);
//            Elements elements = document.getElementsByAttributeValue("vacancy-card-list__item", "");
//            Elements elements = document.getElementsByClass("vacancy-serp-item"); // for new version site
            Elements elements = document.getElementsByClass("job");
            elements.addAll(document.getElementsByAttributeValue("class", "job marked"));

//            if (elements.size() == 0) break; // такое прерывание цикла не устраивает валидатор

            if (elements.size() != 0) {
                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByClass("title").first().text().trim());
                    vacancy.setSalary(element.getElementsByClass("salary").first().text().trim());
                    vacancy.setCity(element.select("span[class=location]").text().trim());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(siteName + element.select("div[class=title]").first().getElementsByTag("a").attr("href").trim());
                    resultList.add(vacancy);
                }
            } else break;
        }
        return resultList;
    }

    protected Document getDocument(String searchString, int page) {
        Document resultDoc = null;
        String html = String.format(URL_FORMAT, searchString, page);
        try {
            resultDoc = Jsoup.connect(html)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36" +
                            " (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                    .referrer("no-referrer-when-downgrade")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Из объекта Document получи список html-элементов с вакансиями.
        // Для каждого элемента создай объект вакансии и добавь его в возвращающий методом список.
        String shtml = resultDoc.html();
        return resultDoc;
    }
}
