package a_SingleOfThread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// https://javarush.ru/tasks/com.javarush.task.task25.task2513#discussion
// Обеспечение отсутствия прерывания важной операции
//Разберись, что делает программа.
//Запусти 10 раз и посмотри в какие моменты происходит "проверка".
//Попробуй добиться выполнения "проверки" после каждого изменения баланса,
// для этого в moveMoney() вызови Thread.yield().
//
//
//Требования:
//1. Класс Solution должен содержать класс Account.
//2. Метод moveMoney() должен перечислять сумму amount с счета from на счет to.
//3. Запусти программу 10 раз и обрати внимание когда происходит проверка.
//4. В методе moveMoney() добавь вызовы Thread.yield().
//5. Снова запусти программу 10 раз, и убедись, что Thread.yield()
// никак не повлиял на результат работы.
public class ThreadYield_2513 {

    private static final Random RANDOM = new Random();

    public static synchronized void moveMoney(Account from, Account to, int amount) throws InterruptedException {
        // рандомный номер транзакции
        int transactionNumber = RANDOM.nextInt(5000);
//         yield() - «пропускает свой ход». Нить из состояния running переходит в состояние
        //  ready, а Java-машина приступает к выполнению следующей нити.

//        TimeUnit.MILLISECONDS.sleep(1); // еще вариант
        // Случайно _ нажал на отправку и этот вариант приняло
        Thread.yield();
        System.out.printf("Транзакция №%d: списание $%d со счета №%d. Баланс: %d.%n",
                transactionNumber, amount, from.getNumber(), from.getBalance());
        Thread.yield();
        from.setBalance(from.getBalance() - amount);
        Thread.yield();

        System.out.printf("Транзакция №%d: зачисление $%d на счет №%d. Баланс: %d.%n",
                transactionNumber, amount, to.getNumber(), to.getBalance());
        Thread.yield();
        to.setBalance(to.getBalance() + amount);

        // Суть задачи до меня не дошла( Поставил Thread.yield() в конце метода
        // moveMoney и валидатор принял
        Thread.yield();
    }

    static class Account {
        private int number;
        private int balance;
        private boolean balanceChanged;

        public Account(int number, int balance) {
            this.number = number;
            this.balance = balance;
        }

        public int getNumber() {
            return number;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
            this.balanceChanged = true;
        }

        public void checkBalance() {
            System.out.println(this.number + ": проверка...");
            this.balanceChanged = false;
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account(44444444, 3000);
        Account a2 = new Account(77777, 10);
        Account a3 = new Account(111, 0);

        Set<Account> accounts = new HashSet<>();
        Collections.addAll(accounts, a1, a2, a3);

        Thread operationThread = new Thread(() -> {
            // в потоке запуск 10 транзакций, где
            // i=i*10 - это переводимая сумма из a1 в a2
            for (int i = 1; i <= 1000; i *= 10) {
                try {
                    moveMoney(a1, a2, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Поток который контролирует операицонный поток
        Thread controlThread = new Thread(() -> {
            // внутри другого потока проверяется другой operationThread,
            // если он isAlive(), перебираем коллекцию Сет аккаунтов
            while (operationThread.isAlive()) {
                // и проверяем их на balanceChanged, если он true,
                //  то в forEach(..) checkBalance поставит на нем false
                accounts.stream().filter(a -> a.balanceChanged).forEach(Account::checkBalance);
                // причем stream().. - сам является потоком, который может parallel()
            }
        });
        // после чего стартуем все Thread's
        controlThread.start();   // сначала контролирющий Thread
        operationThread.start();

        // Я так понял смысл этой задачи:
        //Выделяется 2 нити: одна заходит в метод moveMoney, а вторая следит за изменением поля balanceChanged
        // в объектам Account в коллекции и в случае его изменения вызывает метод checkBalance для объекта Account.
        // НО! Видимо квант времени - время работы первой нити дольше и поэтому вторая нить не успевает вызываться
        // в нужный момент, поэтому после каждой транкзации мы вызываем yeild() тем самым давая исполнятся другой нити.
    }
}
