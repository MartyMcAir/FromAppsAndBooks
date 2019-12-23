/*This is a Java Program to implement Priority Queue. A priority queue is an abstract data type which is like a regular queue or stack data structure, but where additionally each element has a “priority” associated with it. In a priority queue, an element with high priority is served before an element with low priority. If two elements have the same priority, they are served according to their order in the queue. Here priority queue is implemented using a max heap.*/

/**
 ** Java Program to implement Priority Queue
 **/

import java.util.Scanner;

/** class Task **/
class Task
{
    String job;
    int priority;

    /** Constructor **/
    public Task(String job, int priority)
    {
        this.job = job;
        this.priority = priority;
    }
    /** toString() **/
    public String toString()
    {
        return "Job Name : "+ job +"\nPriority : "+ priority;
    }
}

/** Class PriorityQueue **/
class PriorityQueue
{
    private Task[] heap;
    private int heapSize, capacity;

    /** Constructor **/
    public PriorityQueue(int capacity)
    {
        this.capacity = capacity + 1;
        heap = new Task[this.capacity];
        heapSize = 0;
    }
    /** function to clear **/
    public void clear()
    {
        heap = new Task[capacity];
        heapSize = 0;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** function to check if full **/
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }
    /** function to insert task **/
    public void insert(String job, int priority)
    {
        Task newJob = new Task(job, priority);
        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.priority > heap[pos/2].priority)
            {
                heap[pos] = heap[pos/2];
                pos /=2;
            }
        heap[pos] = newJob;
    }
    /** function to remove task **/
    public Task remove()
    {
        int parent, child;
        Task item, temp;
        if (isEmpty() )
            {
                System.out.println("Heap is empty");
                return null;
            }
        item = heap[1];
        temp = heap[heapSize--];
        parent = 1;
        child = 2;
        while (child <= heapSize)
            {
                if (child < heapSize && heap[child].priority < heap[child + 1].priority)
                    child++;
                if (temp.priority >= heap[child].priority)
                    break;
                heap[parent] = heap[child];
                parent = child;
                child *= 2;
            }
        heap[parent] = temp;
        return item;
    }
}

/** Class PriorityQueueTest **/
public class PriorityQueueTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Priority Queue Test\n");
        System.out.println("Enter size of priority queue ");
        PriorityQueue pq = new PriorityQueue(scan.nextInt() );
        char ch;
        /*  Perform Priority Queue operations */
        do
            {
                System.out.println("\nPriority Queue Operations\n");
                System.out.println("1. insert");
                System.out.println("2. remove");
                System.out.println("3. check empty");
                System.out.println("4. check full");
                System.out.println("5. clear");
                System.out.println("6. size");
                int choice = scan.nextInt();
                switch (choice)
                    {
                    case 1 :
                        System.out.println("Enter job name and priority");
                        pq.insert(scan.next(), scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("\nJob removed \n\n"+ pq.remove());
                        break;
                    case 3 :
                        System.out.println("\nEmpty Status : "+ pq.isEmpty() );
                        break;
                    case 4 :
                        System.out.println("\nFull Status : "+ pq.isFull() );
                        break;
                    case 5 :
                        System.out.println("\nPriority Queue Cleared");
                        pq.clear();
                        break;
                    case 6 :
                        System.out.println("\nSize = "+ pq.size() );
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                    }
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            }
        while (ch == 'Y'|| ch == 'y');
    }
}

/*

Enter size of priority queue
7

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
1
Enter job name and priority
job1 24

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
1
Enter job name and priority
job2 6

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
1
Enter job name and priority
job3 28

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
1
Enter job name and priority
job4 63

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
1
Enter job name and priority
job5 5

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
1
Enter job name and priority
job6 94

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
1
Enter job name and priority
job7 14

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
6

Size = 7

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
4

Full Status : true

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2

Job removed

Job Name : job6
Priority : 94

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2

Job removed

Job Name : job4
Priority : 63

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2

Job removed

Job Name : job3
Priority : 28

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2

Job removed

Job Name : job1
Priority : 24

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2

Job removed

Job Name : job7
Priority : 14

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2

Job removed

Job Name : job2
Priority : 6

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2

Job removed

Job Name : job5
Priority : 5

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
2
Heap is empty

Job removed

null

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
3

Empty Status : true

Do you want to continue (Type y or n)

y

Priority Queue Operations

1. insert
2. remove
3. check empty
4. check full
5. clear
6. size
6

Size = 0

Do you want to continue (Type y or n)

n
