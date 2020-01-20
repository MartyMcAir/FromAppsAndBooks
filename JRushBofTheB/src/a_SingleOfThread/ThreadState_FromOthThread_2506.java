package a_SingleOfThread;

/* 
Мониторинг состояния нити
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2506#discussion
// Мониторинг состояния нити
// Cоздай класс нити LoggingStateThread, которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
//Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
//Метод main не участвует в тестировании.
//
//
//Требования:
//1. Создай класс LoggingStateThread в отдельном файле. Он должен наследовать класс Thread.
//2. Класс LoggingStateThread должен содержать поле нити, за которой он будет следить. Это поле должно инициализироваться через конструктор.
//3. Переопредели метод run в классе LoggingStateThread.
//4. После запуска класс LoggingStateThread должен выводить в консоль изменения состояния переданной нити.
//5. После завершения работы наблюдаемой нити, LoggingStateThread так же должен завершить работу.

// скопипастил хоть и кажется легкая задача..
// только после копипаста поня, зачем написали кмменты NEW RUNNABLE ..
public class ThreadState_FromOthThread_2506 {
    public static void main(String[] args) throws InterruptedException {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        Thread.sleep(100);
        target.start();  //RUNNABLE
        Thread.sleep(100);
        //TERMINATED
    }

    private static class LoggingStateThread extends Thread {
        private Thread target;
        private Thread.State targetState;

        public LoggingStateThread() {

        }

        public LoggingStateThread(Thread target) {
            this.target = target;
            targetState = target.getState();
//        setDaemon(true);
        }

        @Override
        public void run() {
            System.out.println(targetState);

            while (true) {
                if (targetState != target.getState()) {
                    targetState = target.getState();
                    System.out.println(targetState);
                }

                if (targetState == State.TERMINATED) {
                    interrupt();
                    break;
                }
            }
        }
    }

    // Второй вариант решения
    public class LoggingStateThreadV2 extends Thread {
        Thread target;

        public LoggingStateThreadV2(Thread target) {
            this.target = target;
            setDaemon(true);

        }

        @Override
        public void run() {
            State state = this.target.getState();
            System.out.println(state);
            while (state != State.TERMINATED) {
                if (state != this.target.getState()) {
                    state = this.target.getState();
                    System.out.println(state);
                }
            }
        }
    }
}
