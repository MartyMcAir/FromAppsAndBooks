import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueImpl<E>
{
    private SynchronousQueue<E> synchronousQueue;

    /** Creates a SynchronousQueue with nonfair access policy. **/
    public SynchronousQueueImpl()
    {
        synchronousQueue = new SynchronousQueue<E>();
    }

    /** Creates a SynchronousQueue with the specified fairness policy. **/
    public SynchronousQueueImpl(boolean fair)
    {
        synchronousQueue = new SynchronousQueue<E>(fair);
    }

    /** Inserts the specified element at the tail of this queue. **/
    public boolean add(E e)
    {
        return synchronousQueue.add(e);
    }

    /** Atomically removes all of the elements from this queue. **/
    public void clear()
    {
        synchronousQueue.clear();
    }

    /** Returns true if this queue contains the specified element. **/
    public boolean contains(Object o)
    {
        return synchronousQueue.contains(o);
    }

    /**
     * Removes all available elements from this queue and adds them to the given
     * collection.
     **/
    public int drainTo(Collection<? super E> c)
    {
        return synchronousQueue.drainTo(c);
    }

    /**
     * Removes at most the given number of available elements from this queue
     * and adds them to the given collection.
     **/
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        return synchronousQueue.drainTo(c, maxElements);
    }

    /** Returns an iterator over the elements in this queue in proper sequence. **/
    public Iterator<E> iterator()
    {
        return synchronousQueue.iterator();
    }

    /**
     * Inserts the specified element at the tail of this queue if it is possible
     * to do so immediately without exceeding the queue's capacity, returning
     * true upon success and false if this queue is full.
     **/
    public boolean offer(E e)
    {
        return synchronousQueue.offer(e);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting up to
     * the specified wait time for space to become available if the queue is
     * full.
     **/
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        return synchronousQueue.offer(e, timeout, unit);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     **/
    public E peek()
    {
        return synchronousQueue.peek();
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     **/
    public E poll()
    {
        return synchronousQueue.poll();
    }

    /**
     * Retrieves and removes the head of this queue, waiting up to the specified
     * wait time if necessary for an element to become available.
     **/
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        return synchronousQueue.poll(timeout, unit);
    }

    /**
     * Inserts the specified element at the tail of this queue, waiting for
     * space to become available if the queue is full.
     **/
    public void put(E e) throws InterruptedException
    {
        synchronousQueue.put(e);
    }

    /**
     * Always returns Integer.MAX_VALUE because a PriorityBlockingQueue is not
     * capacity constrained.
     **/
    public int remainingCapacity()
    {
        return synchronousQueue.remainingCapacity();
    }

    /**
     * Removes a single instance of the specified element from this queue, if it
     * is present.
     **/
    public boolean remove(Object o)
    {
        return synchronousQueue.remove(o);
    }

    /** Returns the number of elements in this queue. **/
    public int size()
    {
        return synchronousQueue.size();
    }

    /**
     * Retrieves and removes the head of this queue, waiting if necessary until
     * an element becomes available
     **/
    public E take() throws InterruptedException
    {
        return synchronousQueue.take();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence.
     **/
    public Object[] toArray()
    {
        return synchronousQueue.toArray();
    }

    /**
     * Returns an array containing all of the elements in this queue, in proper
     * sequence; the runtime type of the returned array is that of the specified
     * array.
     **/
    public <T> T[] toArray(T[] a)
    {
        return synchronousQueue.toArray(a);
    }

    /** Returns a string representation of this collection. **/
    public String toString()
    {
        return synchronousQueue.toString();
    }

    public static void main(String... arg) throws InterruptedException
    {
        SynchronousQueueImpl<Integer> synchronousQueue = new SynchronousQueueImpl<Integer>();
        new Thread(new SynchronousQueueImpl<>().new PutThread(
                       synchronousQueue.synchronousQueue)).start();
        new Thread(new SynchronousQueueImpl<>().new TakeThread(
                       synchronousQueue.synchronousQueue)).start();
    }

    class PutThread implements Runnable
    {
        BlockingQueue SynchronousQueue;

        public PutThread(BlockingQueue q)
        {
            this.SynchronousQueue = q;
        }

        @Override
        public void run()
        {
            try
                {
                    SynchronousQueue.put(19);
                    System.out.println("19 added to synchronous queue by PutThread");
                    Thread.sleep(1000);
                }
            catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
    }

    class TakeThread implements Runnable
    {
        BlockingQueue SynchronousQueue;

        public TakeThread(BlockingQueue q)
        {
            this.SynchronousQueue = q;
        }

        @Override
        public void run()
        {
            try
                {
                    this.SynchronousQueue.take();
                    System.out.println("19 removed from synchronous queue by TakeThread");
                }
            catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
    }
}
/*
19 added to synchronous queue by PutThread
19 removed from synchronous queue by TakeTh
