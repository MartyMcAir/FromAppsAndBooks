package a_SingleOfThread;

/* 
Рекурсивное создание нитей
*/
// https://javarush.ru/tasks/com.javarush.task.task16.task1623
//1. Измени класс GenerateThread так, чтобы он стал нитью.
//        2. Создай конструктор GenerateThread, который должен:
//        2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй createdThreadCount.
//        2.2. Запустить текущую нить.
//        2.3. Номер первой нити должен начинается с 1.
//        3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods.
//        Начни печатать toString.
//        3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName().
//
//        Пример:
//        8 created
//
//        4. Пока количество созданных нитей меньше Solution_3105.count метод run должен:
//        4.1. Создать новую нить типа GenerateThread.
//        4.2. Вывести в консоль созданную в пункте 4.1 нить.
//        5. В итоге должно быть выведено в консоль 15 строк.
//
//        Требования:
//        •	Класс GenerateThread должен быть унаследован от Thread.
//        •	В классе GenerateThread должен быть открытый конструктор без параметров.
//        •	Конструктор класса GenerateThread должен увеличивать значение createdThreadCount и
//        передавать его в виде строки в конструктор суперкласса.
//        •	Конструктор класса GenerateThread должен запускать нить.
//        •	Метод toString класса GenerateThread должен возвращать имя нити и слово " created". Пример: "8 created".
//        •	Если количество созданных нитей меньше Solution_3105.count, метод run должен создать новую нить типа GenerateThread.
//        •	Если количество созданных нитей меньше Solution_3105.count, метод run должен вывести созданную нить в консоль.
//        •	Вывод программы должен соответствовать заданию, показывать, что все 15 нитей были созданы.
public class ThreadRecursive_1623 {
    static int count = 15;
    static volatile int createdThreadCount; // volatile одна переменная на все потоки

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
//        if(count==0){
//            Thread.currentThread().interrupt();
//        }
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            // Конструктор класса GenerateThread должен передавать увеличенное значение createdThreadCount
            // в качестве имени в конструктор суперкласса. _ а не createdThreadCount++
            // т.е. сначала увеличиваем значение, а потом передаем
            super(String.valueOf(++createdThreadCount));
            start();
        }

        @Override
        public void run() {
//            int i = 1;
//            while (i < count) {
////                System.out.println(this); // выодит 15 штук с нулями
//                System.out.println(new GenerateThread()); // выодит бесконечное кол-во с кучей цифр
//                i++;
//                if (i == count) {
//                    interrupt();
//                }
//            }
            // в методе "run" не используйте цикл  "fori" т.к. при создании каждой нити "run" запускается новый и цикл
            // "run"начинается с нуля...вот тебе и бесконечная история, пока память не закончится...
//            while(count>createdThreadCount){
//                System.out.println(new GenerateThread());
//            }

            // Если количество созданных нитей меньше Solution_3105.count, метод run должен
            // создать новую нить типа GenerateThread.
            if(createdThreadCount<count){
                System.out.println(new GenerateThread());
            }
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
