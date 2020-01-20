package z_Thread_BiG_Pack.T_PhaserPlantZombie_2809;

import java.util.concurrent.atomic.AtomicInteger;

public class Zombie extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}

