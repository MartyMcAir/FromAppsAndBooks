package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChainRunner {
    public static void main(String[] args) throws IOException {
        List<MyVisitChain2> list = new ArrayList<>();
        TestServer3 ts1 = new TestServer3();
        ts1.setMinSize(8);

        ts1.setContentLength(6);

        ts1.setMaxSize(5);

//        ts1.setOdd(true);

//        ChainCommon chainCommonMaxMin = new CheckMaxSize(ts1).linkWith(new CheckMinSize(ts1));
//        ChainCommon chainCommonMinMax = new CheckMinSize(ts1).linkWith(new CheckMaxSize(ts1));
//        ChainCommon chainCommonMinMaxOdd = new CheckMinSize(ts1).linkWith(new CheckMaxSize(ts1))
//                .linkWith(new CheckOdd(ts1));

        // срабатывает только одна последняя проверка, ___  причина неизвестна
//        ts1.setChainCommon(chainCommonMaxMin);
//        ts1.setChainCommon(chainCommonMinMax);
//        ts1.setChainCommon(chainCommonMinMaxOdd);

        if (ts1.runAllCheck()) {
            System.out.println("success");
        }
    }
}
