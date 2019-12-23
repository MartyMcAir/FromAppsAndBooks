/*This is a java program to solve TSP using branch and bound algorithm. Branch and bound (BB or B&B) is an algorithm design paradigm for discrete and combinatorial optimization problems. A branch-and-bound algorithm consists of a systematic enumeration of candidate solutions by means of state space search: the set of candidate solutions is thought of as forming a rooted tree with the full set at the root. The algorithm explores branches of this tree, which represent subsets of the solution set. Before enumerating the candidate solutions of a branch, the branch is checked against upper and lower estimated bounds on the optimal solution, and is discarded if it cannot produce a better solution than the best one found so far by the algorithm.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BranchandBound
{
    static int[][]         wt;                             // Matrix of edge
    // weights
    static String[]        city;                           // Vector of city
    // names
    static int             n;                              // Dimension for wt
    // and city
    static ArrayList<Tour> soln    = new ArrayList<Tour>();
    static int             bestTour;                       // Initialized in
    // init()
    static int             blocked;                        // Ditto
    static boolean         DEBUG   = true;                 // Show
    // accept/reject
    // decisions
    static boolean         VERBOSE = true;                 // Show all tours
    // discovered

    @SuppressWarnings("rawtypes")
    private static class Tour implements Comparable
    {
        int[]          soln;
        int            index;        // In branch-and-bound, start of variable
        int            dist;
        static int     nTours = 0;
        // Best-first based on dist, or DFS based on maxheap of index
        static boolean DFS    = true;
        static boolean DBG    = true;

        /*
         * Presumable edges up to [index-1] have been verified before
         * this constructor has been called. So compute the fixed
         * distance from [0] up to [index-1] as dist.
         */
        private Tour(int[] vect, int index, int[][] wt)
        {
            dist = 0;
            for (int k = 1; k < index; k++)
                // Add edges
                dist += wt[vect[k - 1]][vect[k]];
            if (index == n)
                dist += wt[vect[n - 1]][vect[0]]; // Return edge
            soln = new int[n]; // Deep copy
            System.arraycopy(vect, 0, soln, 0, n);
            this.index = index; // Index to permute
            nTours++; // Count up # of tours
            if (DBG)
                System.out.printf("Idx %d: %s\n", index, toString());
        }

        public int compareTo(Object o)
        {
            Tour rt = (Tour) o;
            int c1 = rt.index - this.index, c2 = this.dist - rt.dist;
            if (DFS)
                return c1 == 0 ? c2 : c1;
            else
                return c2;
        }

        public String toString()
        {
            StringBuilder val = new StringBuilder(city[soln[0]]);
            for (int k = 1; k < n; k++)
                val.append(", " + city[soln[k]]);
            val.append(", " + city[soln[0]]);
            val.append(String.format(" for %d", dist));
            return val.toString();
        }
    }

    private static void init(Scanner inp)
    {
        int sub1, sub2;
        String line;
        n = inp.nextInt();
        wt = new int[n][n];
        city = new String[n];
        // Initially, there are NO edges; hence -1.
        for (sub1 = 0; sub1 < n; sub1++)
            Arrays.fill(wt[sub1], -1);
        inp.nextLine(); // Discard rest of first line
        for (sub1 = 0; sub1 < n; sub1++)
            city[sub1] = inp.nextLine();
        Arrays.sort(city); // Just to be sure (binarySearch)
        inp.nextLine(); // Discard blank spacing line;
        blocked = 0; // Accumulate ALL weights for upper bound
        while (inp.hasNext())
            {
                int head, tail;
                int dist;
                String src, dst;
                line = inp.nextLine(); // E.g.: "George" "Pasco" 91
                // Chop out the double-quoted substrings.
                head = line.indexOf('"') + 1;
                tail = line.indexOf('"', head);
                src = line.substring(head, tail);
                head = line.indexOf('"', tail + 1) + 1;
                tail = line.indexOf('"', head);
                dst = line.substring(head, tail);
                dist = Integer.parseInt(line.substring(tail + 1).trim());
                sub1 = Arrays.binarySearch(city, src);
                sub2 = Arrays.binarySearch(city, dst);
                wt[sub1][sub2] = wt[sub2][sub1] = dist;
                blocked += dist;
            }
        blocked += blocked; // Double the total
        bestTour = blocked; // And initialize bestTour
    }

    // Used below in generating permutations.
    private static void swap(int[] x, int p, int q)
    {
        int tmp = x[p];
        x[p] = x[q];
        x[q] = tmp;
    }

    // Generate the available tours by branch-and-bound.
    // Generate the initial permutation vector, then save that state
    // as the first examined in the branch-and-bound.
    public static void tour()
    {
        int[] vect = new int[n];
        int start;
        Queue<Tour> work = new PriorityQueue<Tour>();
        // First permutation vector.
        for (int k = 0; k < n; k++)
            vect[k] = k;
        start = Arrays.binarySearch(city, "Spokane");
        if (start >= 0)
            {
                vect[start] = 0;
                vect[0] = start;
            }
        work.add(new Tour(vect, 1, wt));
        while (!work.isEmpty())   // Branch-and-bound loop
            {
                Tour current = work.poll();
                int index = current.index;
                vect = current.soln;
                if (index == n)   // I.e., Full permutation vector
                    {
                        if (wt[vect[n - 1]][vect[0]] > 0)   // Return edge?
                            {
                                if (current.dist < bestTour)   // Better than earlier?
                                    {
                                        // Save the state in the list
                                        bestTour = current.dist;
                                        soln.add(current);
                                        if (DEBUG)
                                            System.out.println("Accept " + current);
                                    }
                                else if (DEBUG)
                                    System.out.println("Too long:  " + current);
                            }
                        else if (DEBUG)
                            System.out.println("Invalid:   " + current);
                    }
                else
                    // Continue generating permutations
                    {
                        int k; // Loop variable
                        int hold; // Used in regenerating the original state
                        for (k = index; k < n; k++)
                            {
                                swap(vect, index, k);
                                if (wt[vect[index - 1]][vect[index]] < 0)
                                    continue;
                                work.add(new Tour(vect, index + 1, wt));
                            }
                        // Restore original permutation
                        hold = vect[index];
                        for (k = index + 1; k < n; k++)
                            vect[k - 1] = vect[k];
                        vect[n - 1] = hold;
                    }
            }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception
    {
        String filename = args.length == 0 ? "RoadSet.txt" : args[0];
        Scanner inp = new Scanner(new java.io.File(filename));
        System.out.println("Data read from file " + filename);
        init(inp);
        tour();
        if (VERBOSE)
            {
                System.out.println("Tours discovered:");
                for (Tour opt : soln)
                    System.out.println(opt);
            }
        if (soln.size() == 0)
            {
                System.out.println("NO tours discovered.  Exiting.");
                System.exit(0);
            }
        System.out.println(Tour.nTours + " Tour objects generated.");
        Collections.sort(soln);
        System.out.println("Best tour:  ");
        System.out.println(soln.get(0));
    }
}

/*
Data read from file RoadSet.txt
Idx 1: Spokane, Davenport, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Ritzville, Coulee City, Sprague, Spokane for 0
Idx 2: Spokane, Davenport, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Ritzville, Coulee City, Sprague, Spokane for 38
Idx 2: Spokane, Sprague, Davenport, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Ritzville, Coulee City, Spokane for 36
Idx 3: Spokane, Sprague, Davenport, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Ritzville, Coulee City, Spokane for 72
Idx 3: Spokane, Sprague, Ritzville, Davenport, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Coulee City, Spokane for 59
Idx 4: Spokane, Sprague, Ritzville, Moses Lake, Davenport, Ellensburg, George, Leavenworth, Pasco, Coulee City, Spokane for 101
Idx 4: Spokane, Sprague, Ritzville, Pasco, Davenport, Ellensburg, George, Leavenworth, Moses Lake, Coulee City, Spokane for 141
Idx 5: Spokane, Sprague, Ritzville, Moses Lake, George, Davenport, Ellensburg, Leavenworth, Pasco, Coulee City, Spokane for 132
Idx 5: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Davenport, Ellensburg, George, Leavenworth, Coulee City, Spokane for 173
Idx 5: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Davenport, Ellensburg, George, Leavenworth, Pasco, Spokane for 153
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, George, Ellensburg, Davenport, Leavenworth, Pasco, Coulee City, Spokane for 174
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, George, Leavenworth, Davenport, Ellensburg, Pasco, Coulee City, Spokane for 202
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, George, Pasco, Davenport, Ellensburg, Leavenworth, Coulee City, Spokane for 223
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, George, Coulee City, Davenport, Ellensburg, Leavenworth, Pasco, Spokane for 187
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, George, Ellensburg, Leavenworth, Davenport, Pasco, Coulee City, Spokane for 230
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, George, Ellensburg, Pasco, Davenport, Leavenworth, Coulee City, Spokane for 282
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Davenport, Pasco, Spokane for 321
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Davenport, Pasco, Spokane for 387
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, George, Coulee City, Davenport, Ellensburg, Leavenworth, Pasco, Spokane for 253
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, George, Coulee City, Leavenworth, Davenport, Ellensburg, Pasco, Spokane for 278
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Davenport, Pasco, Spokane for 334
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Pasco, Davenport, Spokane for 442
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, George, Leavenworth, Ellensburg, Davenport, Pasco, Coulee City, Spokane for 258
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, George, Leavenworth, Coulee City, Davenport, Ellensburg, Pasco, Spokane for 293
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Davenport, Coulee City, Spokane for 366
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, George, Leavenworth, Coulee City, Davenport, Ellensburg, Pasco, Spokane for 359
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Davenport, Leavenworth, Coulee City, Spokane for 331
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Davenport, Coulee City, Spokane for 387
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 478
Idx 10: Spokane, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 582
Accept Spokane, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 582
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Davenport, Ellensburg, George, Leavenworth, Pasco, Spokane for 219
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Davenport, Ellensburg, Leavenworth, Pasco, Spokane for 208
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Davenport, Ellensburg, George, Pasco, Spokane for 244
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Ellensburg, Davenport, Leavenworth, Pasco, Spokane for 250
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Leavenworth, Davenport, Ellensburg, Pasco, Spokane for 278
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Pasco, Davenport, Ellensburg, Leavenworth, Spokane for 299
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Davenport, Pasco, Spokane for 306
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Ellensburg, Pasco, Davenport, Leavenworth, Spokane for 358
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Davenport, Pasco, Spokane for 334
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Pasco, Davenport, Spokane for 442
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Pasco, Ellensburg, Davenport, Leavenworth, Spokane for 407
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, George, Pasco, Ellensburg, Leavenworth, Davenport, Spokane for 463
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, Davenport, George, Pasco, Spokane for 300
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Davenport, Ellensburg, Pasco, Spokane for 314
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Davenport, Pasco, Spokane for 342
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, Pasco, Davenport, George, Spokane for 408
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Pasco, Davenport, Spokane for 433
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, Pasco, George, Davenport, Spokane for 499
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Davenport, Pasco, Spokane for 356
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Pasco, Davenport, Ellensburg, Spokane for 405
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Pasco, Davenport, Spokane for 464
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Pasco, Ellensburg, Davenport, Spokane for 513
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Davenport, George, Leavenworth, Coulee City, Spokane for 281
Idx 6: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Davenport, Ellensburg, Leavenworth, Coulee City, Spokane for 264
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Davenport, Leavenworth, Coulee City, Spokane for 306
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Leavenworth, Davenport, Ellensburg, Coulee City, Spokane for 334
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Davenport, Ellensburg, Leavenworth, Spokane for 319
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Davenport, Coulee City, Spokane for 362
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 453
Idx 10: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 557
Accept Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 557
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Davenport, Ellensburg, Leavenworth, Spokane for 385
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Leavenworth, Davenport, Ellensburg, Spokane for 410
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Leavenworth, Ellensburg, Davenport, Spokane for 466
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Leavenworth, Ellensburg, Davenport, Coulee City, Spokane for 390
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Leavenworth, Coulee City, Davenport, Ellensburg, Spokane for 425
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Leavenworth, Coulee City, Davenport, Ellensburg, Spokane for 491
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Davenport, Leavenworth, Coulee City, Spokane for 323
Idx 7: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, Davenport, George, Coulee City, Spokane for 337
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Davenport, Coulee City, Spokane for 393
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Coulee City, Davenport, Leavenworth, Spokane for 378
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Coulee City, Davenport, Leavenworth, Spokane for 444
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Coulee City, Leavenworth, Davenport, Spokane for 469
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Davenport, Spokane for 484
Idx 10: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Davenport, Spokane for 588
Too long:  Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Davenport, Spokane for 588
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Davenport, Coulee City, Spokane for 407
Idx 8: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, George, Spokane for 428
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Coulee City, Davenport, Spokane for 462
Idx 10: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Coulee City, Davenport, Spokane for 566
Too long:  Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Coulee City, Davenport, Spokane for 566
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, George, Spokane for 494
Idx 9: Spokane, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, Coulee City, George, Davenport, Spokane for 483
Idx 5: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Davenport, George, Leavenworth, Moses Lake, Coulee City, Spokane for 249
Idx 5: Spokane, Sprague, Ritzville, Pasco, George, Davenport, Ellensburg, Leavenworth, Moses Lake, Coulee City, Spokane for 232
Idx 5: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Davenport, Ellensburg, George, Leavenworth, Coulee City, Spokane for 213
Idx 6: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Davenport, Ellensburg, Leavenworth, Coulee City, Spokane for 244
Idx 6: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Davenport, Ellensburg, George, Leavenworth, Spokane for 265
Idx 7: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Davenport, Leavenworth, Coulee City, Spokane for 286
Idx 7: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Leavenworth, Davenport, Ellensburg, Coulee City, Spokane for 314
Idx 7: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Davenport, Ellensburg, Leavenworth, Spokane for 299
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Davenport, Coulee City, Spokane for 342
Idx 9: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 433
Idx 10: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 537
Accept Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 537
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Davenport, Ellensburg, Leavenworth, Spokane for 365
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Leavenworth, Davenport, Ellensburg, Spokane for 390
Idx 9: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Davenport, Spokane for 446
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Leavenworth, Ellensburg, Davenport, Coulee City, Spokane for 370
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Leavenworth, Coulee City, Davenport, Ellensburg, Spokane for 405
Idx 9: Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Leavenworth, Coulee City, Davenport, Ellensburg, Spokane for 471
Idx 7: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Davenport, Ellensburg, George, Leavenworth, Spokane for 331
Idx 7: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Davenport, Ellensburg, Leavenworth, Spokane for 320
Idx 7: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, Davenport, Ellensburg, George, Spokane for 356
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Ellensburg, Davenport, Leavenworth, Spokane for 362
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Leavenworth, Davenport, Ellensburg, Spokane for 390
Idx 9: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Davenport, Spokane for 418
Idx 9: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Davenport, Spokane for 446
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, Ellensburg, Davenport, George, Spokane for 412
Idx 8: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, George, Davenport, Ellensburg, Spokane for 426
Idx 9: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Davenport, Spokane for 454
Idx 9: Spokane, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Davenport, Spokane for 468
Idx 6: Spokane, Sprague, Ritzville, Pasco, George, Ellensburg, Davenport, Leavenworth, Moses Lake, Coulee City, Spokane for 274
Idx 6: Spokane, Sprague, Ritzville, Pasco, George, Leavenworth, Davenport, Ellensburg, Moses Lake, Coulee City, Spokane for 302
Idx 6: Spokane, Sprague, Ritzville, Pasco, George, Moses Lake, Davenport, Ellensburg, Leavenworth, Coulee City, Spokane for 263
Idx 6: Spokane, Sprague, Ritzville, Pasco, George, Coulee City, Davenport, Ellensburg, Leavenworth, Moses Lake, Spokane for 287
Idx 7: Spokane, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Davenport, Ellensburg, Leavenworth, Spokane for 315
Idx 8: Spokane, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Davenport, Ellensburg, Leavenworth, Spokane for 381
Idx 8: Spokane, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Leavenworth, Davenport, Ellensburg, Spokane for 406
Idx 9: Spokane, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Leavenworth, Ellensburg, Davenport, Spokane for 462
Idx 7: Spokane, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Davenport, Moses Lake, Coulee City, Spokane for 330
Idx 8: Spokane, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Coulee City, Davenport, Moses Lake, Spokane for 421
Idx 9: Spokane, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Coulee City, Davenport, Moses Lake, Spokane for 487
Idx 9: Spokane, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Coulee City, Moses Lake, Davenport, Spokane for 473
Idx 7: Spokane, Sprague, Ritzville, Pasco, George, Coulee City, Davenport, Ellensburg, Leavenworth, Moses Lake, Spokane for 353
Idx 7: Spokane, Sprague, Ritzville, Pasco, George, Coulee City, Leavenworth, Davenport, Ellensburg, Moses Lake, Spokane for 378
Idx 7: Spokane, Sprague, Ritzville, Pasco, George, Coulee City, Moses Lake, Davenport, Ellensburg, Leavenworth, Spokane for 339
Idx 8: Spokane, Sprague, Ritzville, Pasco, George, Coulee City, Leavenworth, Ellensburg, Davenport, Moses Lake, Spokane for 434
Idx 7: Spokane, Sprague, Ritzville, Pasco, George, Leavenworth, Ellensburg, Davenport, Moses Lake, Coulee City, Spokane for 358
Idx 7: Spokane, Sprague, Ritzville, Pasco, George, Leavenworth, Coulee City, Davenport, Ellensburg, Moses Lake, Spokane for 393
Idx 8: Spokane, Sprague, Ritzville, Pasco, George, Leavenworth, Coulee City, Davenport, Ellensburg, Moses Lake, Spokane for 459
Idx 8: Spokane, Sprague, Ritzville, Pasco, George, Leavenworth, Coulee City, Moses Lake, Davenport, Ellensburg, Spokane for 445
Idx 6: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Davenport, Leavenworth, Moses Lake, Coulee City, Spokane for 291
Idx 6: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Davenport, George, Moses Lake, Coulee City, Spokane for 305
Idx 7: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Davenport, Moses Lake, Coulee City, Spokane for 361
Idx 7: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Davenport, Leavenworth, Coulee City, Spokane for 322
Idx 7: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Coulee City, Davenport, Leavenworth, Moses Lake, Spokane for 346
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Coulee City, Davenport, Leavenworth, Spokane for 374
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Coulee City, Davenport, Leavenworth, Spokane for 440
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Coulee City, Leavenworth, Davenport, Spokane for 465
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Coulee City, Davenport, Leavenworth, Moses Lake, Spokane for 412
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Coulee City, Leavenworth, Davenport, Moses Lake, Spokane for 437
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Coulee City, Moses Lake, Davenport, Leavenworth, Spokane for 398
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Coulee City, Davenport, Moses Lake, Spokane for 452
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Coulee City, Davenport, Moses Lake, Spokane for 518
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Coulee City, Moses Lake, Davenport, Spokane for 504
Idx 7: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Davenport, Moses Lake, Coulee City, Spokane for 375
Idx 7: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, George, Moses Lake, Spokane for 396
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Davenport, Coulee City, Spokane for 406
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Coulee City, Davenport, Moses Lake, Spokane for 430
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Davenport, Spokane for 458
Idx 10: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Davenport, Spokane for 562
Too long:  Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Davenport, Spokane for 562
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Coulee City, Davenport, Moses Lake, Spokane for 496
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Coulee City, Moses Lake, Davenport, Spokane for 482
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, George, Moses Lake, Spokane for 462
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, George, Davenport, Moses Lake, Spokane for 451
Idx 8: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, Moses Lake, Davenport, George, Spokane for 448
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, Moses Lake, George, Davenport, Spokane for 479
Idx 9: Spokane, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, George, Moses Lake, Davenport, Spokane for 482
Idx 4: Spokane, Sprague, Davenport, Coulee City, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Ritzville, Spokane for 138
Idx 5: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Leavenworth, Moses Lake, Pasco, Ritzville, Spokane for 193
Idx 5: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Spokane for 229
Idx 5: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ellensburg, George, Leavenworth, Pasco, Ritzville, Spokane for 190
Idx 6: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Ritzville, Spokane for 221
Idx 6: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Spokane for 262
Idx 6: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Ellensburg, George, Leavenworth, Pasco, Spokane for 232
Idx 7: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Ritzville, Spokane for 263
Idx 7: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Spokane for 291
Idx 7: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Ritzville, Spokane for 312
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Ritzville, Spokane for 319
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Ellensburg, Pasco, Leavenworth, Ritzville, Spokane for 371
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Ellensburg, Pasco, Ritzville, Leavenworth, Spokane for 453
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Spokane for 347
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Spokane for 455
Idx 10: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Spokane for 536
Invalid:   Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Spokane for 536
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Ritzville, Spokane for 420
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Pasco, Ritzville, Ellensburg, Leavenworth, Spokane for 394
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Ritzville, Spokane for 476
Idx 7: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Spokane for 314
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Spokane for 422
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Ellensburg, Leavenworth, Spokane for 405
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Ellensburg, Leavenworth, Spokane for 447
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Leavenworth, Ellensburg, Spokane for 475
Idx 10: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Ellensburg, Leavenworth, Spokane for 502
Invalid:   Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Ellensburg, Leavenworth, Spokane for 502
Idx 10: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Leavenworth, Ellensburg, Spokane for 530
Invalid:   Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Leavenworth, Ellensburg, Spokane for 530
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Spokane for 464
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, George, Spokane for 478
Idx 10: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Spokane for 533
Invalid:   Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Spokane for 533
Idx 10: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, George, Spokane for 547
Invalid:   Spokane, Sprague, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, George, Spokane for 547
Idx 7: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Spokane for 370
Idx 7: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Ritzville, Spokane for 353
Idx 7: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, Ritzville, Ellensburg, George, Leavenworth, Spokane for 344
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Ritzville, Spokane for 395
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, George, Leavenworth, Ellensburg, Ritzville, Spokane for 423
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Ritzville, Spokane for 451
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, George, Leavenworth, Ellensburg, Ritzville, Spokane for 479
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Spokane for 412
Idx 8: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Ritzville, Spokane for 426
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Spokane for 482
Idx 9: Spokane, Sprague, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Ritzville, Spokane for 496
Idx 6: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Leavenworth, Moses Lake, Pasco, Ritzville, Spokane for 235
Idx 6: Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Moses Lake, Pasco, Ritzville, Spokane for 263
Idx 6: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Ellensburg, Leavenworth, Pasco, Ritzville, Spokane for 224
Idx 6: Spokane, Sprague, Davenport, Coulee City, George, Pasco, Ellensburg, Leavenworth, Moses Lake, Ritzville, Spokane for 284
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Pasco, Ellensburg, Leavenworth, Ritzville, Spokane for 296
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Ritzville, Ellensburg, Leavenworth, Pasco, Spokane for 266
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, Spokane for 348
Idx 9: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, Spokane for 456
Idx 10: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, Spokane for 511
Invalid:   Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, Spokane for 511
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Pasco, Ellensburg, Leavenworth, Ritzville, Spokane for 404
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Pasco, Ritzville, Ellensburg, Leavenworth, Spokane for 378
Idx 9: Spokane, Sprague, Davenport, Coulee City, George, Moses Lake, Pasco, Ellensburg, Leavenworth, Ritzville, Spokane for 460
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Leavenworth, Moses Lake, Pasco, Ritzville, Spokane for 291
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Pasco, Leavenworth, Moses Lake, Ritzville, Spokane for 343
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Pasco, Moses Lake, Leavenworth, Ritzville, Spokane for 415
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Pasco, Ritzville, Leavenworth, Moses Lake, Spokane for 425
Idx 9: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Pasco, Moses Lake, Ritzville, Leavenworth, Spokane for 457
Idx 9: Spokane, Sprague, Davenport, Coulee City, George, Ellensburg, Pasco, Ritzville, Moses Lake, Leavenworth, Spokane for 467
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Moses Lake, Pasco, Ritzville, Spokane for 319
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 427
Idx 9: Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 499
Idx 9: Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, Spokane for 509
Idx 10: Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 540
Invalid:   Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 540
Idx 10: Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, Spokane for 550
Invalid:   Spokane, Sprague, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, Spokane for 550
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Pasco, Ellensburg, Leavenworth, Moses Lake, Ritzville, Spokane for 392
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Pasco, Moses Lake, Ellensburg, Leavenworth, Ritzville, Spokane for 356
Idx 7: Spokane, Sprague, Davenport, Coulee City, George, Pasco, Ritzville, Ellensburg, Leavenworth, Moses Lake, Spokane for 366
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Pasco, Moses Lake, Ritzville, Ellensburg, Leavenworth, Spokane for 398
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Pasco, Ritzville, Moses Lake, Ellensburg, Leavenworth, Spokane for 408
Idx 8: Spokane, Sprague, Davenport, Coulee City, George, Pasco, Ellensburg, Leavenworth, Moses Lake, Ritzville, Spokane for 448
Idx 6: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Spokane for 285
Idx 6: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Moses Lake, Pasco, Ritzville, Spokane for 299
Idx 7: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Spokane for 327
Idx 7: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Spokane for 393
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Spokane for 358
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Spokane for 418
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Spokane for 430
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Ritzville, Pasco, Spokane for 400
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Ritzville, Pasco, Spokane for 481
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Ritzville, Pasco, Spokane for 481
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Spokane for 511
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Spokane for 511
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Spokane for 490
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Ritzville, Moses Lake, Spokane for 500
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Spokane for 531
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Spokane for 531
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Ritzville, Moses Lake, Spokane for 541
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Ritzville, Moses Lake, Spokane for 541
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Spokane for 484
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Moses Lake, George, Ritzville, Spokane for 465
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, George, Moses Lake, Spokane for 475
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Moses Lake, George, Ritzville, Spokane for 496
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, George, Spokane for 507
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, George, Spokane for 517
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, George, Spokane for 547
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, George, Spokane for 547
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Spokane for 515
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Spokane for 556
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Spokane for 556
Idx 7: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Moses Lake, Pasco, Ritzville, Spokane for 341
Idx 7: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ellensburg, Pasco, Ritzville, Spokane for 330
Idx 7: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Pasco, Ellensburg, Moses Lake, Ritzville, Spokane for 390
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Pasco, Ellensburg, Ritzville, Spokane for 402
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Ellensburg, Pasco, Spokane for 372
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Pasco, Ellensburg, Spokane for 454
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Pasco, Ellensburg, Spokane for 561
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Pasco, Ellensburg, Spokane for 561
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Pasco, Ellensburg, Ritzville, Spokane for 510
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Moses Lake, Pasco, Ritzville, Ellensburg, Spokane for 484
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 449
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 521
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Ritzville, Moses Lake, Spokane for 531
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 562
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Spokane for 562
Idx 10: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Ritzville, Moses Lake, Spokane for 572
Invalid:   Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Ritzville, Moses Lake, Spokane for 572
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Pasco, Ellensburg, Moses Lake, Ritzville, Spokane for 498
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Pasco, Moses Lake, Ellensburg, Ritzville, Spokane for 462
Idx 8: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Pasco, Ritzville, Ellensburg, Moses Lake, Spokane for 472
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Pasco, Moses Lake, Ritzville, Ellensburg, Spokane for 504
Idx 9: Spokane, Sprague, Davenport, Coulee City, Leavenworth, George, Pasco, Ritzville, Moses Lake, Ellensburg, Spokane for 514
Idx 3: Spokane, Davenport, Coulee City, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 104
Idx 3: Spokane, Davenport, Sprague, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Ritzville, Coulee City, Spokane for 74
Idx 4: Spokane, Davenport, Sprague, Ritzville, Ellensburg, George, Leavenworth, Moses Lake, Pasco, Coulee City, Spokane for 97
Idx 5: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Ellensburg, George, Leavenworth, Pasco, Coulee City, Spokane for 139
Idx 5: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Moses Lake, Coulee City, Spokane for 179
Idx 6: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Coulee City, Spokane for 170
Idx 6: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Spokane for 211
Idx 6: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Ellensburg, George, Leavenworth, Pasco, Spokane for 191
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Coulee City, Spokane for 212
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Coulee City, Spokane for 240
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Spokane for 261
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Coulee City, Ellensburg, Leavenworth, Pasco, Spokane for 225
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Coulee City, Spokane for 268
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Ellensburg, Pasco, Leavenworth, Coulee City, Spokane for 320
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Pasco, Spokane for 359
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Pasco, Spokane for 316
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Pasco, Spokane for 372
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Pasco, Spokane for 479
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Pasco, Spokane for 479
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Coulee City, Spokane for 296
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Leavenworth, Coulee City, Ellensburg, Pasco, Spokane for 331
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Coulee City, Spokane for 404
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Spokane for 369
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Spokane for 425
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Spokane for 515
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Spokane for 515
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Pasco, Spokane for 246
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Pasco, Spokane for 282
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Pasco, Spokane for 288
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Pasco, Spokane for 316
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Pasco, Ellensburg, Leavenworth, Spokane for 337
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Pasco, Spokane for 344
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Ellensburg, Pasco, Leavenworth, Spokane for 396
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Pasco, Spokane for 372
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Pasco, Spokane for 479
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Pasco, Spokane for 479
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Pasco, Ellensburg, Leavenworth, Spokane for 445
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Pasco, Ellensburg, Leavenworth, Spokane for 500
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, George, Pasco, Ellensburg, Leavenworth, Spokane for 500
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Pasco, Spokane for 338
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Pasco, Spokane for 352
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Pasco, Spokane for 380
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, Pasco, George, Spokane for 446
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Pasco, Spokane for 470
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Pasco, Spokane for 470
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, Pasco, George, Spokane for 536
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, Ellensburg, Pasco, George, Spokane for 536
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Pasco, Spokane for 394
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Pasco, Ellensburg, Spokane for 443
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Pasco, Spokane for 501
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Pasco, Spokane for 501
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Pasco, Ellensburg, Spokane for 550
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Coulee City, Leavenworth, George, Pasco, Ellensburg, Spokane for 550
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Spokane for 319
Idx 7: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Spokane for 302
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Spokane for 344
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Leavenworth, Ellensburg, Coulee City, Spokane for 372
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Ellensburg, Leavenworth, Spokane for 357
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Spokane for 400
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Spokane for 490
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Spokane for 490
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Leavenworth, Ellensburg, Spokane for 448
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Leavenworth, Ellensburg, Spokane for 503
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Coulee City, Leavenworth, Ellensburg, Spokane for 503
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Leavenworth, Ellensburg, Coulee City, Spokane for 428
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, George, Leavenworth, Coulee City, Ellensburg, Spokane for 463
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Spokane for 361
Idx 8: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Coulee City, Spokane for 375
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Spokane for 431
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Coulee City, Leavenworth, Spokane for 416
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Coulee City, Leavenworth, Spokane for 506
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Coulee City, Leavenworth, Spokane for 506
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Spokane for 521
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Coulee City, Spokane for 521
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Coulee City, Spokane for 445
Idx 9: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, Coulee City, George, Spokane for 466
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Coulee City, Spokane for 499
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Coulee City, Spokane for 499
Idx 10: Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, Coulee City, George, Spokane for 520
Invalid:   Spokane, Davenport, Sprague, Ritzville, Moses Lake, Pasco, Ellensburg, Leavenworth, Coulee City, George, Spokane for 520
Idx 6: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Moses Lake, Coulee City, Spokane for 287
Idx 6: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Moses Lake, Coulee City, Spokane for 270
Idx 6: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Ellensburg, George, Leavenworth, Coulee City, Spokane for 251
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Spokane for 282
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Ellensburg, George, Leavenworth, Spokane for 303
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Spokane for 324
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Leavenworth, Ellensburg, Coulee City, Spokane for 352
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Ellensburg, Leavenworth, Spokane for 337
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Spokane for 380
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Spokane for 470
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Spokane for 470
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Spokane for 428
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Spokane for 483
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Coulee City, Leavenworth, Ellensburg, Spokane for 483
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Leavenworth, Ellensburg, Coulee City, Spokane for 408
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, George, Leavenworth, Coulee City, Ellensburg, Spokane for 443
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Spokane for 358
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Spokane for 394
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Spokane for 400
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Spokane for 428
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Spokane for 455
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Ellensburg, Leavenworth, Spokane for 455
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Spokane for 483
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, George, Leavenworth, Ellensburg, Spokane for 483
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Spokane for 450
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Spokane for 464
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Spokane for 491
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, Ellensburg, George, Spokane for 491
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Spokane for 505
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Moses Lake, Coulee City, Leavenworth, George, Ellensburg, Spokane for 505
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Moses Lake, Coulee City, Spokane for 312
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Leavenworth, Ellensburg, Moses Lake, Coulee City, Spokane for 340
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Moses Lake, Ellensburg, Leavenworth, Coulee City, Spokane for 301
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Coulee City, Ellensburg, Leavenworth, Moses Lake, Spokane for 325
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Ellensburg, Leavenworth, Spokane for 353
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Leavenworth, Ellensburg, Spokane for 444
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Leavenworth, Ellensburg, Spokane for 499
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, George, Moses Lake, Coulee City, Leavenworth, Ellensburg, Spokane for 499
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Moses Lake, Coulee City, Spokane for 368
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Coulee City, Moses Lake, Spokane for 459
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Coulee City, Moses Lake, Spokane for 510
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, George, Ellensburg, Leavenworth, Coulee City, Moses Lake, Spokane for 510
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Coulee City, Leavenworth, Ellensburg, Moses Lake, Spokane for 416
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Coulee City, Moses Lake, Ellensburg, Leavenworth, Spokane for 377
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Coulee City, Leavenworth, Ellensburg, Moses Lake, Spokane for 472
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Leavenworth, Ellensburg, Moses Lake, Coulee City, Spokane for 396
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Leavenworth, Coulee City, Ellensburg, Moses Lake, Spokane for 431
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, George, Leavenworth, Coulee City, Moses Lake, Ellensburg, Spokane for 483
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Moses Lake, Coulee City, Spokane for 329
Idx 7: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Spokane for 343
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Moses Lake, Coulee City, Spokane for 399
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Leavenworth, Coulee City, Spokane for 360
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Coulee City, Leavenworth, Moses Lake, Spokane for 384
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Coulee City, Leavenworth, Spokane for 412
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Coulee City, Leavenworth, Spokane for 502
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Moses Lake, Coulee City, Leavenworth, Spokane for 502
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Coulee City, Leavenworth, Moses Lake, Spokane for 475
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Coulee City, Moses Lake, Leavenworth, Spokane for 436
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Coulee City, Moses Lake, Spokane for 490
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Coulee City, Moses Lake, Spokane for 541
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, George, Leavenworth, Coulee City, Moses Lake, Spokane for 541
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Spokane for 413
Idx 8: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, George, Moses Lake, Spokane for 434
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Spokane for 444
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Coulee City, Moses Lake, Spokane for 468
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Spokane for 495
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Moses Lake, Coulee City, Spokane for 495
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Coulee City, Moses Lake, Spokane for 519
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, George, Coulee City, Moses Lake, Spokane for 519
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, George, Moses Lake, Spokane for 489
Idx 9: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, Moses Lake, George, Spokane for 486
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, Moses Lake, George, Spokane for 516
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, Moses Lake, George, Spokane for 516
Idx 10: Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, George, Moses Lake, Spokane for 519
Invalid:   Spokane, Davenport, Sprague, Ritzville, Pasco, Ellensburg, Leavenworth, Coulee City, George, Moses Lake, Spokane for 519
Idx 4: Spokane, Davenport, Coulee City, George, Ellensburg, Leavenworth, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 159
Idx 4: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 195
Idx 4: Spokane, Davenport, Coulee City, Moses Lake, Ellensburg, George, Leavenworth, Pasco, Ritzville, Sprague, Spokane for 156
Idx 5: Spokane, Davenport, Coulee City, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Ritzville, Sprague, Spokane for 187
Idx 5: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Sprague, Spokane for 228
Idx 5: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Ellensburg, George, Leavenworth, Pasco, Sprague, Spokane for 198
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Ritzville, Sprague, Spokane for 229
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, Spokane for 257
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 278
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, George, Ellensburg, Leavenworth, Pasco, Ritzville, Sprague, Spokane for 285
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, George, Ellensburg, Pasco, Leavenworth, Ritzville, Sprague, Spokane for 337
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, George, Ellensburg, Pasco, Ritzville, Leavenworth, Sprague, Spokane for 419
Idx 9: Spokane, Davenport, Coulee City, Moses Lake, George, Ellensburg, Pasco, Ritzville, Sprague, Leavenworth, Spokane for 442
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, Spokane for 313
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, Spokane for 421
Idx 9: Spokane, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, Spokane for 503
Idx 10: Spokane, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, Spokane for 562
Too long:  Spokane, Davenport, Coulee City, Moses Lake, George, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, Spokane for 562
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 386
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, George, Pasco, Ritzville, Ellensburg, Leavenworth, Sprague, Spokane for 360
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, George, Pasco, Ritzville, Sprague, Ellensburg, Leavenworth, Spokane for 383
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 442
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Sprague, Spokane for 280
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Sprague, Ellensburg, George, Leavenworth, Pasco, Spokane for 221
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Sprague, Spokane for 388
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Ellensburg, Leavenworth, Sprague, Spokane for 371
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Ellensburg, Leavenworth, Sprague, Spokane for 413
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Leavenworth, Ellensburg, Sprague, Spokane for 441
Idx 9: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Ellensburg, Leavenworth, Sprague, Spokane for 469
Idx 9: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, George, Leavenworth, Ellensburg, Sprague, Spokane for 497
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Sprague, Spokane for 430
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, George, Sprague, Spokane for 444
Idx 9: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, George, Leavenworth, Sprague, Spokane for 500
Idx 9: Spokane, Davenport, Coulee City, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, George, Sprague, Spokane for 514
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Sprague, Spokane for 336
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 319
Idx 6: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ritzville, Ellensburg, George, Leavenworth, Sprague, Spokane for 310
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ritzville, Sprague, Ellensburg, George, Leavenworth, Spokane for 333
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 361
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, Pasco, George, Leavenworth, Ellensburg, Ritzville, Sprague, Spokane for 389
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 417
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Pasco, George, Leavenworth, Ellensburg, Ritzville, Sprague, Spokane for 445
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Sprague, Spokane for 378
Idx 7: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Ritzville, Sprague, Spokane for 392
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, George, Leavenworth, Ritzville, Sprague, Spokane for 448
Idx 8: Spokane, Davenport, Coulee City, Moses Lake, Pasco, Ellensburg, Leavenworth, George, Ritzville, Sprague, Spokane for 462
Idx 5: Spokane, Davenport, Coulee City, George, Ellensburg, Leavenworth, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 201
Idx 5: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 229
Idx 5: Spokane, Davenport, Coulee City, George, Moses Lake, Ellensburg, Leavenworth, Pasco, Ritzville, Sprague, Spokane for 190
Idx 5: Spokane, Davenport, Coulee City, George, Pasco, Ellensburg, Leavenworth, Moses Lake, Ritzville, Sprague, Spokane for 250
Idx 6: Spokane, Davenport, Coulee City, George, Moses Lake, Pasco, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 262
Idx 6: Spokane, Davenport, Coulee City, George, Moses Lake, Ritzville, Ellensburg, Leavenworth, Pasco, Sprague, Spokane for 232
Idx 7: Spokane, Davenport, Coulee City, George, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, Sprague, Spokane for 314
Idx 7: Spokane, Davenport, Coulee City, George, Moses Lake, Ritzville, Sprague, Ellensburg, Leavenworth, Pasco, Spokane for 255
Idx 8: Spokane, Davenport, Coulee City, George, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, Sprague, Spokane for 422
Idx 9: Spokane, Davenport, Coulee City, George, Moses Lake, Ritzville, Pasco, Ellensburg, Leavenworth, Sprague, Spokane for 478
Idx 7: Spokane, Davenport, Coulee City, George, Moses Lake, Pasco, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 370
Idx 7: Spokane, Davenport, Coulee City, George, Moses Lake, Pasco, Ritzville, Ellensburg, Leavenworth, Sprague, Spokane for 344
Idx 8: Spokane, Davenport, Coulee City, George, Moses Lake, Pasco, Ritzville, Sprague, Ellensburg, Leavenworth, Spokane for 367
Idx 8: Spokane, Davenport, Coulee City, George, Moses Lake, Pasco, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 426
Idx 6: Spokane, Davenport, Coulee City, George, Ellensburg, Leavenworth, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 257
Idx 6: Spokane, Davenport, Coulee City, George, Ellensburg, Pasco, Leavenworth, Moses Lake, Ritzville, Sprague, Spokane for 309
Idx 7: Spokane, Davenport, Coulee City, George, Ellensburg, Pasco, Moses Lake, Leavenworth, Ritzville, Sprague, Spokane for 381
Idx 7: Spokane, Davenport, Coulee City, George, Ellensburg, Pasco, Ritzville, Leavenworth, Moses Lake, Sprague, Spokane for 391
Idx 8: Spokane, Davenport, Coulee City, George, Ellensburg, Pasco, Moses Lake, Ritzville, Leavenworth, Sprague, Spokane for 423
Idx 9: Spokane, Davenport, Coulee City, George, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Leavenworth, Spokane for 446
Idx 8: Spokane, Davenport, Coulee City, George, Ellensburg, Pasco, Ritzville, Moses Lake, Leavenworth, Sprague, Spokane for 433
Idx 8: Spokane, Davenport, Coulee City, George, Ellensburg, Pasco, Ritzville, Sprague, Leavenworth, Moses Lake, Spokane for 414
Idx 6: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 285
Idx 7: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 393
Idx 8: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 465
Idx 8: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, Sprague, Spokane for 475
Idx 9: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 507
Idx 10: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 566
Too long:  Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 566
Idx 9: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, Sprague, Spokane for 517
Idx 9: Spokane, Davenport, Coulee City, George, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, Moses Lake, Spokane for 498
Idx 6: Spokane, Davenport, Coulee City, George, Pasco, Ellensburg, Leavenworth, Moses Lake, Ritzville, Sprague, Spokane for 358
Idx 6: Spokane, Davenport, Coulee City, George, Pasco, Moses Lake, Ellensburg, Leavenworth, Ritzville, Sprague, Spokane for 322
Idx 6: Spokane, Davenport, Coulee City, George, Pasco, Ritzville, Ellensburg, Leavenworth, Moses Lake, Sprague, Spokane for 332
Idx 7: Spokane, Davenport, Coulee City, George, Pasco, Moses Lake, Ritzville, Ellensburg, Leavenworth, Sprague, Spokane for 364
Idx 8: Spokane, Davenport, Coulee City, George, Pasco, Moses Lake, Ritzville, Sprague, Ellensburg, Leavenworth, Spokane for 387
Idx 7: Spokane, Davenport, Coulee City, George, Pasco, Ritzville, Moses Lake, Ellensburg, Leavenworth, Sprague, Spokane for 374
Idx 7: Spokane, Davenport, Coulee City, George, Pasco, Ritzville, Sprague, Ellensburg, Leavenworth, Moses Lake, Spokane for 355
Idx 7: Spokane, Davenport, Coulee City, George, Pasco, Ellensburg, Leavenworth, Moses Lake, Ritzville, Sprague, Spokane for 414
Idx 5: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 251
Idx 5: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 265
Idx 6: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 293
Idx 6: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Sprague, Spokane for 359
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 324
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 384
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 396
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Ritzville, Pasco, Sprague, Spokane for 366
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Ritzville, Pasco, Sprague, Spokane for 448
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Ritzville, Sprague, Pasco, Spokane for 389
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 478
Idx 10: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 537
Too long:  Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 537
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 456
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Ritzville, Moses Lake, Sprague, Spokane for 466
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 498
Idx 10: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 557
Too long:  Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 557
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Ritzville, Moses Lake, Sprague, Spokane for 508
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, George, Pasco, Ritzville, Sprague, Moses Lake, Spokane for 489
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Sprague, Spokane for 450
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Moses Lake, George, Ritzville, Sprague, Spokane for 431
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, George, Moses Lake, Sprague, Spokane for 441
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Moses Lake, George, Ritzville, Sprague, Spokane for 462
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, George, Sprague, Spokane for 473
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, George, Spokane for 496
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, George, Sprague, Spokane for 483
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, Sprague, George, Moses Lake, Spokane for 464
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, Ritzville, Moses Lake, George, Sprague, Spokane for 514
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Sprague, Spokane for 481
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Sprague, Spokane for 523
Idx 10: Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Sprague, Spokane for 582
Too long:  Spokane, Davenport, Coulee City, Leavenworth, Ellensburg, Pasco, George, Moses Lake, Ritzville, Sprague, Spokane for 582
Idx 6: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Moses Lake, Pasco, Ritzville, Sprague, Spokane for 307
Idx 6: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ellensburg, Pasco, Ritzville, Sprague, Spokane for 296
Idx 6: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Ellensburg, Moses Lake, Ritzville, Sprague, Spokane for 356
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Pasco, Ellensburg, Ritzville, Sprague, Spokane for 368
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Ellensburg, Pasco, Sprague, Spokane for 338
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Pasco, Ellensburg, Sprague, Spokane for 420
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Sprague, Ellensburg, Pasco, Spokane for 361
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Ritzville, Pasco, Ellensburg, Sprague, Spokane for 528
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Pasco, Ellensburg, Ritzville, Sprague, Spokane for 476
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Pasco, Ritzville, Ellensburg, Sprague, Spokane for 450
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, George, Moses Lake, Pasco, Ritzville, Sprague, Ellensburg, Spokane for 473
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 415
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 487
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Ritzville, Moses Lake, Sprague, Spokane for 497
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 529
Idx 10: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 588
Too long:  Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Moses Lake, Ritzville, Sprague, Spokane for 588
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Ritzville, Moses Lake, Sprague, Spokane for 539
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, George, Ellensburg, Pasco, Ritzville, Sprague, Moses Lake, Spokane for 520
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Ellensburg, Moses Lake, Ritzville, Sprague, Spokane for 464
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Moses Lake, Ellensburg, Ritzville, Sprague, Spokane for 428
Idx 7: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Ritzville, Ellensburg, Moses Lake, Sprague, Spokane for 438
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Moses Lake, Ritzville, Ellensburg, Sprague, Spokane for 470
Idx 9: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Moses Lake, Ritzville, Sprague, Ellensburg, Spokane for 493
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Ritzville, Moses Lake, Ellensburg, Sprague, Spokane for 480
Idx 8: Spokane, Davenport, Coulee City, Leavenworth, George, Pasco, Ritzville, Sprague, Ellensburg, Moses Lake, Spokane for 461
Tours discovered:
Spokane, Sprague, Ritzville, Moses Lake, George, Pasco, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 582
Spokane, Sprague, Ritzville, Moses Lake, Pasco, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 557
Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 537
533 Tour objects generated.
Best tour:
Spokane, Sprague, Ritzville, Pasco, Moses Lake, George, Ellensburg, Leavenworth, Coulee City, Davenport, Spokane for 537
