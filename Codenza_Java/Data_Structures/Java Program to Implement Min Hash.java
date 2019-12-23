/*This is a java program to implement Min Hash. In computer science, MinHash (or the min-wise independent permutations locality sensitive hashing scheme) is a technique for quickly estimating how similar two sets are.*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MinHash<T>
{
    private int hash[];
    private int numHash;

    public MinHash(int numHash)
    {
        this.numHash = numHash;
        hash = new int[numHash];
        Random r = new Random(11);
        for (int i = 0; i < numHash; i++)
            {
                int a = (int) r.nextInt();
                int b = (int) r.nextInt();
                int c = (int) r.nextInt();
                int x = hash(a * b * c, a, b, c);
                hash[i] = x;
            }
    }

    public double similarity(Set<T> set1, Set<T> set2)
    {
        int numSets = 2;
        Map<T, boolean[]> bitMap = buildBitMap(set1, set2);
        int[][] minHashValues = initializeHashBuckets(numSets, numHash);
        computeMinHashForSet(set1, 0, minHashValues, bitMap);
        computeMinHashForSet(set2, 1, minHashValues, bitMap);
        return computeSimilarityFromSignatures(minHashValues, numHash);
    }

    private static int[][] initializeHashBuckets(int numSets,
            int numHashFunctions)
    {
        int[][] minHashValues = new int[numSets][numHashFunctions];
        for (int i = 0; i < numSets; i++)
            {
                for (int j = 0; j < numHashFunctions; j++)
                    {
                        minHashValues[i][j] = Integer.MAX_VALUE;
                    }
            }
        return minHashValues;
    }

    private static double computeSimilarityFromSignatures(
        int[][] minHashValues, int numHashFunctions)
    {
        int identicalMinHashes = 0;
        for (int i = 0; i < numHashFunctions; i++)
            {
                if (minHashValues[0][i] == minHashValues[1][i])
                    {
                        identicalMinHashes++;
                    }
            }
        return (1.0 * identicalMinHashes) / numHashFunctions;
    }

    private static int hash(int x, int a, int b, int c)
    {
        int hashValue = (int) ((a * (x >> 4) + b * x + c) & 131071);
        return Math.abs(hashValue);
    }

    private void computeMinHashForSet(Set<T> set, int setIndex,
                                      int[][] minHashValues, Map<T, boolean[]> bitArray)
    {
        int index = 0;
        for (T element : bitArray.keySet())
            {
                /*
                 * for every element in the bit array
                 */
                for (int i = 0; i < numHash; i++)
                    {
                        /*
                         * for every hash
                         */
                        if (set.contains(element))
                            {
                                /*
                                 * if the set contains the element
                                 */
                                int hindex = hash[index];
                                if (hindex < minHashValues[setIndex][index])
                                    {
                                        /*
                                         * if current hash is smaller than the existing hash in
                                         * the slot then replace with the smaller hash value
                                         */
                                        minHashValues[setIndex][i] = hindex;
                                    }
                            }
                    }
                index++;
            }
    }

    public Map<T, boolean[]> buildBitMap(Set<T> set1, Set<T> set2)
    {
        Map<T, boolean[]> bitArray = new HashMap<T, boolean[]>();
        for (T t : set1)
            {
                bitArray.put(t, new boolean[] { true, false });
            }
        for (T t : set2)
            {
                if (bitArray.containsKey(t))
                    {
                        // item is not present in set1
                        bitArray.put(t, new boolean[] { true, true });
                    }
                else if (!bitArray.containsKey(t))
                    {
                        // item is not present in set1
                        bitArray.put(t, new boolean[] { false, true });
                    }
            }
        return bitArray;
    }

    public static void main(String[] args)
    {
        Set<String> set1 = new HashSet<String>();
        set1.add("FRANCISCO");
        set1.add("MISSION");
        set1.add("SAN");
        Set<String> set2 = new HashSet<String>();
        set2.add("FRANCISCO");
        set2.add("MISSION");
        set2.add("SAN");
        set2.add("USA");
        MinHash<String> minHash = new MinHash<String>(set1.size() + set2.size());
        System.out.println("Set1 : " + set1);
        System.out.println("Set2 : " + set2);
        System.out.println("Similarity between two sets: "
                           + minHash.similarity(set1, set2));
    }
}

/*
Set1 : [SAN, MISSION, FRANCISCO]
Set2 : [SAN, USA, MISSION, FRANCISCO]
Similarity between two sets: 1.0
