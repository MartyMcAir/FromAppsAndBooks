package a_SingleTusks;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
// https://javarush.ru/tasks/com.javarush.task.task19.task1920
// В метод main первым параметром приходит имя файла.
//В этом файле каждая строка имеет следующий вид:
//имя значение
//где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.
//
//Для каждого имени посчитать сумму всех его значений.
//Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
//Имена разделять пробелом либо выводить с новой строки.
//Закрыть потоки.
//
//Пример входного файла:
//Петров 0.501
//Иванов 1.35
//Петров 0.85
//
//Пример вывода:
//Петров
//
//Требования:
//•	Программа НЕ должна считывать данные с консоли.
//•	Программа должна считывать содержимое файла (используй FileReader).
//•	Поток чтения из файла (FileReader) должен быть закрыт.
//•	Программа должна выводить в консоль имена, у которых максимальная сумма.
public class SumAllValuesForName_1920 {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
//        String file1 = arrF[0];
//        String file2 = arrF[1];
        String file1 = args[0];

        TreeMap<String, Double> mapStr = new TreeMap<>();
        LinkedHashMap<String, Double> map = new LinkedHashMap<>();

//        BufferedReader bf = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedReader bf = new BufferedReader(new FileReader(file1));
        String line;
        String[] tmp;
        while ((line = bf.readLine()) != null) {
            tmp = line.split(" ");
//            map.put(tmp[0], Double.parseDouble(tmp[1]));
            mapStr.merge(tmp[0], (Double.parseDouble(tmp[1])), (oldV, newV) -> (oldV + newV));
        }
        bf.close();
//        mapStr.forEach((k, v) -> System.out.println(k + " " + v));

//        for(Double item : map.values()){
//            System.out.println(item);
//        }

//        ArrayList<Double> listMax = (ArrayList<Double>) mapStr.values();   // err
//        ArrayList<Double> listMax = new ArrayList<>(mapStr.values());   // _
//        HashSet<Double> listMax = new HashSet<>(mapStr.values());   // _
//        Collection<String> listMax = mapStr.keySet();   // _


//        listMax.add("test");
//        listMax.forEach((v) -> System.out.println(v + " _"));

        ArrayList<Double> listMax = new ArrayList<Double>();   // _
        listMax.addAll(mapStr.values());
        Collections.sort(listMax, Collections.reverseOrder());
        Double maxD = listMax.get(0);

//        double maximum = map.values()
//                .stream()
//                .max(Double::compareTo)
//                .get();

        double max = Collections.max(mapStr.values());

//        listMax.forEach((v) -> System.out.println(v + " _"));

//        mapStr.forEach((k, v) -> System.out.println(k + " " + v));

        Double tmpD;
        for (Map.Entry<String, Double> pare : mapStr.entrySet()) {
            tmpD = pare.getValue();
//            if (tmpD == maxD) {
            if (isEqual(tmpD, max, 0.0001)) {
//            if (tmpD.equals(max)) {
//                System.out.println(pare.getKey() + " " + maxD);
                System.out.println(pare.getKey());
            }
        }
    }

    public static boolean isEqual(double x, double y, double eps) {
        return Math.abs(x - y) < eps;
    }
}
