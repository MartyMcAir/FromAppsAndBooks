package b_Big_Reflect_Annotation.СlassLoader_3606;

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
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File file = new File(packageName);
        String[] classFiles = file.list();

        for (String filePath : classFiles) {
            final String finalPath = file.getAbsolutePath() + File.separator;
            ClassLoader loader = getClassLoader(finalPath);

            Class clazz = null;
            clazz = loader.loadClass(filePath.substring(0, filePath.lastIndexOf(".")));

            if (HiddenClass.class.isAssignableFrom(clazz)) {
                hiddenClasses.add(clazz);
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clazz : hiddenClasses) { // перебор списка файлов из списка

            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) { // перебор конструкторов текущего файла класса
                        if (constructor.getParameterTypes().length == 0) { // если конструктор без параметров
                            constructor.setAccessible(true); // делаем его доступным если приватный
                            // отправляем instance класса с кастом к (HiddenClass)
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

    private ClassLoader getClassLoader(String finalPath) {
        return new ClassLoader() {
            @Override
            protected Class<?> findClass(String className) throws ClassNotFoundException {
                // получаем байты из файла
                byte[] temp = getBytesFromFileMy(finalPath + className + ".class");
                return defineClass(null, temp, 0, temp.length);
            }
        };
    }

    private byte[] getBytesFromFileMy(String fileName) {   // my way
        try (InputStream in = new FileInputStream(new File(fileName))) {
            byte[] bytes = new byte[in.available()];
            for (int i = 0, n = 0; (n = in.read()) != -1; i++)
                bytes[i] = (byte) n;
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    // вариант с гита _ с учетом chunks _ - которых конечно в java файлах нет _ это ведь не JPEG и не MP3
    // или под chunk - имелось что-то другое!?
    private byte[] getBytesFromFile(String fileName) {
        File file = new File(fileName); // оч. странно..
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (Exception e) {
            return null;
        }

        BufferedInputStream bis = new BufferedInputStream(fis); // поток не закрыли ..close()
        int size = (int) file.length();
        byte[] b = new byte[size];
        int rb = 0;
        int chunk = 0;
        try {
            while (((int) size - rb) > 0) {
                chunk = bis.read(b, rb, (int) size - rb);
                if (chunk == -1) {
                    break;
                }
                rb += chunk;
            }
        } catch (IOException e) {
            try {   // оч. странно..
                throw new ClassNotFoundException();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            return null;
        }
        return b;
    }
}

