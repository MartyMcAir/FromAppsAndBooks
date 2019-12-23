import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.relation.RoleUnresolved;
import javax.management.relation.RoleUnresolvedList;

public class RoleUnresolvedListImpl
{
    private RoleUnresolvedList roleUnresolvedList;

    /** Constructs an empty RoleUnresolvedList. **/
    public RoleUnresolvedListImpl()
    {
        roleUnresolvedList = new RoleUnresolvedList();
    }

    /**
     * Constructs an empty RoleUnresolvedList with the initial capacity
     * specified.
    **/
    public RoleUnresolvedListImpl(int initialCapacity)
    {
        roleUnresolvedList = new RoleUnresolvedList(initialCapacity);
    }

    /**
     * Constructs a RoleUnresolvedList containing the elements of the List
     * specified, in the order in which they are returned by the List's
     * iterator.
    **/
    public RoleUnresolvedListImpl(List<RoleUnresolved> list)
    {
        roleUnresolvedList = new RoleUnresolvedList(list);
    }

    /** Inserts the specified element at the specified position in this list. **/
    public void add(int index, Object element)
    {
        roleUnresolvedList.add(index, element);
    }

    /**
     * Inserts the unresolved role specified as an element at the position
     * specified.
    **/
    public void add(int index, RoleUnresolved role)
    {
        roleUnresolvedList.add(index, role);
    }

    /** Appends the specified element to the end of this list. **/
    public boolean add(Object o)
    {
        return roleUnresolvedList.add(o);
    }

    /** Adds the RoleUnresolved specified as the last element of the list. **/
    public void add(RoleUnresolved role)
    {
        roleUnresolvedList.add(role);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's Iterator.
    **/
    public boolean addAll(Collection<?> c)
    {
        return roleUnresolvedList.addAll(c);
    }

    /**
     * Inserts all of the elements in the specified collection into this list,
     * starting at the specified position.
    **/
    public boolean addAll(int index, Collection<?> c)
    {
        return roleUnresolvedList.addAll(index, c);
    }

    /**
     * Inserts all of the elements in the RoleUnresolvedList specified into this
     * list, starting at the specified position, in the order in which they are
     * returned by the Iterator of the RoleUnresolvedList specified.
    **/
    public boolean addAll(int index, RoleUnresolvedList roleList)
    {
        return this.roleUnresolvedList.addAll(index, roleList);
    }

    /**
     * Appends all the elements in the RoleUnresolvedList specified to the end
     * of the list, in the order in which they are returned by the Iterator of
     * the RoleUnresolvedList specified.
    **/
    public boolean addAll(RoleUnresolvedList roleList)
    {
        return roleList.addAll(roleList);
    }

    /** Return a view of this list as a List<RoleUnresolved>. **/
    public List<RoleUnresolved> asList()
    {
        return roleUnresolvedList.asList();
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
    **/
    public Object set(int index, Object element)
    {
        return roleUnresolvedList.set(index, element);
    }

    /**
     * Sets the element at the position specified to be the unresolved role
     * specified.
    **/
    public void set(int index, RoleUnresolved role)
    {
        roleUnresolvedList.set(index, role);
    }

    public static void main(String... arg) throws MalformedObjectNameException
    {
        RoleUnresolvedListImpl roleUnresolvedList = new RoleUnresolvedListImpl();
        List<ObjectName> rolelist1 = new LinkedList<ObjectName>();
        rolelist1.add(new ObjectName("domain1", "key1", "value1"));
        rolelist1.add(new ObjectName("domain2", "key2", "value2"));
        roleUnresolvedList.add(0, new RoleUnresolved("rolename1", rolelist1, 1));
        List<ObjectName> roleList2 = new LinkedList<ObjectName>();
        roleList2.add(new ObjectName("domain3", "key3", "value3"));
        roleList2.add(new ObjectName("domain4", "key4", "value4"));
        roleUnresolvedList.add(1, new RoleUnresolved("rolename2", roleList2, 2));
        List<RoleUnresolved> list = roleUnresolvedList.asList();
        int index = 0;
        while (index < list.size())
            {
                System.out.println(list.get(index++) + "\t");
            }
        System.out.println();
    }
}

/*
role name: rolename1; value: domain1:key1=value1, domain2:key2=value2; problem type: 1
role name: rolename2; value: domain3:key3=value3, domain4:key4=value4; problem type: 2
