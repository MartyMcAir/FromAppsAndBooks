package z_Thread_BiG_Pack.T_WaitNotify_2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try { // ждем вечн пока value не заберу
                wait(); // цикл именно для wait() - !
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Got: " + value);
        notifyAll(); // сообщаем всем нитям в конце
        isValuePresent = false; // назначаем в конце
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try { // ждем вечн пока value не станет доступен
                wait(); // цикл именно для wait() - !
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        System.out.println("Put: " + value);
        notifyAll(); // сообщаем всем нитям в конце
        isValuePresent = true; // назначаем в конце
    }
}
