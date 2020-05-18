package b_BigTusks.SiteParser_JSOUP_2810.view;

import b_BigTusks.SiteParser_JSOUP_2810.Controller;
import b_BigTusks.SiteParser_JSOUP_2810.vo.Vacancy;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);

    void setController(Controller controller);
}
