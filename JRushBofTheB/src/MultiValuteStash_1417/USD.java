package MultiValuteStash_1417;

public class USD extends Money{
    public USD(double amount){
        super(amount);
    }

    @Override
    public String getCurrencyName(){
        return "USD";
    }
}
