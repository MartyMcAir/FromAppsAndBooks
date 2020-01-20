package zz_pkg_Shildt_Book;

import java.util.ResourceBundle;

public class LRBDemo {
    public static void main(String[] args) {
        // Locale.setDefault(new Locale("ENG"));
        // загрузить комплект ресурсов по умолчанию ENG
//        ResourceBundle rd = ResourceBundle.getBundle("SampleRB"); // Original
//        ResourceBundle rd = ResourceBundle.getBundle("LRBDemo.SampleRB");
        // рабочий вариант from StackOverFlow
        ResourceBundle rd = ResourceBundle.getBundle(SampleRB.class.getName());
        System.out.println("Английская версия программы: ");
        System.out.println("Строка по ключу Title:" + rd.getString("title"));
        System.out.println("Строка по ключу StopText:" + rd.getString("StopText"));
        System.out.println("Строка по ключу StartText:" + rd.getString("StartText"));

        // загруз комплект ресурсов для поддержки немечкого языка
//        rd = ResourceBundle.getBundle("SampleRB", Locale.GERMAN); // Original
//        rd = ResourceBundle.getBundle("LRBDemo.SampleRBde", Locale.GERMAN);
        rd = ResourceBundle.getBundle(SampleRB_de.class.getName());
        System.out.println("\nНемецкая версия программы: ");
        System.out.println("Строка по ключу Title:" + rd.getString("title"));
        System.out.println("Строка по ключу StopText:" + rd.getString("StopText"));
        System.out.println("Строка по ключу StartText:" + rd.getString("StartText"));
    }
}
