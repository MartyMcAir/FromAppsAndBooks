package b_BigTusks.Turnip_1327;

import java.util.ArrayList;
import java.util.List;

/* 
Репка
*/

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));

        // Работает с моим вариантом
//        plot.add(new Person("Внучка", "Бабку"));
//        plot.add(new Person("Бабка", "Дедку"));
//        plot.add(new Person("Дедка", "Репку"));

        RepkaStory.tell(plot);
    }


}
