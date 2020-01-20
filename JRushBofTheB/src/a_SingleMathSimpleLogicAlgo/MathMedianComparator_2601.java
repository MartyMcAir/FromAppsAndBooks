package a_SingleMathSimpleLogicAlgo;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
// https://javarush.ru/tasks/com.javarush.task.task26.task2601#discussion
// Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
//Верни отсортированный массив от минимального расстояния до максимального.
//Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.
//
//Пример входящего массива:
//13, 8, 15, 5, 17
//медиана - 13
//
//Отсортированный масив:
//13, 15, 17, 8, 5

// не доконца понял
public class MathMedianComparator_2601 {

    public static void main(String[] args) {
        Integer[] intArr = {13, 8, 15, 5, 17};
//        System.out.println(intArr.toString());
//        System.out.println(Arrays.toString(sort(intArr)));
//        sort(13, 8, 15, 5, 17);
//        System.out.println(Arrays.toString(intArr)); // объект массив при этом не изменился! хоть и ссылка..
    }

    public static Integer[] sort1(Integer[] array) {
//        final double median = array.length / 2;
        final double median;
        if (array.length % 2 == 0)
            median = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
        else
            median = array[array.length / 2];
        Arrays.sort(array, (a, b) -> (int) (Math.abs(a - median) - Math.abs(b - median)));
        return array;
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        final double median;
        if (array.length % 2 == 0)
            median = ((double) array[array.length / 2 - 1] + (double) array[array.length / 2]) / 2;
        else
            median = array[array.length / 2];
        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double value = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (value == 0)
                    value = o1 - o2;
                return (int) value;
            }
        };
        Arrays.sort(array, compareByMedian);
        return array;
    }

    public static Integer[] sort2(Integer[] array) {
//    public static int[] sort(int... array) {
        //implement logic here
        Integer median = null, current = null, next = null, tmp = null;
//        int median = 0, current = 0, next = 0, tmp = 0;

        // сортируем по порядку от меньш к больш
//        boolean flag = false;
//        while (!flag) {
//            flag = true;
//            for (int i = 0, j = 1; i < array.length - 1; i++, j++) {
//                current = array[i];
//                next = array[j];
//                if (current > next) {
//                    flag = false;
//                    tmp = current; // сохраняем значение
//                    array[i] = next;
//                    array[j] = tmp;
//                }
//            }
//        }
        // or
        List<Integer> listTmp = new ArrayList<>(Arrays.asList(array));
//        Collections.sort(listTmp, new CompInt()); // как туда медиану прекрутить!?
        Collections.sort(listTmp);
//        System.out.println("listTmp: " + listTmp);
        array = listTmp.toArray(new Integer[array.length]);
//        System.out.println("Arrays.toString: " + Arrays.toString(array));   // [5, 8, 13, 15, 17]


        // логика сортировки!?
        // до медианы в конец _ в обратном порядке
        // после медианы включая нее саму _ в начало по порядку

        // сортируем array согласно условию )(
        median = (array.length / 2);
//        System.out.println(array[median]);
        Deque<Integer> list = new LinkedList<>();
        boolean flag2 = false;
        for (int i = 0, j = median - 1, k = array.length + 1; i < array.length; i++, j--, k--) {
            if (i == median) { // разделение надо в люб. случае иначе add.. хаос
                flag2 = true;
            }
            if (!flag2) { // 8 5
//             до медианы в конец _ в обратном порядке
//                list.addLast(array[j]); // в конец очереди
                list.add(array[j]); // в конец очереди
            }
            if (flag2) { // 13 15 17
//             addFirst - переворачивает порядок
                // а если юзать add добавка идет в конец
                list.addFirst(array[k]); // в начало очереди
            }
        }
//        System.out.println(list);   // [13, 15, 17, 8, 5]

//        for (int i = 0; i < list.size(); i++) {
//            array[i] = ((LinkedList<Integer>) list).get(i);
//        }
        array = list.toArray(new Integer[array.length]);
//        System.out.println(Arrays.toString(array)); // [13, 15, 17, 8, 5]
        return array;
    }

    public static class CompInt implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            // по порядку
            if (o1 > o2) {
                return 1;
            }
            if (o1 < o2) {
                return -1;
            }

            return 0;
        }
    }
}
