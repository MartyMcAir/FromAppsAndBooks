Float datatype

// Static factory version of complex class
    public class Complex1 {
     private final float re;
     private final float im;
    
         private Complex1(float re, float im) {
         this.re = re;
         this.im = im;
     }
    
         public static Complex1 valueOf(float re, float im) {
         return new Complex1(re, im);
     }
    
         public static Complex1 valueOfPolar(float r, float theta) {
         return new Complex1((float) (r * Math.cos(theta)),
         (float) (r * Math.sin(theta)));
     }
    
     // Accessors with no corresponding mutators
     public float realPart() { return re; }
     public float imaginaryPart() { return im; }
    
         public Complex1 add(Complex1 c) {
         return new Complex1(re + c.re, im + c.im);
     }
    
         public Complex1 subtract(Complex1 c) {
         return new Complex1(re - c.re, im - c.im);
     }
    
         public Complex1 multiply(Complex1 c) {
         return new Complex1(re*c.re - im*c.im,
         re*c.im + im*c.re);
     }
    
         public Complex1 divide(Complex1 c) {
         float tmp = c.re*c.re + c.im*c.im;
         return new Complex1((re*c.re + im*c.im)/tmp,
         (im*c.re - re*c.im)/tmp);
     }
    
         public boolean equals(Object o) {
         if (o == this)
         return true;
         if (!(o instanceof Complex1))
         return false;
         Complex1 c = (Complex1)o;
         return (Float.floatToIntBits(re) ==
         Float.floatToIntBits(c.re)) &&
         (Float.floatToIntBits(im) ==
         Float.floatToIntBits(im));
     }
         public int hashCode() {
         int result = 17 + Float.floatToIntBits(re);
         result = 37*result + Float.floatToIntBits(im);
         return result;
     }
    
         public String toString() {
         return "(" + re + " + " + im + "i)";
     }
    
     // Public constants
     public static final Complex1 ZERO = new Complex1(0, 0);
     public static final Complex1 ONE = new Complex1(1, 0);
     public static final Complex1 I = new Complex1(0, 1);
    
         public static void main(String args[]) {
         Complex1 x = Complex1.valueOf(2, 3);
         Complex1 y = Complex1.valueOf(2,-3);
         System.out.println(x + " + " + y + " = " + x.add(y));
         System.out.println(x + " - " + y + " = " + x.subtract(y));
         System.out.println(x + " * " + y + " = " + x.multiply(y));
         System.out.println(x + " / " + y + " = " + x.divide(y));
         System.out.println(x.divide(y).multiply(y));
        
         Complex1 z = Complex1.valueOfPolar(1, (float) (Math.PI/4));
         Complex1 w = Complex1.valueOf(z.realPart(), -z.imaginaryPart());
         System.out.println(z + " * " + w + " = " + z.multiply(w));
     }
}
