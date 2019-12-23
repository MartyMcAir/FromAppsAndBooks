Fibonacci numbers (Right side)

import java.text.*;

    public class TestRight {
        public static void main(String args[]) {
        long f1 = 1;
        long f2 = 1;
        RightFormat rf = new RightFormat(20);
        
        System.out.println("Test of RightFormat(20) on Fibonacci numbers:");
            for(int ix = 0; ix < 32; ix++) {
            System.out.println(rf.format(Long.toString(f1)));
            System.out.println(rf.format(Long.toString(f2)));
            f1 = f1 + f2;
            f2 = f2 + f1;
        }
    }
}
