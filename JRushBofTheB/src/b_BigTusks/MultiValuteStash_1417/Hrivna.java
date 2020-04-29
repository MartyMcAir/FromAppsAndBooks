package b_BigTusks.MultiValuteStash_1417;

public class Hrivna extends Money{
    public Hrivna(double amount){
        super(amount);
    }
    @Override
    public String getCurrencyName(){
        return "UAH";
    }
}
