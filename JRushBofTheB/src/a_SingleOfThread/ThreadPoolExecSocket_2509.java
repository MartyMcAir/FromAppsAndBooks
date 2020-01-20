package a_SingleOfThread;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

/* 
Все не так легко, как кажется
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2509#discussion
// 1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable.
//2. Реализуй логику метода cancel в классе SocketTask.
//3. Реализуй логику метода cancel для локального класса внутри метода newTask в классе SocketTask.
//
//
//Требования:
//1. Определение класса SocketTask, его поля и сигнатуры методов менять нельзя.
//2. Метод cancel в классе SocketTask должен закрывать используемые классом ресурсы.
//3. Метод cancel для локального класса внутри метода newTask должен закрывать ресурсы SocketTask и вызвать cancel у родительского класса.
//4. Метод у родительского класса должен быть вызван, даже если во время закрытия ресурсов было выкинуто исключение.

// не понял, что требуется super.cancel(); _ копи паст
public class ThreadPoolExecSocket_2509 extends ThreadPoolExecutor {
    public ThreadPoolExecSocket_2509(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }

    public interface CancellableTask<T> extends Callable<T> {
        void cancel() throws IOException;

        RunnableFuture<T> newTask();
    }

    public abstract class SocketTask<T> implements CancellableTask<T> {
        private Socket socket;

        protected synchronized void setSocket(Socket socket) {
            this.socket = socket;
        }

        public synchronized void cancel() {
            //close all resources here
            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }

        public RunnableFuture<T> newTask() {
            return new FutureTask<T>(this) {
                public boolean cancel(boolean mayInterruptIfRunning) {
                    //close all resources here by using proper SocketTask method
                    //call super-class method in finally block
                    try {
                        socket.close();
                    } catch (IOException ignored) {
                    } finally {
                        // должен освобождать включая родительские классы
                        super.cancel(mayInterruptIfRunning);
                    }
                    return true;
                }
            };
        }
    }
}