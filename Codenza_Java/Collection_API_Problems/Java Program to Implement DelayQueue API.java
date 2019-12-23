import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueImpl<E extends Delayed>
{
    private DelayQueue<E> delayQueue;

    /** Creates a new DelayQueue that is initially empty. **/
    public DelayQueueImpl()
    {
        delayQueue = new DelayQueue<E>();
    }

    /**
     * Creates a DelayQueue initially containing the elements of the given
     * collection of Delayed instances.
     **/
    public DelayQueueImpl(Collection<? extends E> c)
    {
        delayQueue = new DelayQueue<>(c);
    }

    /**
     * Inserts the specified element into this delay queue.
     **/
    public boolean add(E e)
    {
        return delayQueue.add(e);
    }

    /** Atomically removes all of the elements from this queue. **/
    public void clear()
    {
        delayQueue.clear();
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return delayQueue.contains(o);
    }

    /**
     * Removes all available elements from this queue and adds them to the given
     * collection.
     **/
    public int drainTo(Collection<? super E> c)
    {
        return delayQueue.drainTo(c);
    }

    /**
     * Removes at most the given number of available elements from this queue
     * and adds them to the given collection.
     **/
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        return delayQueue.drainTo(c, maxElements);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return delayQueue.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this queue is full.
     **/
    public boolean offer(E e)
    {
        return delayQueue.offer(e);
    }

    /** Inserts the specified element into this delay queue. **/
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return delayQueue.offer(e, timeout, unit);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return delayQueue.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return delayQueue.poll();
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary until
     * an element with an expired delay is available on this queue, or the
     * specified wait time expires
     **/
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        return delayQueue.poll(timeout, unit);
    }

    /** Inserts the specified element into this delay queue. **/
    public void put(E e) throws InterruptedException
    {
        delayQueue.put(e);
    }

    /**
     * Always returns Integer.MAX_VALUE because a DelayQueue is not capacity
     * constrained.
     **/
    public int remainingCapacity()
    {
        return delayQueue.remainingCapacity();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present, whether or not it has expired.
     **/
    public boolean remove(Object o)
    {
        return delayQueue.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return delayQueue.size();
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary until
     * an element with an expired delay is available on this queue.
     **/
    public E take() throws InterruptedException
    {
        return delayQueue.take();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return delayQueue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue; the
     * runtime type of the returned array is that of the specified array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return delayQueue.toArray(a);
    }

    static class DelayObjects implements Delayed
    {
        public long time;

        public DelayObjects()
        {
            getDelay(TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o)
        {
            if (this.time < ((DelayObjects) o).time)
                return -1;
            else if (this.time > ((DelayObjects) o).time)
                return 1;
            return 0;
        }

        @Override
        public long getDelay(TimeUnit unit)
        {
            time = System.currentTimeMillis();
            return time;
        }
    }

    public static void main(String... arg) throws InterruptedException
    {
        DelayQueueImpl<DelayObjects> arrayBlockingQueue = new DelayQueueImpl<DelayObjects>();
        DelayObjects delayObject1 = new DelayObjects();
        Thread.sleep(100);
        DelayObjects delayObject2 = new DelayObjects();
        Thread.sleep(100);
        DelayObjects delayObject3 = new DelayObjects();
        Thread.sleep(100);
        DelayObjects delayObject4 = new DelayObjects();
        Thread.sleep(100);
        DelayObjects delayObject5 = new DelayObjects();
        try
            {
                arrayBlockingQueue.put(delayObject1);
                arrayBlockingQueue.put(delayObject2);
                arrayBlockingQueue.put(delayObject3);
            }
        catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        arrayBlockingQueue.add(delayObject4);
        arrayBlockingQueue.add(delayObject5);
        System.out.println("the delaytimes of the DelayQueue is ");
        Iterator<DelayObjects> itr = arrayBlockingQueue.iterator();
        while (itr.hasNext())
            {
                System.out.print(itr.next().time + "\t");
            }
        System.out.println();
        arrayBlockingQueue.offer(new DelayObjects());
        arrayBlockingQueue.offer(new DelayObjects());
        System.out.println("the element time of the DelayQueue is(by peeking) "
                           + arrayBlockingQueue.peek().time);
        System.out.println("the remaining capcity is "
                           + arrayBlockingQueue.remainingCapacity());
        System.out.println("delayObject1 removed "
                           + arrayBlockingQueue.remove(delayObject1));
        System.out.println("the DelayQueue contains delayObject2 :"
                           + arrayBlockingQueue.contains(delayObject2));
        System.out.println("the hash DelayQueue contains delayObject3 :"
                           + arrayBlockingQueue.contains(delayObject3));
        System.out.println("the size of the arrayblocingqueue is "
                           + arrayBlockingQueue.size());
    }
}

/*
the delaytimes of the DelayQueue is
1385305755882   1385305755982   1385305756082   1385305756182   1385305756282
the element time of the DelayQueue is(by peeking) 1385305755882
the remaining capcity is 2147483647
delayObject1 removed true
the DelayQueue contains delayObject2 :true
the DelayQueue contains delayObject3 :true
the size of the DelayQueue is 6
