Timer

public final class Timer {
     private long time = 0L;
     static private Timer timer = null;
         private Timer() {
         time = -System.currentTimeMillis();
     };
    
         static public Timer getInstance() {
         if(timer == null) timer = new Timer();
         return timer;
        
     };
    
         public final String toString() {
         time += System.currentTimeMillis();
         return new StringBuffer(getClass().getName()).append(": [").append(time).append(" ms]").toString();
     };
    
};;
