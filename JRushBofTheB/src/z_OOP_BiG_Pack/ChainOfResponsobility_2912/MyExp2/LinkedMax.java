package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp2;

public class LinkedMax extends LinkedChain {
    private ChainTest chainTest;

    public LinkedMax(ChainTest chainTest) {
        this.chainTest = chainTest;
    }

    @Override
    public boolean check() {
        if (chainTest.getFilterMax() != 0)
            return chainTest.getDataLength() < chainTest.getFilterMax();
        return true;
    }

    @Override
    public String toString() {
//        System.out.print("LinkedMax _ ");
        return "LinkedMax{" +
//                "chainTest=" + chainTest +
                '}';
    }

}
