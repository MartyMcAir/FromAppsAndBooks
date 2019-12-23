/*
The hashcode of a Java Object is simply a number, it is 32-bit signed int, that allows an object to be managed by a hash-based data structure. We know that hash code is an unique id number allocated to an object by JVM. But actually speaking, Hash code is not an unique number for an object. If two objects are equals then these two objects should return same hash code. So we have to implement hashcode() method of a class in such way that if two objects are equals, ie compared by equal() method of that class, then those two objects must return same hash code. If you are overriding hashCode you need to override equals method also.

The below example shows how to override equals and hashcode methods. The class Price overrides equals and hashcode. If you notice the hashcode implementation, it always generates unique hashcode for each object based on their state, ie if the object state is same, then you will get same hashcode. A HashMap is used in the example to store Price objects as keys. It shows though we generate different objects, but if state is same, still we can use this as key.
*/

import java.util.HashMap;

public class MyHashcodeImpl
{

    public static void main(String a[])
    {
        HashMap<Price, String> hm = new HashMap<Price, String>();
        hm.put(new Price("Banana", 20), "Banana");
        hm.put(new Price("Apple", 40), "Apple");
        hm.put(new Price("Orange", 30), "Orange");
        //creating new object to use as key to get value
        Price key = new Price("Banana", 20);
        System.out.println("Hashcode of the key: "+key.hashCode());
        System.out.println("Value from map: "+hm.get(key));
    }
}

class Price
{

    private String item;
    private int price;

    public Price(String itm, int pr)
    {
        this.item = itm;
        this.price = pr;
    }

    public int hashCode()
    {
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = price*20;
        hashcode += item.hashCode();
        return hashcode;
    }

    public boolean equals(Object obj)
    {
        System.out.println("In equals");
        if (obj instanceof Price)
            {
                Price pp = (Price) obj;
                return (pp.item.equals(this.item) && pp.price == this.price);
            }
        else
            {
                return false;
            }
    }

    public String getItem()
    {
        return item;
    }
    public void setItem(String item)
    {
        this.item = item;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }

    public String toString()
    {
        return "item: "+item+"  price: "+price;
    }
}
