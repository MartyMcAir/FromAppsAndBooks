package com.javalessons.task3.task;

class BankMortgage {
    private double loanAmount, // (объем кредита)
            year, // (количество лет на которое берется ипотека)
            interestRate, // (ежегодный процент под который банк выдает кредит)
            extraPayment; // (дополнительный ежемесячный платеж или же сумма,
    // которую вносит плательщик сверх обязательной, например для ускоренного погашения)
    private static final int CONSTANT_IS = 0;

    public BankMortgage(double loanAmount, double year, double interestRate) {
        this.loanAmount = loanAmount;
        this.year = year;
        this.interestRate = interestRate;
    }

    public void clientPay(double extraPayment) {
        this.extraPayment += extraPayment; // то что клиент внёс
    }


    public void evetyMonthPay() { // 100k for 3 years, interestRate every year 5%
    }


    public void accountDisplayCondition() {
        // http://shpargalkablog.ru/2017/08/percentage.html#hundred
        double loanPerYear = loanAmount / year;
        double loanPerMonth = loanPerYear / 12;

        // Ежегодный взимаемый платеж с клиента в погащение долга c учетом ставки
        double loanPercentWithInterestRate = (loanPerYear / 100) * interestRate; // процент от числа
        double loanPercentWithInterestRate2 = (loanPerYear * 0.001) * interestRate; // процент от числа

        // Платеж взимаемый каждый месяцж с клиента в погащение долга c учетом ставки
        double loanPerMonthWithInterestRate = loanPercentWithInterestRate / 12;

        System.out.println(loanPerMonthWithInterestRate);

//        System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n", periodCount, monthStartBalance,
//                payment, monthlyInterest, monthlyPrincipal, monthEndBalance, interestAmount);
    }
}
