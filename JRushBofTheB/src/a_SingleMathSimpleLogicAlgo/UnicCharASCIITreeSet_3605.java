package a_SingleMathSimpleLogicAlgo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Использование TreeSet
//Первым параметром приходит имя файла: файл1.
//файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
//Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
//Если файл1 содержит менее 5 различных букв, то выведи их все.
//Буквы различного регистра считаются одинаковыми.
//Регистр выводимых букв не влияет на результат.
//Закрой потоки.
//
//Пример 1 данных входного файла:
//zBk yaz b-kN
//
//Пример 1 вывода:
//abkny
//
//Пример 2 данных входного файла:
//caAC
//A, aB? bB
//
//Пример 2 вывода:
//abc
//
//Подсказка: использовать TreeSet

// https://javarush.ru/tasks/com.javarush.task.task36.task3605#discussion
// решил _ но созран. т.к. интересна
public class UnicCharASCIITreeSet_3605 {
    private static Set<Character> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        String path = "c:\\z_n\\new_test_folder\\dSimple.txt";

//        List<String> stringsFromFile = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
//        String symbols = String.join("", stringsFromFile);
//        System.out.println(symbols);


        // Потом проверка на соответствие таблице ASCII  (x>=65&&x<=90 || x>=97 && x<=122) , переводим в String
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            int x = 0;
            while ((x = reader.read()) != -1) {
                if ((x >= 65 && x <= 90 || x >= 97 && x <= 122)) {
                    // String.valueOf(x).toLowerCase()
                    set.add(Character.toLowerCase((char) x));
                }
            }
        }
        set.stream().limit(5).forEach(System.out::print);

//        my_V1(args[0]);

//        v2_NotMy(path);
    }

    private static void v2_NotMy(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            TreeSet<String> stringSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

            Stream<String> stream = reader.lines();
            stringSet.addAll(stream.map(s -> s.split("")) // добавляем в стрим мэп и сплитим по "" - ничего!?
                    .flatMap(Arrays::stream) // опять стримы повторять..
                    .filter(c -> c.matches("[A-Za-z]"))
                    .collect(Collectors.toSet()));

            stringSet.stream().limit(5).forEach(System.out::print); // при выводе ставим лиит в 5 и радуемся
        }
    }

    private static void my_V1(String arg) throws IOException {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(arg))))) {
            while (bfr.ready()) {
                String s = bfr.readLine().toLowerCase();
                char[] chars = s.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (Character.isLetter(chars[i]))
                        set.add(chars[i]);
                }
            }
        }

        set.stream().limit(5).forEach(System.out::print);

//        for (int i = 0; i < 5; i++) {
//            Character obj = ((TreeSet<Character>) set).pollFirst();
//            if (obj != null)
//                System.out.print(obj);
//        }
    }
}
