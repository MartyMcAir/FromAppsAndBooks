package b_BigTusks.SiteParser_JSOUP_2810.model;

import b_BigTusks.SiteParser_JSOUP_2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String  URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    String url = String.format(URL_FORMAT, "Kiev", 0);


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> listVacancy = new ArrayList<>();
        String siteName = "https://moikrug.ru";
        Document doc = null;
        for(int page = 0; ; page++) {
            try {
                doc = getDocument(searchString, page);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements elements = doc.getElementsByAttributeValue("class", "job");
            elements.addAll( doc.getElementsByAttributeValue("class", "job marked"));
            if (elements.size() != 0) {
                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByClass("title").first().text().trim());
                    vacancy.setSalary(element.getElementsByClass("salary").first().text().trim());
                    vacancy.setCity(element.select("span[class=location]").text().trim());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(siteName + element.select("div[class=title]").first().getElementsByTag("a").attr("href").trim());
                    listVacancy.add(vacancy);
                }
            }
            else break;
        }
        return listVacancy;
    }

    protected Document getDocument(String searchString, int page)throws IOException{
        String html = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(html)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                .referrer("no-referrer-when-downgrade")
                .get();
        String shtml = doc.html();
        return doc;
    }
}
