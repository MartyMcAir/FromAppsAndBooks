package b_Big_Reflect_Annotation.СlassLoader_3606;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
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
                return defineClass(null, temp, 0, temp.length); // конвертим байты в Class<?>
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
}

