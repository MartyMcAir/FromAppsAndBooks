import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.relation.Role;
import javax.management.relation.RoleList;

public class RoleListImpl
{
    private RoleList roleList;

    /** Constructs an empty RoleList. **/
    public RoleListImpl()
    {
        roleList = new RoleList();
    }

    /** Constructs an empty RoleList with the initial capacity specified. **/
    public RoleListImpl(int initialCapacity)
    {
        roleList = new RoleList(initialCapacity);
    }

    /**
     * Constructs a RoleList containing the elements of the List specified, in
     * the order in which they are returned by the List's iterator.
    **/
    public RoleListImpl(List<Role> list)
    {
        roleList = new RoleList(list);
    }

    /** Inserts the specified element at the specified position in this list. **/
    public void add(int index, Object element)
    {
        roleList.add(index, element);
    }

    /** Inserts the role specified as an element at the position specified. **/
    public void add(int index, Role role)
    {
        roleList.add(index, role);
    }

    /** Appends the specified element to the end of this list. **/
    public boolean add(Object o)
    {
        return roleList.add(o);
    }

    /** Adds the Role specified as the last element of the list. **/
    public void add(Role role)
    {
        roleList.add(role);
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's Iterator.
    **/
    public boolean addAll(Collection<?> c)
    {
        return roleList.addAll(c);
    }

    /**
     * Inserts all of the elements in the specified collection into this list,
     * starting at the specified position.
    **/
    public boolean addAll(int index, Collection<?> c)
    {
        return roleList.addAll(index, c);
    }

    /**
     * Inserts all of the elements in the RoleList specified into this list,
     * starting at the specified position, in the order in which they are
     * returned by the Iterator of the RoleList specified.
    **/
    public boolean addAll(int index, RoleList roleList)
    {
        return this.roleList.addAll(index, roleList);
    }

    /**
     * Appends all the elements in the RoleList specified to the end of the
     * list, in the order in which they are returned by the Iterator of the
     * RoleList specified.
    **/
    public boolean addAll(RoleList roleList)
    {
        return roleList.addAll(roleList);
    }

    /** vReturn a view of this list as a List<Role>. **/
    public List<Role> asList()
    {
        return roleList.asList();
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
    **/
    public Object set(int index, Object element)
    {
        return roleList.set(index, element);
    }

    /** Sets the element at the position specified to be the role specified. **/
    public void set(int index, Role role)
    {
        roleList.set(index, role);
    }

    public static void main(String... arg) throws MalformedObjectNameException
    {
        RoleListImpl roleList = new RoleListImpl();
        List<ObjectName> rolelist1 = new LinkedList<ObjectName>();
        rolelist1.add(new ObjectName("domain1","key1","value1"));
        rolelist1.add(new ObjectName("domain2","key2","value2"));
        roleList.add(0, new Role("rolename1", rolelist1));
        List<ObjectName> roleList2 = new LinkedList<ObjectName>();
        roleList2.add(new ObjectName("domain3","key3","value3"));
        roleList2.add(new ObjectName("domain4","key4","value4"));
        roleList.add(1, new Role("rolename2", roleList2));
        List<Role> list = roleList.asList();
        int index = 0;
        while (index < list.size())
            {
                System.out.println(list.get(index++) + "\t");
            }
        System.out.println();
    }
}

/*

role name: rolename1; role value: domain1:key1=value1, domain2:key2=value2
role name: rolename2; role value: domain3:key3=value3, domain4:key4=value4
