/*
Singleton class means you can create only one object for the given class.
You can create a singleton class by making its constructor as private,
so that you can restrict the creation of the object.
Provide a static method to get instance of the object, wherein you can handle
the object creation inside the class only. In this example we are creating
object by using static block.
*/

public class MySingleton
{

    private static MySingleton myObj;

    static
    {
        myObj = new MySingleton();
    }

    private MySingleton()
    {
    }

    public static MySingleton getInstance()
    {
        return myObj;
    }

    public void testMe()
    {
        System.out.println("Hey.... it is working!!!");
    }

    public static void main(String a[])
    {
        MySingleton ms = getInstance();
        ms.testMe();
    }
}
