package z_Thread_BiG_Pack.T_ConcurrentMapExecutorS_2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;
    private final AtomicInteger i1 = new AtomicInteger();

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

//    @Override
//    public void run() {
//        Thread currentThread = Thread.currentThread();
//        int i = 1;
//        while (!currentThread.isInterrupted()) {
//            try {
//                currentThread.setName("[thread-" + i + "]");
//                map.put(String.valueOf(i), "Some text for " + i);
//                i++;
//                Thread.sleep(500);
//            } catch (Exception e) {
//                System.out.println(currentThread.getName() + " thread was terminated");
//            }
//        }
//    }

    // Вывод совпадает но валик не принимает. Что происходит.
    //
    //- метод  executorService.shutdownNow() вызывает Thread.currentThread().interrupt()
    // у обоих потоков Consumer и Producer
    //
    //- у потоков статус прерывания устанавливается в true,  а так как у потока Producer
    // в sleep() происходит проверка этого флага, то при true, sleep() выбрасывает исключение,
    // но так как try-catch внутри цикла, то выход из цикла не происходит.
    // А значит map продолжает бесконечно заполняться значениями.
    //
    //- вывод совпадает, так как поток Consumer штатно завершает работу выйдя из цикла по условию
    // !currentThread.isInterrupted(), успевая вывести на экран только 4 значения

    @Override // все работает почему не принимает нз..
    public void run() {
        int i = 0;
//        while (!Thread.interrupted()) {
        try { // валидатор хотел чтоб try был снаружи цикла
            while (true) {
                i++;
                i1.incrementAndGet();
                map.put(i1.get() + "", "Some text for " + i1.get());
//                map.put(i + "", "Some text for " + i);
                Thread.sleep(500);
//                break;
            }
        } catch (Exception e) {
//            } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
//                e.printStackTrace();
        }
    }
}
