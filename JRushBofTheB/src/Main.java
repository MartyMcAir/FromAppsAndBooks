import a_SingleOfThread.ThreadStopWatchRunner_1612;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        // add - 1252 ms _ 10_000_000 elements
        // add(0, i) - 2653 _ 100_000
        // remove - 1004 _ 100_000
        // get - 23 _ 100_000
        // get - 246 _ 100_000_000

        List<Integer> linkedList = new LinkedList<>();
        // add - 2509 ms _ 10_000_000 elements
        // add(0, i) - 37 _ 1_000_000
        // remove - 6706 _ 100_000
        // get - 12772 _ 100_000 _ если элементов > , то HeapOutOfMemoryException
        meaSureTime(linkedList);
    }

    public static void meaSureTime(List<Integer> list) {
        long start = System.currentTimeMillis();
        //-----------------------------------------------
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i);
//        }
        for (int i = 0; i < 100_000; i++) {
            list.add(0, i);
        }
        //-----------------------------------------------
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

