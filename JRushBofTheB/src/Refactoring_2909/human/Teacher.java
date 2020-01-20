package Refactoring_2909.human;

public class Teacher extends UniversityPerson {

    private int age;
    private String name;
    private int numberOfStudents;


    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }


    public void live() {
        teach();
    }

    public void teach() {
    }

//    public void printData() {
//        System.out.println("Преподаватель: " + name);
//    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return "Преподаватель";
    }
}