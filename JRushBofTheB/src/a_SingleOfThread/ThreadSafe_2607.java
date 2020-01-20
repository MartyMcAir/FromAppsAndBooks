package a_SingleOfThread;

/* 
Вежливость - это искусственно созданное хорошее настроение
*/
// https://javarush.ru/tasks/com.javarush.task.task26.task2607#discussion
// В классе Solution создай public static класс IntegerHolder.
//IntegerHolder должен быть для типа int (имя переменной должно быть value), быть thread safe и изменяемым.
//В этом классе должны быть два public метода get и set.
public class ThreadSafe_2607 {
    public static void main(String[] args) {
    }

    // наверное потому что если два потока будут выполнятся на разных ядрах, то значение будет хранится
    // в кешах разных процессоров.  например 1 поток на одном ядре установил какое-то значение через set
    //второй поток на другом ядре  пытается его читать, но он не знает что оно новое,
    // поскольку ядра разные.. чтобы передавать между разными ядрами надо синхронизировать ..
    // ИМХО. Поправьте если я не прав ибо я просто размышляю, но не знаю )

    public static class IntegerHolder {
        private int value;

        public synchronized int get() {
            return value;
        }

        public synchronized void set(int value) {
            this.value = value;
        }
    }
}
