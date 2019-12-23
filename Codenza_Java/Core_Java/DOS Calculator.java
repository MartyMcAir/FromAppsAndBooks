DOS Calculator

public class Calculator {
         public static abstract class Operation {
         private final String name;
        
         Operation(String name) { this.name = name; }
        
         public String toString() { return this.name; }
        
         // Perform arithmetic op represented by this constant
         abstract double eval(double x, double y);
        
         // Doubly nested anonymous classes
             public static final Operation PLUS = new Operation("+") {
             double eval(double x, double y) { return x + y; }
         };
             public static final Operation MINUS = new Operation("-") {
             double eval(double x, double y) { return x - y; }
         };
             public static final Operation TIMES = new Operation("*") {
             double eval(double x, double y) { return x * y; }
         };
             public static final Operation DIVIDE = new Operation("/") {
             double eval(double x, double y) { return x / y; }
         };
     }
    
     // Return the results of the specified calculation
         public double calculate(double x, Operation op, double y) {
         return op.eval(x, y);
     }
}

    public class CalcTest {
         public static void main(String args[]) {
         double x = Double.parseDouble(args[0]);
         double y = Double.parseDouble(args[1]);
        
         operate(x, Calculator.Operation.PLUS, y);
         operate(x, Calculator.Operation.MINUS, y);
         operate(x, Calculator.Operation.TIMES, y);
         operate(x, Calculator.Operation.DIVIDE, y);
     }
    
         static void operate(double x, Calculator.Operation op, double y) {
         Calculator c = new Calculator();
         System.out.println(x + " " + op + " " + y + " = " +
         c.calculate(x, op, y));
     }
}
