package z_OOP_BiG_Pack.OOPinnerClassMagazine_2409;

import java.util.List;

/*
Интернет-магазин продажи джинсов
*/
// https://javarush.ru/tasks/com.javarush.task.task24.task2409#discussion
// интересная задача _ решил не сразу т.к. создал внешние классы в отдел файлах, вместо внутренних
public class Solution {

    public static List<Jeans> allJeans = Util.getAllJeans();

    public static void main(String[] args) {
        for (Jeans jeans : allJeans) {
            System.out.println(jeans);
        }
    }

}
