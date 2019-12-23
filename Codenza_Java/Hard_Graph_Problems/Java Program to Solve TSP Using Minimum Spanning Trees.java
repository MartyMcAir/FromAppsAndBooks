import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TSPUsingMST
{
    // ArraysC to keep track of info. related to each city
    private String[]   cityName;
    private String[]   cityState;
    private int[]      cityLat;
    private int[]      cityLong;
    private int[]      cityPop;
    // 2-D array to keep track of pairwise distances between cities
    private int[][]    distances;
    // number of cities
    private static int numCities;

    public TSPUsingMST(int n)
    {
        numCities = n;
        // Allotting the space for each 1-D array
        cityName = new String[numCities];
        cityState = new String[numCities];
        cityLat = new int[numCities];
        cityLong = new int[numCities];
        cityPop = new int[numCities];
        // Allocate space for each 2-D array. These arrays have 0 elements in
        // row 0,
        // 1 element in row 1, 2 elements in row 2, etc.
        distances = new int[numCities][];
        for (int i = 0; i < numCities; i++)
            distances[i] = new int[i];
        try
            {
                // Construct a buffered reader object and connect it to the files
                // "miles.dat"
                BufferedReader in = new BufferedReader(new FileReader("miles.dat"));
                // A counter that keeps track of the index of the current city being
                // read
                int cityNumber = 0;
                // While-loop for reading in data from "miles.dat." At the beginning
                // of the while-loop
                // the expectation is that we'll be reading a line containing the
                // city name. Instead,
                // if we encounter a line that starts with "*" then we skip to the
                // next line
                while (cityNumber < numCities)
                    {
                        // Read in a line
                        String line = in.readLine();
                        // Skip the rest of the loop if line starts with a "*"
                        if (line.charAt(0) == '*')
                            continue;
                        // Otherwise tokenize the line
                        StringTokenizer tokenizedLine = new StringTokenizer(line, ",[]");
                        // Putting actual data into correct position in the array
                        cityName[cityNumber] = tokenizedLine.nextToken();
                        cityState[cityNumber] = (tokenizedLine.nextToken()).trim(); // trim()
                        // gets
                        // rid
                        // of
                        // leading/trailing
                        // blanks
                        cityLat[cityNumber] = Integer.parseInt(tokenizedLine
                                                               .nextToken());
                        cityLong[cityNumber] = Integer.parseInt(tokenizedLine
                                                                .nextToken());
                        cityPop[cityNumber] = Integer.parseInt(tokenizedLine
                                                               .nextToken());
                        // while loop to put distances in the array; this may need to
                        // read several lines
                        int mileNumber = 0;
                        while (mileNumber < cityNumber)
                            {
                                // Read a mileage line and tokenize it
                                String mileage = in.readLine();
                                StringTokenizer tokenizedMileage = new StringTokenizer(
                                    mileage, " ");
                                // Read all the mileage data in this line into row
                                // cityNumber; increment
                                // mileNumber after each read
                                while (tokenizedMileage.hasMoreTokens())
                                    {
                                        distances[cityNumber][cityNumber - mileNumber - 1] = Integer
                                                .parseInt(tokenizedMileage.nextToken());
                                        mileNumber++;
                                    }
                            } // end of while reading distances
                        cityNumber++;
                    } // end of while reading cities
                in.close();
            } // end of try
        catch (IOException e)
            {
                System.out.println("File not found.");
            }
    } // end of TSPTester() constructor

    // A simple getIndex method to help test the constructor
    int getIndex(String city, String state)
    {
        int location;
        for (location = 0; location < numCities; location++)
            if ((cityName[location].equals(city))
                    && (cityState[location].equals(state)))
                return location;
        return -1;
    }

    // Print information about a city, given a city index
    void printCityInfo(int index)
    {
        System.out
        .println(cityName[index] + " " + cityState[index] + " "
                 + cityLat[index] + " " + cityLong[index] + " "
                 + cityPop[index]);
    }

    // Print distance information between a given pair of cities
    void printDistanceInfo(int i, int j)
    {
        if (i < j)
            System.out.println(distances[j][i]);
        else
            System.out.println(distances[i][j]);
    }

    int getDistance(int i, int j)
    {
        if (i < j)
            return distances[j][i];
        else if (j < i)
            return distances[i][j];
        else
            return 0;
    }

    int[] greedyTSP()
    {
        // Find a cheapest triangle
        // Load triangle 0-1-2 into the the first 3 slots of the greedy array
        int[] greedy = new int[numCities];
        int currentDistance;
        greedy[0] = 0;
        greedy[1] = 1;
        greedy[2] = 2;
        int currentBestDistance = getDistance(0, 1) + getDistance(1, 2)
                                  + getDistance(2, 0);
        for (int i = 0; i < numCities; i++)
            for (int j = 0; j < i; j++)
                for (int k = 0; k < j; k++)
                    if ((currentDistance = getDistance(i, j)
                                           + getDistance(j, k) + getDistance(i, k)) < currentBestDistance)
                        {
                            greedy[0] = i;
                            greedy[1] = j;
                            greedy[2] = k;
                            currentBestDistance = currentDistance;
                        }
        // Try greedily to add a city that yields the smallest increase
        // in the cost of the tour
        int partialTourSize = 3;
        boolean[] visited = new boolean[numCities];
        for (int i = 0; i < numCities; i++)
            visited[i] = false;
        visited[greedy[0]] = true;
        visited[greedy[1]] = true;
        visited[greedy[2]] = true;
        // Main loop: keep repeating until partial tour covers all cities
        while (partialTourSize < numCities)
            {
                int smallestIncrease = Integer.MAX_VALUE;
                int increase = 0;
                int bestInsertionPoint = 0;
                int bestCity = 0;
                // Scan through all cities, stopping at unvisited cities
                for (int i = 0; i < numCities; i++)
                    {
                        if (!visited[i])
                            {
                                // Consider all possible positions of inserting city i into
                                // the tour
                                // and record the smallest increase
                                for (int j = 0; j < partialTourSize; j++)
                                    {
                                        increase = getDistance(greedy[j], i)
                                                   + getDistance(i, greedy[(j + 1) % numCities])
                                                   - getDistance(greedy[j], greedy[(j + 1)
                                                                 % numCities]);
                                        if (increase < smallestIncrease)
                                            {
                                                smallestIncrease = increase;
                                                bestCity = i;
                                                bestInsertionPoint = j;
                                            } // end of if we have found a smaller increase
                                    } // end of for-j
                            } // end of if not visited
                    } // end of for-i
                // Now we are ready to insert the bestCity at the bestInsertionPoint
                for (int j = partialTourSize - 1; j > bestInsertionPoint; j--)
                    greedy[j + 1] = greedy[j];
                greedy[bestInsertionPoint + 1] = bestCity;
                visited[bestCity] = true;
                partialTourSize++;
            } // end-while
        return greedy;
    }

    void copy(int[] source, int[] dest)
    {
        for (int i = 0; i < dest.length; i++)
            dest[i] = source[i];
    }

    void TSP(int[] R, int partialTourSize, boolean[] visited, int[] T)
    {
        // Base case: we have discovered a tour better than T
        if ((partialTourSize == numCities) && (cost(R) < cost(T)))
            {
                System.out.println("Base case. Tour cost is " + cost(R));
                copy(R, T);
                return;
            }
        // Another base case: our partial tour is not worth completing
        if (cost(R, partialTourSize) >= cost(T))
            return;
        // Recursive case: R is not complete and is currently better than T
        // and is therefore worth completing
        for (int i = 0; i < numCities; i++)
            {
                if (!visited[i])
                    {
                        // System.out.println("Appending " + i);
                        visited[i] = true;
                        R[partialTourSize++] = i;
                        TSP(R, partialTourSize, visited, T);
                        partialTourSize--;
                        visited[i] = false;
                        // System.out.println("Deleting " + i);
                    }
            } // end of for-loop
    } // end of TSP

    double cost(int[] tour)
    {
        return cost(tour, tour.length);
    }

    double cost(int[] tour, int tourSize)
    {
        double c = 0;
        for (int i = 0; i < tourSize - 1; i++)
            c = c + getDistance(tour[i], tour[i + 1]);
        c = c + getDistance(tour[tourSize - 1], tour[0]);
        return c;
    }

    // Main method
    public static void main(String[] args)
    {
        int n = 15;
        TSPUsingMST T = new TSPUsingMST(n);
        // Initialize the list of vertices in the tree
        // Initially, no one except vertex 0 is in the tree
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            visited[i] = false;
        visited[0] = true;
        // Initialize the int[] that maintains the tree to default values
        // No vertices have parents set, except vertex 0 whose parent is itself
        int[] tree = new int[n];
        for (int i = 0; i < n; i++)
            tree[i] = -1;
        tree[0] = 0;
        for (int i = 1; i <= n - 1; i++)
            {
                long minWeight = Long.MAX_VALUE;
                int bestVertex = -1;
                int bestParent = -1;
                for (int j = 0; j < n; j++)
                    {
                        for (int k = 0; k < n; k++)
                            {
                                if ((visited[j]) && (!visited[k]))
                                    {
                                        if (T.getDistance(j, k) < minWeight)
                                            {
                                                minWeight = T.getDistance(j, k);
                                                bestVertex = k;
                                                bestParent = j;
                                            } // end if better distance is found
                                    } // end if an edge between a visited and an unvisited is
                                // found
                            } // end for-k
                    } // end for-j
                // Update visited and tree
                visited[bestVertex] = true;
                tree[bestVertex] = bestParent;
            } // end for-i
        // Printing the MST
        for (int i = 1; i < n; i++)
            System.out.println(T.cityName[i] + " " + T.cityState[i] + ", "
                               + T.cityName[tree[i]] + " " + T.cityState[tree[i]]);
        // Compting the MST cost
        long cost = 0;
        for (int i = 0; i < n; i++)
            cost += T.getDistance(i, tree[i]);
        System.out.println("The cost of the minimum spanning tree is " + cost);
    } // end main method
} // end class

/*
Yankton SD, Wisconsin Dells WI
Yakima WA, Williston ND
Worcester MA, Wilmington DE
Wisconsin Dells WI, Youngstown OH
Winston-Salem NC, Winchester VA
Winnipeg MB, Yankton SD
Winchester VA, Wilmington DE
Wilmington NC, Winston-Salem NC
Wilmington DE, Williamsport PA
Williston ND, Winnipeg MB
Williamsport PA, Youngstown OH
Williamson WV, Winston-Salem NC
Wichita Falls TX, Wichita KS
Wichita KS, Yankton SD
The cost of the minimum spanning tree is 5461
