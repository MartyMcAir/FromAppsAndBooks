package a_SingleOfThread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/* 
Fork/Join
*/
// https://javarush.ru/tasks/com.javarush.task.task30.task3004#discussion
// решил почти сам _ все понятно - в сравнении с битовыми сдвигами..
// 1. Создай класс BinaryRepresentationTask. Для этого в IntelliJ IDEA на красном имени класса нажми Alt+Enter -> Create Class ...
//(класс должен наследоваться от RecursiveTask<String>). Параметр конструктора - int x.
//2. Реализуй логику метода compute - число должно переводиться в двоичное представление.
//3. Используй методы fork и join.
//4. Пример функциональной реализации - метод binaryRepresentationMethod.
public class ThreadRecursiveTusk_3004 {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        ThreadRecursiveTusk_3004 solution = new ThreadRecursiveTusk_3004();
        String result1 = solution.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }

    public static class BinaryRepresentationTask extends RecursiveTask<String> {
        private final int x;

        public BinaryRepresentationTask(int x) {
            this.x = x;
        }
        // как я понял..
        // необходимо провести декомпозицию функционала в методе binaryRepresentationMethod(..), в метод run()

        // скопировал метод и заменил 1 строчку
        //return binaryRepresentationMethod(b) + result;
        //
        // на 2 строчки с созданием объекта таска с последующим fork и возвратом join
        //
        //скорость выполнения обычной рекурсии по сравнению с fork/join
        //105880ns и 10672306ns
        //~ 100 раз

        @Override
        protected String compute() {
//        BinaryRepresentationTask task = new BinaryRepresentationTask(x);
//        task.fork().complete(BigInteger.valueOf(x).toString(2));
//        return task.join(); // 110

            // Original default example ___ OR
            // то как должно вычитывать _ и этого следуетпровести декомпозицию
            int a = x % 2;
            int b = x / 2;
            String result = String.valueOf(a);
            if (b > 0) {
                BinaryRepresentationTask task = new BinaryRepresentationTask(b);
//            task.fork().complete(String.valueOf(task + result)); // неверное решение
                task.fork();
                return task.join() + result;
            }
            return result; // join() - а тут не то возврщал join() вместо result
        }
    }
}
