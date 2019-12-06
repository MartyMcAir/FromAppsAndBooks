package com.javalessons.task3.solution;

public class Calculator {
    private static final int MONTHS = 12;
    private final int loanAmount;
    private final int years;
    private final double monthlyInterestRate;
    private int extraMonthlyPayment;


    public Calculator(final int loanAmount, final int numberOfYears, double interestRatePerYear) {
        this(loanAmount, numberOfYears, interestRatePerYear, 0);
    }

    public Calculator(final int loanAmount, final int numberOfYears, double interestRatePerYear, int extraMonthlyPayment) {
        this.loanAmount = loanAmount;
        this.years = numberOfYears;
        this.extraMonthlyPayment = extraMonthlyPayment;
        this.monthlyInterestRate = interestRatePerYear / MONTHS;
    }


    void calculateAndPrint() {
        double payment = calcMonthlyPayment(loanAmount, monthlyInterestRate);
        double monthStartBalance = loanAmount;
        double interestAmount = 0.0d;
        int periodCount = 0;
        double monthEndBalance = monthStartBalance;
        System.out.println("MONTH,  STARING_BALANCE,  PAYMENT,  INTEREST,  PRINCIPAL,  ENDING_BALANCE,  TOTAL_INTEREST");
        double monthlyPrincipal = 0.0d;
        while (periodCount < years * MONTHS) {
            periodCount++;
            if (monthEndBalance >= payment) {
                double monthlyInterest = calcMonthlyInterest(monthStartBalance, monthlyInterestRate);
                monthlyPrincipal = calcMonthlyPrincipal(payment, extraMonthlyPayment, monthlyInterest);
                monthEndBalance = calcMonthEndBalance(monthStartBalance, monthlyPrincipal);
                interestAmount += monthlyInterest;
                System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n", periodCount, monthStartBalance,
                        payment + extraMonthlyPayment, monthlyInterest, monthlyPrincipal, monthEndBalance, interestAmount);
                monthStartBalance = monthEndBalance;
                if ((monthlyPrincipal + extraMonthlyPayment) > monthEndBalance) {
                    extraMonthlyPayment = 0;
                }
            } else {
                System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n", periodCount, monthStartBalance,
                        monthEndBalance, 0.0, monthEndBalance, 0.0, interestAmount);
                break;
            }
        }
    }

    /**
     * P = (Pv*R) / [1 - (1 + R)^(-n)]
     */
    double calcMonthlyPayment(int loanAmount, double monthlyInterestRate) {
        return loanAmount * monthlyInterestRate / (1 - Math.pow((1 + monthlyInterestRate), -1 * years * MONTHS));
    }

    private double calcMonthlyInterest(double startingBalance, double monthlyInterestRate) {
        return startingBalance * monthlyInterestRate;
    }

    private double calcMonthlyPrincipal(double payment, double extraMonthlyPayment, double interestAmount) {
        return payment + extraMonthlyPayment - interestAmount;
    }

    private double calcMonthEndBalance(double startingBalance, double principal) {
        return startingBalance - principal;
    }

}
