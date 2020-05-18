package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp2;

public class LinkedContent extends LinkedChain {
    private ChainTest chainTest;

    public LinkedContent(ChainTest chainTest) {
        this.chainTest = chainTest;
    }

    @Override
    public boolean check() {
        if (chainTest.getFilterContains() != null)
            return chainTest.getContentIs().contains(chainTest.getFilterContains());
        return true;
    }

    @Override
    public String toString() {
//        System.out.print("LinkedContent _ ");
        return "LinkedContent{" +
//                "chainTest=" + chainTest +
                '}';
    }

}
