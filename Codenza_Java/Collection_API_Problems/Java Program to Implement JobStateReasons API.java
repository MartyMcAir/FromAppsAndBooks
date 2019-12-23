import java.util.Collection;
import javax.print.attribute.Attribute;
import javax.print.attribute.standard.JobStateReason;
import javax.print.attribute.standard.JobStateReasons;

public class JobStateReasonsImpl
{
    private JobStateReasons jobStateReasons;

    /**
     * Construct a new, empty job state reasons attribute; the underlying hash
     * set has the default initial capacity and load factor.
    **/
    public JobStateReasonsImpl()
    {
        jobStateReasons = new JobStateReasons();
    }

    /**
     * Construct a new job state reasons attribute that contains the same
     * JobStateReason objects as the given collection.
    **/
    public JobStateReasonsImpl(Collection<JobStateReason> collection)
    {
        jobStateReasons = new JobStateReasons(collection);
    }

    /**
     * Construct a new, empty job state reasons attribute; the underlying hash
     * set has the given initial capacity and the default load factor.
    **/
    public JobStateReasonsImpl(int initialCapacity)
    {
        jobStateReasons = new JobStateReasons(initialCapacity);
    }

    /**
     * Construct a new, empty job state reasons attribute; the underlying hash
     * set has the given initial capacity and load factor.
     **/
    public JobStateReasonsImpl(int initialCapacity, float loadFactor)
    {
        jobStateReasons = new JobStateReasons(initialCapacity, loadFactor);
    }

    /**
     * Adds the specified element to this job state reasons attribute if it is
     * not already present.
    **/
    public boolean add(JobStateReason o)
    {
        return jobStateReasons.add(o);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
    **/
    public Class<? extends Attribute> getCategory()
    {
        return jobStateReasons.getCategory();
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     **/
    public String getName()
    {
        return jobStateReasons.getName();
    }

    /** return true if this set contains the specified element **/
    public boolean contains(Object obj)
    {
        return jobStateReasons.contains(obj);
    }

    /** returns true if the set is empty **/
    public boolean isEmpty()
    {
        return jobStateReasons.isEmpty();
    }

    /** removes the specified element from this set if present **/
    public boolean remove(Object obj)
    {
        return jobStateReasons.remove(obj);
    }

    /** returns the number of elements in set **/
    public int size()
    {
        return jobStateReasons.size();
    }

    /** removes all elements from this set **/
    public void clear()
    {
        jobStateReasons.clear();
    }

    /** Returns an array containing all of the elements in this set. **/
    public Object[] toArray()
    {
        return jobStateReasons.toArray();
    }

    public static void main(String... arg)
    {
        JobStateReasonsImpl jobStateReasons = new JobStateReasonsImpl();
        jobStateReasons.add(JobStateReason.COMPRESSION_ERROR);
        jobStateReasons.add(JobStateReason.JOB_CANCELED_BY_USER);
        jobStateReasons.add(JobStateReason.JOB_COMPLETED_WITH_WARNINGS);
        jobStateReasons.add(JobStateReason.DOCUMENT_FORMAT_ERROR);
        System.out.println("the name of category " + jobStateReasons.getName());
        System.out.println("the jobStateReason are");
        Object[] array = (Object[]) jobStateReasons.toArray();
        for (int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + "\t");
            }
        System.out.println();
        jobStateReasons.clear();
        System.out.println("jobStateReasons cleared");
        if (jobStateReasons.isEmpty())
            System.out.println("jobStateReasons is empty");
        else
            System.out.println("jobStateReasons is not empty");
    }
}

/*
the name of category job-state-reasons
the jobStateReason are
compression-error   document-format-error   job-completed-with-warnings job-canceled-by-user
jobStateReasons cleared
jobStateReasons is not empty
