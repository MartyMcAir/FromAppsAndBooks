package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp2;

public class LinkedMin extends LinkedChain {
    private ChainTest chainTest;

    public LinkedMin(ChainTest chainTest) {
        this.chainTest = chainTest;
    }

    @Override
    public boolean check() {
        if (chainTest.getFilterMin() != 0)
            return chainTest.getDataLength() > chainTest.getFilterMin();
        return true;
    }

    @Override
    public String toString() {
//        System.out.print("LinkedMin _ ");
        return "LinkedMin{" +
//                "chainTest=" + chainTest +
                '}';
    }
}
