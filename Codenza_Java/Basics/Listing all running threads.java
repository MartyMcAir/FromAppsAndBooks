Listing all running threads

// Find the root thread group
ThreadGroup root = Thread.currentThread().getThreadGroup().getParent();
    while (root.getParent() != null) {
     root = root.getParent();
}

// Visit each thread group
visit(root, 0);

// This method recursively visits all thread groups under `group'.
    public static void visit(ThreadGroup group, int level) {
     // Get threads in `group'
     int numThreads = group.activeCount();
     Thread[] threads = new Thread[numThreads*2];
     numThreads = group.enumerate(threads, false);
    
     // Enumerate each thread in `group'
         for (int i=0; i         // Get thread
         Thread thread = threads[i];
     }
    
     // Get thread subgroups of `group'
     int numGroups = group.activeGroupCount();
     ThreadGroup[] groups = new ThreadGroup[numGroups*2];
     numGroups = group.enumerate(groups, false);
    
     // Recursively visit each subgroup
         for (int i=0; i         visit(groups[i], level+1);
     }
}

//Here's an example of some thread groups that contain some threads: 
java.lang.ThreadGroup[name=system,maxpri=10]
Thread[Reference Handler,10,system]
Thread[Finalizer,8,system]
Thread[Signal Dispatcher,10,system]
Thread[CompileThread0,10,system]
java.lang.ThreadGroup[name=main,maxpri=10]
Thread[main,5,main]
Thread[Thread-1,5,main]
