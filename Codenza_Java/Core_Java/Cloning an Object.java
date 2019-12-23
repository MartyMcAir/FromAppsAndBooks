Cloning an Object

    class MyClass implements Cloneable {
         public MyClass() {
     }
         public Object clone() {
         Cloneable theClone = new MyClass();
         // Initialize theClone.
         return theClone;
     }
}

//Here's some code to create a clone. 

MyClass myObject = new MyClass();
MyClass myObjectClone = (MyClass)myObject.clone();

//Arrays are automatically cloneable: 
int[] ints = new int[]{123, 234};
int[] intsClone = (int[])ints.clone();
