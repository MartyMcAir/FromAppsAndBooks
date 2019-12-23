Method Overriding

class A {
     String name() { return "A"; }
}

    class B extends A {
     String name() { return "B"; }
}

    class C extends A {
     String name() { return "C"; }
}

    public class Overriding {
         public static void main(String[] args) {
         A[] tests = new A[] { new A(), new B(), new C() };
        
         for (int i = 0; i < tests.length; i++)
         System.out.print(tests[i].name());
     }
}
