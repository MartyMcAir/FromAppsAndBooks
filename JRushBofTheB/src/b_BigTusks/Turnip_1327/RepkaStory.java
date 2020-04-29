package b_BigTusks.Turnip_1327;

import java.util.List;

public class RepkaStory {
    static void tell(List<Person> items) {
        Person first;
        Person second;
        for (int i = items.size() - 1; i > 0; i--) {
            first = items.get(i - 1);
            second = items.get(i);
//            first.pull(second);
            second.pull(first);
        }
    }

//    static void tell(List<Person> items) {
//        Person first;
//        Person second;
//
//
//        // Работает с моим вариантом
////        for(Person item : items){
////            item.pull(item);
////        }
//    }


//    static void tell(List<Person> items) {
//        Person first;
//        Person second;
//        for (int i = items.size() - 1; i > 0; i--) {
//            first = items.get(i - 1);
//            second = items.get(i);
//            first.pull(second);
//        }
//    }
}
