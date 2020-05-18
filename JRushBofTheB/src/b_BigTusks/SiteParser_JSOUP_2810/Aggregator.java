package b_BigTusks.SiteParser_JSOUP_2810;

import b_BigTusks.SiteParser_JSOUP_2810.model.HHStrategy;
import b_BigTusks.SiteParser_JSOUP_2810.model.Model;
import b_BigTusks.SiteParser_JSOUP_2810.model.MoikrugStrategy;
import b_BigTusks.SiteParser_JSOUP_2810.model.Provider;
import b_BigTusks.SiteParser_JSOUP_2810.view.HtmlView;
import b_BigTusks.SiteParser_JSOUP_2810.view.View;

public class Aggregator {
    public static void main(String[] args) {
//        notValid11();
//        hhRun();
        Provider hh_provider = new Provider(new HHStrategy());
        Provider circle_provider = new Provider(new MoikrugStrategy());

        View view = new HtmlView();
        Model model = new Model(view, hh_provider, circle_provider);
        Controller controller = new Controller(model);
        view.setController(controller);

        ((HtmlView) view).userCitySelectEmulationMethod();
    }

    private static void hhRun() {
        View view = new HtmlView();
        Provider provider = new Provider(new HHStrategy());

        Model model = new Model(view, provider);
        Controller controller = new Controller(model);
        view.setController(controller);

        ((HtmlView) view).userCitySelectEmulationMethod();
    }

    private static void notValid11() {
//        Provider provider = new Provider(new Strategy() {
//            @Override
//            public List<Vacancy> getVacancies(String searchString) {
//                return null;
//            }
//        });
//
//        Controller controller = new Controller(provider);
//        controller.scan();
    }
}
