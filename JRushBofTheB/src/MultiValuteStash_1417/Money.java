package MultiValuteStash_1417;

public abstract class Money {
    private double amount;

    public Money(double amount) {
        this.amount=amount;
    }

//    public abstract double getAmount();

    public abstract String getCurrencyName();

    public double getAmount(){
        return this.amount;
    }
}

