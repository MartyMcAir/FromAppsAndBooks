package b_BigTusks.Turnip_1327;

public class Person implements RepkaItem{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePadezh() {
        return namePadezh;
    }

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }

    // Code
    public void pull(Person person){
//        System.out.println(person.name+" за "+person.namePadezh);
//        System.out.println(this.name+" за "+this.namePadezh);
//        System.out.println(this.name+" за "+person.namePadezh+".");
//        System.out.println(person.name+" за "+this.namePadezh+".");
//        System.out.println(this.name+" за "+person.namePadezh);
//        System.out.println(name+" за "+person.namePadezh);
        System.out.println(name+" за "+person.getNamePadezh());
    }
}
