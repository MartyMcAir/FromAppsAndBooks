package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    // Путь должен быть относительно корня проекта
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    protected Document getDocument() throws IOException {
        File in = new File(filePath);
        return Jsoup.parse(in, "UTF-8");
    }

    /////////
    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document = null;
        try {
            document = getDocument();
            Element templateElement = document.getElementsByClass("template").first();
            Element patternElement = templateElement.clone();
            patternElement.removeClass("template").removeAttr("style");
            document.getElementsByAttributeValueEnding("class", "vacancy").remove();

            for (Vacancy v : vacancies) {
                Element currentElement = patternElement.clone();

                currentElement.getElementsByClass("city").first().text(v.getCity());
                currentElement.getElementsByClass("companyName").first().text(v.getCompanyName());
                currentElement.getElementsByClass("salary").first().text(v.getSalary());

                Element link = currentElement.getElementsByTag("a").first();
                link.text(v.getTitle());
                link.attr("href", v.getUrl());

                templateElement.before(currentElement.outerHtml());
            }

        } catch (IOException e) {
            e.printStackTrace();
            return ("Some exception occurred");
        }
        return document.html();
    }

    private void updateFile(String s) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
