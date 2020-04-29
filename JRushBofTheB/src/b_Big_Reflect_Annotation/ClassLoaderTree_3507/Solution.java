package com.javarush.task.task35.task3507;

import javax.security.auth.login.AccountNotFoundException;
import java.io.*;
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
public class Solution {
    public static List<Path> listFiles = new ArrayList<>();

    // странная получается путаница с путями точнее с / or // or .*.*..
    public static void main(String[] args) {
        Class<Solution> solutionClass = Solution.class;
        String pkgPath = solutionClass.getPackage().getName().replaceAll("[.]", "/") + "/data";
        String localPath = solutionClass.getProtectionDomain().getCodeSource().getLocation().getPath();

        Set<? extends Animal> allAnimals = getAllAnimals(localPath + pkgPath);
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> resultSet = new HashSet<>();

        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/"; // коррекция пути на правильный

        // интересны подход получения массива файлов фильтруя их через FilenameFilter
        File file = new File(pathToAnimals);
        String[] modules = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        for (String m : modules) {
            try {
                final String finalPathToAnimals = pathToAnimals; // зачем-то делаем её final _ хотя вроде и так роботит
                ClassLoader loader = getClassLoader(finalPathToAnimals);

                String mName = m.substring(0, m.length() - 6); // обрезание расширения в конце
                Class clazz = loader.loadClass(mName);

                boolean hasInterface = false; // перебор интерфейсов к которым относится данный *.class
                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces) {
                    if (Animal.class.equals(i)) {
                        hasInterface = true;
                        break;
                    }
                }

                if (!hasInterface) continue; // если интерфейс не найен переходить к след интерации

                // если нужный интерфейс найден, то проверяем его конструктор на public и кол-во аргументов в нем
                boolean hasConstructor = false;
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }

                if (!hasConstructor) continue; // если нужного конструктора нет, то переходим к след интерации
                // а иначе добавляем в Set..
                resultSet.add((Animal) clazz.newInstance());
            } catch (Exception e) {
            }
        }
        return resultSet;
    }

    private static ClassLoader getClassLoader(String finalPathToAnimals) {
        return new ClassLoader() {
            @Override
            public Class<?> findClass(String className) throws ClassNotFoundException {
                try {
                    // fetchClassFromFS(..) - байтовая магия
                    byte b[] = myFetchClassFromFS(finalPathToAnimals + className + ".class");
                    return defineClass(null, b, 0, b.length);
                } catch (FileNotFoundException ex) {
                    return super.findClass(className);
                } catch (IOException ex) {
                    return super.findClass(className);
                }
            }
        };
    }

    private static byte[] myFetchClassFromFS(String path) throws FileNotFoundException, IOException {
        // My new way _ // валя ругается на readAllBytes
//        byte[] bytes1 = new byte[0];
//        try (InputStream inputStream = Files.newInputStream(Paths.get(path.substring(1)))) {
////            bytes1 = new byte[inputStream.available()];
////            System.out.println(path);
//            bytes1 = inputStream.readAllBytes(); // валя ругается на readAllBytes
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bytes1;

        // Original almost..
        // _ а тут путь читается со знаком в начале пути / - без substring(1)
        // и Exception не вылетает
        byte[] bytes = new byte[0];
        try (InputStream is = new FileInputStream(new File(path))) {
            long length = new File(path).length();  // Get the size of the file
            if (length > Integer.MAX_VALUE) { // File is too large
            }
            // Create the byte array to hold the data
            bytes = new byte[(int) length];

            int offset = 0;  // Read in the bytes
            int numRead = 0;
            while (offset < bytes.length &&   // поток записывает в массив байтов
                    (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) { // Ensure all the bytes have been read in
                throw new IOException("Could not completely read file " + path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private static byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {  /*NOP*/
        }

        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        is.close();
        return bytes;
    }
}
