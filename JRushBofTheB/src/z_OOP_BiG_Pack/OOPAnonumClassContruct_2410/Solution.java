package z_OOP_BiG_Pack.OOPAnonumClassContruct_2410;

import java.util.LinkedList;
import java.util.List;

/* 
Рефакторинг, анонимные классы
*/
// https://javarush.ru/tasks/com.javarush.task.task24.task2410#discussion
// запоролся на getIterator(name);
public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
//        class LocalIterator implements Iterator {
//            public LocalIterator() {
//                countItems++;
//                System.out.println(name + " item " + countItems);
//            }
//
//            public Iterator next() {
//                return new LocalIterator();
//            }
//        }
//        return new LocalIterator(); // origin
        final int counter = ++countItems;
        Iterator iterator = new Iterator() {
            {
                System.out.println(name + " item " + counter);
            }

            @Override
            public Iterator next() {
                return getIterator(name);
            }
        };
        return iterator;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
