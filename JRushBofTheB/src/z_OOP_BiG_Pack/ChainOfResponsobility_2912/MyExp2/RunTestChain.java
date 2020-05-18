package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp2;

public class RunTestChain {
    public static void main(String[] args) {
        ChainTest chainTest = new ChainTest();
        chainTest.setFilterMin(6);
        chainTest.setDataLength(14);
        chainTest.setFilterMax(13);

        chainTest.setContentIs("Super Java Program");
        chainTest.setFilterContains("Ja va");

        LinkedChain linkedMax = new LinkedMax(chainTest);
        LinkedChain linkedMin = new LinkedMin(chainTest);
        LinkedChain linkedContent = new LinkedContent(chainTest);

//        linkedMax.addLast(linkedMin);
//        linkedMin.addLast(linkedContent);

//        linkedMax.addFirst(linkedMin);
//        linkedMin.addFirst(linkedContent);

        System.out.println(linkedMax.foolCheck_V2());

//        linkedMax.displayFirst(); // min
//        linkedMax.displayNext();  // max

//        linkedMin.displayFirst(); // content
//        linkedMin.displayNext();  // min


        LinkedChain linkedChain2 = new LinkedMax(chainTest)
                .addLast(new LinkedMin(chainTest))
                .addLast(new LinkedContent(chainTest));

//        linkedChain2.displayDeque();

//        boolean b = linkedChain2.foolCheckLeftToRight();
//        System.out.println(b);


//        System.out.println(linkedMax.foolCheckLeftToRight()); //


//        linkedMax.displayRgToLf_obj1();
//        linkedContent.displayRgToLf_objLast();

    }
}
