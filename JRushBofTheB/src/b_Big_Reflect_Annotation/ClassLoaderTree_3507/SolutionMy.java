package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
// https://javarush.ru/tasks/com.javarush.task.task35.task3507#discussion
// Сам не решил не дошло... каким путем добавлять в Set<? extends Animal>
// _ и кучу дней уже муч.. этот ClassLoader c разных статей
public class SolutionMy {
    public static List<Path> listFiles = new ArrayList<>();

    // странная получается путаница с путями точнее с / or // or .*.*..
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        String pathStr = SolutionMy.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String packagePathStr = SolutionMy.class.getPackage().getName().replaceAll("[.]", "/") + "/data";
//        String packagePathStrMy = Solution.class.getPackage().getName().replace(".", "/");

        Set<? extends Animal> allAnimals = getAllAnimals(pathStr + packagePathStr);
        System.out.println(allAnimals);

//        System.out.println(pathStr); // /C:/z_n/Dropbox/GitHub/JavaRushTasks/out/production/4.JavaCollections/
//        System.out.println(packagePathStrMy); // com.javarush.task.task35.task3507
//        System.out.println(pathStr + packagePathStrMy);  // /C:/z_n/Dropbox/GitHub/JavaRushTasks/out/production/4.JavaCollections/com/javarush/task/task35/task3507


//        String strPath = "/C:/z_n/Dropbox/GitHub/JavaRushTasks/out/production/4.JavaCollections/com/javarush/task/task35/task3507/data";
//        String strPath2 = "C:\\z_n\\Dropbox\\GitHub\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task35\\task3507\\data";
//        Files.walkFileTree(Paths.get(pathStr.substring(1) + packagePathStrMy), new MyVisitor()); // заполняем сет файлами

        listFiles.forEach(v -> System.out.println(v));
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<? extends Animal> resultSet = new HashSet<>();

        // is: /C:/z_n/Dropbox/GitHub/JavaRushTasks/out/production/4.JavaCollections/com/javarush/task/task35/task3507/data
//        System.out.println("is: " + pathToAnimals);
//        String strPath = "/C:/z_n/Dropbox/GitHub/JavaRushTasks/out/production/4.JavaCollections/com/javarush/task/task35/task3507/data";

        Files.walkFileTree(Paths.get(pathToAnimals.substring(1)), new MyVisitor()); // заполняем сет файлами

        for (Path item : listFiles) {
            Class<?> aClass = Class.forName(String.valueOf(item));
            Constructor<?>[] constructors = aClass.getConstructors();

            for (Constructor<?> elem : constructors) {
                // если контруктор public и без параметров
                if (elem.getModifiers() == Modifier.PUBLIC & elem.getParameterCount() == 0) {
//                    Object<? extends Animal> o = (Object<? extends Animal>) aClass.getConstructor().newInstance();
                    Object o = aClass.getConstructor().newInstance();

                    Class<?> aClass2 = aClass.getClass();

                    Class<?> aClass1 = aClass.getClass();
//                    if (aClass1 instanceof Animal)

                    if (Animal.class.isAssignableFrom(aClass2)) {
//                        resultSet.add(aClass2); //  cannot bee appealed

//                    if (o instanceof Animal) // instanceof - не прокатит
//                    Animal<? extends Animal> o1= (Animal<? extends Animal>) aClass.getConstructor().newInstance();
                    }

                }
            }
        }

        return resultSet;
    }


    public static class MyVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            System.out.println("Walk is Run for file: " + file.getFileName());

            if (attrs.isRegularFile() & file.toString().toLowerCase().endsWith(".class")) {
//                File file1 = new File(file.toString());
                listFiles.add(file);
//                System.out.println("added file is: " + file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public static class MyClassLoader extends ClassLoader {

    }
}
