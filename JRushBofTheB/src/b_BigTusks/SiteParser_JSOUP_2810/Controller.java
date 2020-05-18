package b_BigTusks.SiteParser_JSOUP_2810;

import b_BigTusks.SiteParser_JSOUP_2810.model.Model;

public class Controller {
    private Model model;

    public Controller(Model model) {
        if (model == null) throw new IllegalArgumentException();
        this.model = model;
    }

    public void onCitySelect(String cityName) {
        model.selectCity(cityName);
    }
}
