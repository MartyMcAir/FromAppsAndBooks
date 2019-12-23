package z_OOP_BiG_Pack.OOPextendsClass_2411;

public class C implements JustAnInterface {
//public class C {
    public C() {
        System.out.print("C");
        B localB = B; // без этой строки вывод: CAYS
    }
}