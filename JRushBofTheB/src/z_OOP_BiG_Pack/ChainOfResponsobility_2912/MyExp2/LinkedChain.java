package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp2;

import java.util.Deque;
import java.util.LinkedList;

public abstract class LinkedChain {
    private LinkedChain firstChain, nextChain;

    private static final Deque<LinkedChain> deque = new LinkedList<>(); // одно поле на все экземпляры
    private LinkedChain previous;

    public abstract boolean check();

    public LinkedChain addLast(LinkedChain linkedChain) {
        if (isEmptyFirst()) {
            firstChain = this;
        }
        nextChain = linkedChain;
        return linkedChain;
    }


    public boolean foolCheckLeftToRight() { // when use addLast..
        boolean res = true;
        LinkedChain tmp = firstChain;
        while (tmp != null) {
            System.out.println(tmp);
            if (!tmp.check())
                return false;
            tmp = tmp.nextChain;
        }
        return res;
    }

    public void displayLeftToRight() { // when use addLast..
        System.out.println("Left --> to Right");
        LinkedChain tmp = firstChain;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.nextChain;
        }
    }

    private boolean isEmptyFirst() {
        return (firstChain == null);
    }

    ////////////////////////////////////////////////////
    private boolean isEmptyNext() {
        return (nextChain == null);
    }

    public void displayDeque() {
        System.out.println(deque);
    }

    // Что бы запускать все проверки с конца, стоит юзать список
    public LinkedChain addFirst(LinkedChain linkedChain) {
        deque.addFirst(this);

        if (isEmptyNext()) {
            nextChain = this;
        }
        firstChain = linkedChain;
        return this;

        // from book don't work
//        LinkedChain tmp = linkedChain;
//        tmp.nextChain = this.firstChain;
//        this.firstChain = tmp;
//        return tmp;
    }

    // run From First
    public void displayRgToLf_obj1() { // when use addFirst..
        System.out.println("Right --> to Left");
        LinkedChain tmp = nextChain;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.firstChain;
        }
    }

    public void displayRgToLf_objLast() { // when use addFirst..
        System.out.println("Right --> to Left");
        LinkedChain tmp = nextChain;
//        while (tmp != null) {
//            System.out.println(tmp);
//            tmp = tmp.firstChain;
//        }

        System.out.println(firstChain);
        System.out.println(nextChain);
    }

    ////////////////////
    public boolean foolCheck_V2() { // From ReafactoringGuru _ Don't Work
        if (nextChain == null) {
            return true;
        }
        System.out.println(nextChain);
        return nextChain.check();
    }
    ///////////////

    public void printStack() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement item : stackTrace) {
            System.out.println(item.getClassName());
        }
    }

    public void displayFirst() {
        System.out.println("firstChain: " + firstChain);
    }

    public void displayNext() {
        System.out.println("nextChain: " + nextChain);
    }

    public LinkedChain getNextChain() {
        return nextChain;
    }

    public LinkedChain getFirstChain() {
        return firstChain;
    }
}
