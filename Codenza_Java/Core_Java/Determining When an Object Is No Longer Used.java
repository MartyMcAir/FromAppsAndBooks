Determining When an Object Is No Longer Used

// Create the weak reference.
ReferenceQueue rq = new ReferenceQueue();
WeakReference wr = new WeakReference(object, rq);

// Wait for all the references to the object.
     try {
         while (true) {
         Reference r = rq.remove();
             if (r == wr) {
             // Object is no longer referenced.
         }
     }
     } catch (InterruptedException e) {
}
