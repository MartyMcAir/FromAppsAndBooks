package com.javalessons.task3.task;


public class MortgageCalc {

    public static void main(String[] args) {
        // Вообщем пропускаем это задание _ не вижу смысла + реализация автора курса _ словно отрыжка единорога
        // 100k на 3 года под 5% годовых
        BankMortgage calc = new BankMortgage(100000, 3, 5);
        calc.accountDisplayCondition();
    }
}
