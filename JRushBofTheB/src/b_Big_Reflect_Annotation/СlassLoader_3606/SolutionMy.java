package com.javarush.task.task36.task3606;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3606#discussion
// опять загвоздка с путями..
public class SolutionMy {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public SolutionMy(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        String localPath = SolutionMy.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        SolutionMy solution = new SolutionMy(localPath + "com/javarush/task/task36/task3606/data/second");

        solution.scanFileSystem();
//        solution.getHiddenClasses().forEach(v -> System.out.println(v));


        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File file = new File(packageName);
        String[] pathsArr = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        for (String item : pathsArr) {
            final String finalPath = file.getAbsolutePath() + File.separator; // not my
//            ClassLoader classLoader = getClassLoader(item); // my wrong
            ClassLoader classLoader = getClassLoader(finalPath);

//            Class<?> aClass = Class.forName(item, true, classLoader); // my
            Class<?> aClass = classLoader.loadClass(item.substring(0, item.lastIndexOf(".")));

            if (HiddenClass.class.isAssignableFrom(aClass)) // not my _ у меня проверки не было
                hiddenClasses.add(aClass);
//            System.out.println("added is: " + item);
        }
    }

    // c перебором массива not my
    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clazz : hiddenClasses) {

            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    //  вариант без еребора всех конструкторов не прокатывает,
                    //  да и есть private конструктор у SecondHiddenClassImpl
//                    return (HiddenClass) clazz.getConstructor().newInstance();

                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }

    // опять что-то с путями
    public HiddenClass getHiddenClassObjectByKeyMy(String key) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HiddenClass resultClass = null;

        File file = new File(packageName);
        String[] pathsArr = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        // или перебирать из уже готового hiddenClasses - списка !?
        for (String item : pathsArr) {

            if (new File(item).getName().toLowerCase().startsWith(key)) { // если соответствует ключу
                final String finalPath = file.getAbsolutePath() + File.separator; // not my
//            ClassLoader classLoader = getClassLoader(item); // my wrong
                ClassLoader classLoader = getClassLoader(finalPath);

                // получили объект класса Class
                Class<?> aClass = Class.forName(item, true, classLoader);
                // получили из него instance
                resultClass = (HiddenClass) aClass.getConstructor().newInstance();
            }
        }
        return resultClass;
    }

    private ClassLoader getClassLoader(String finalPath) {
        return new ClassLoader() {
            @Override
            protected Class<?> findClass(String className) throws ClassNotFoundException {
                // FileNotFoundException ____ опять exception из-за путей...

//                byte[] bytes = getBytesFromPath(packageName + className + ".class"); // получаем массива байтов файла
//                byte[] bytes = getBytesFromPath(packageName.replace("data/second", "data.second/") // my

                byte[] bytes = getBytesFromPath(finalPath + className + ".class"); // not my
                // возвращаем Class<?> из метода defineClass(..) - полученный из наших байтов
                return defineClass(null, bytes, 0, bytes.length);
            }
        };
    }

    private byte[] getBytesFromPath(String name) {
        byte[] bytes = new byte[0];
        try (InputStream in = new FileInputStream(new File(name))) {
            bytes = new byte[in.available()];
            for (int i = 0, n = 0; (n = in.read()) != -1; i++)
                bytes[i] = (byte) n;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public List<Class> getHiddenClasses() {
        return hiddenClasses;
    }
}

