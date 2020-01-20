package z_Thread_BiG_Pack.T_PhaserPlantZombie_2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* 
Plants vs Zombies
*/
// https://javarush.ru/tasks/com.javarush.task.task28.task2809#discussion
// сходу и непонятно.. было но решил _ сам
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        // Объекты Plant & Zombie содержат AtomicInteger
        // и они extends Character, a тот implements Runnable
        // run() - выводит вступ в игру потом метод со случайным слипом и "сообщение умер"
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        // в конструктор Phaser отправлен size() и +1 это главн. метод
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString(); // final для лямбды
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " готовится играть");
                    phaser.arriveAndAwaitAdvance();   //
                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("Игра началась!");
                    }
                    character.run();
                }
            }.start();
        }
        phaser.arriveAndDeregister();   //
    }
}
