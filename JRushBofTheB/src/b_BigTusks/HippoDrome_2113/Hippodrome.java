package b_BigTusks.HippoDrome_2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<Horse>());

        List<Horse> listH = game.getHorses();
        Horse angela = new Horse("angela", 3, 0);
        Horse ruzana = new Horse("ruzana", 3, 0);
        Horse nebula = new Horse("nebula", 3, 0);

        listH.add(angela);
        listH.add(ruzana);
        listH.add(nebula);

        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> list) {
        this.horses = list;
    }

    public List<Horse> getHorses() {
        return this.horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            move();
            print();
        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse res = null;
//        double tmpMax = Collections.max();
        double tmpMax = 0.0D;
        for (Horse horse : getHorses()) {
            tmpMax = Double.max(horse.getDistance(), tmpMax);
            res = (tmpMax > horse.getDistance()) ? res : horse;
        }
        return res;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
