package b_BigTusks.SiteParser_JSOUP_2810.model;

import b_BigTusks.SiteParser_JSOUP_2810.vo.Vacancy;

import java.util.List;

public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
