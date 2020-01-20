package Refactoring_2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private int age;
    private String name;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student res = null;
        for (Student item : students) {
            if (averageGrade == item.getAverageGrade()) {
                res = item;
                break;
            }
        }
        return res;
    }

    // должен возвратить студента с максималиныс средним балом
    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student res = null;
        double max = Double.MIN_VALUE;
        for (Student item : students) {
            if (item.getAverageGrade() > max) {
                max = item.getAverageGrade();
                res = item;
            }
        }
        return res;
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }

    // должен возвратить студента с минимальным средним балом
    public Student getStudentWithMinAverageGrade() {
        Student res = null;
        double min = Double.MAX_VALUE;
        for (Student item : students) {
            if (item.getAverageGrade() < min) {
                min = item.getAverageGrade();
                res = item;
            }
        }
        return res;
    }

    // а второй - отчислить переданного студента (удалять из списка students).
    public void expel(Student student) {
        students.remove(student);
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}