import java.util.Scanner;

public class Listing3_1{
    
    public static void main(String[] args) {
        // Создаем объект input класса Scanner
        Scanner input = new Scanner(System.in);
        // Переменная для хранения имени пользователя
        String name;
        // Переменная для хранения отчества пользователя
        String surName;
        // Переменная для хранения даты рождения пользователя
        int yearBorn;
        // Переменная для хранения текущего года
        int yearNow;
        // Выводим запрос данных
        System.out.print("Ваше имя: ");
        // Считываем имя (строка)
        name = input.nextLine();
        System.out.print("Ваше отчество: ");
        // Считываем отчество (строка)
        surName = input.nextLine();
        System.out.print("Какой сейчас год? ");
        // Считываем текущий год (целое число)
        yearNow = input.nextInt();
        System.out.print("В каком году вы родились? ");
        // Считываем год рождения (целое число)
        yearBorn = input.nextInt();
        System.out.println("Здравствуйте, "+name+" "+surName+"!");
        System.out.println("Ваш возраст: "+(yearNow-yearBorn)+".");
        
    }
}
