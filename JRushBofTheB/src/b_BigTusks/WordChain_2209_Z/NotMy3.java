package b_BigTusks.WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class NotMy3 {
// код по сложности 6 из 11
    private ArrayList<String> stroka = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String fileName = getPath()[0];
        // выдает 7 из 11
        // Аланга Аланга Амстердам Мельбурн Нью-Йорк Киев Вашингтон
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader fr = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")));
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String txt;
        String stroka = "";
        while ((txt = fr.readLine()) != null) {
            stroka += txt + " ";
        }
        reader.close();
        fr.close();
        String[] words = stroka.split("\\s+"); // проблема кода была в этом месте
        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) throws IOException {
        //----------------- Добавляю СБ
        StringBuilder sb = new StringBuilder();
        //----------------- Если массив больше нуля, то делаем, если нет, то возвращаю пустой СБ
        if (words.length > 0) {
            //------------- Строки первоеСлово и второеСлово , они нужны будут в цикле дальше
            String firstWord;
            String secondWord;
            //-----------------Массивы символо для первого и второго слова , нужны будут для цикла дальше
            char[] first;
            char[] second;
            // Set<String> set = new HashSet<>();
            //-------------- Добавляю Слова в Список
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                list.add(words[i]);
            }
//---------------------------Сортирую список
            Collections.sort(list);
            //--------------- Список отсортирован в алфавитном порядке ,поэтому добавляю первый элемент в СБ
            sb.append(list.get(0));
            //---------------первоеСлово соответствует первому элементу
            firstWord = list.get(0);
            //--------------- начинаю цикл перебора слова
            for (int i = 0; i < list.size(); i++) {
                //------------ Разбиваем первоеСлово на массив символов
                first = firstWord.toCharArray();
                //------------второеСлово присваивает значение элементы из списка соответствующий номеру i
                secondWord = list.get(i);
                //------------ Разьбиваем второеСлово на массив символов
                second = secondWord.toCharArray();
                //------------ Если последний символ первого слова эквивалентен первому символу второго слова то:
                if (String.valueOf(first[first.length - 1]).equalsIgnoreCase(String.valueOf(second[0]))) {
                    //-------- Добавить его в СБ
                    sb.append(" " + secondWord);
                    //-------- Присвоить значение второгоСлова первомуСлову
                    firstWord = secondWord;
                    //--------Удалить этот элемент из списка
                    list.remove(i);
                    //--------Обнулить цикл
                    i = 0;
                }
            }
            return sb;
        } else {
            return sb;
        }
    }

    public static String[] getPath() {
        String folder = "c:\\z_n\\new_test_folder\\1\\";
        return new String[]{folder + "data.txt", folder + "data2.txt", folder + "dataLite.txt"};
    }
}
