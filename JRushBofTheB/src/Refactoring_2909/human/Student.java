package Refactoring_2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private int age;
    private String name;
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public int getCourse() {
        return course;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

//    public void printData() {
//        System.out.println("Студент: " + name);
//    }

//    public void incAverageGradeBy01() {
//        averageGrade += 0.1;
//    }
//
//    public void incAverageGradeBy02() {
//        averageGrade += 0.2;
//    }

    public void incAverageGrade(double delta) {
//        double res = 0.1 + 0.2; // 0.3
//        res /= 2; // 0.3 / 2 =  _ среднее значение
//        averageGrade = delta - res; // данное значение минус среднее = дельта
        // но у нас и есть дельта _ исходя из нее надо, что !? averageGrade!?

        // Метод incAverageGrade(double) должен инкрементировать средний балл
        // студента на полученную в качестве параметра дельту.
        setAverageGrade(getAverageGrade() +delta);
//        averageGrade = averageGrade + delta;
    }

//    public void setValue(String name, double value) {
//        if (name.equals("averageGrade")) {
//            averageGrade = value;
//            return;
//        }
//        if (name.equals("course")) {
//            course = (int) value;
//            return;
//        }
//    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
//        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}