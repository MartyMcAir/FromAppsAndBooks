package b_BigTusks.Refactoring_2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student name) {
        Student student = name;
        students.add(student);
        printInfoAboutStudent(student);

    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {
//        students.contains(index)
        if (index < students.size() && index >= 0) {
            students.remove(index);
        }
    }

    public static void findDimaOrSasha() {
        int resCount = 0;
//        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
//            if (!found) {
            if (students.get(i).getName().equals("Dima")) {
                System.out.println("Студент Dima есть в базе.");
                resCount++;
//                    found = true;
                break;
            }
            if (students.get(i).getName().equals("Sasha")) {
                System.out.println("Студент Sasha есть в базе.");
                resCount++;
//                    found = true;
//                }
                break;
            }
//            if (resCount == 2) { // мое решение не устраивает
//                break;
//            }
        }

// //        Вот как можно было Диму с Сашей удалить красиво:
//        Optional<Student> studentDimaOrSasha = students.stream()
//                .filter(student -> student.getName().equals("Dima") || student.getName().equals("Sasha"))
//                .findAny();
//        if (studentDimaOrSasha.isPresent()) {
//            System.out.println(String.format("Студент %s есть в базе.", studentDimaOrSasha.get().getName()));
//        }
    }
}