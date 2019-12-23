Limiting the Size of a Log by Using a Rotating Sequence of Files

try {
     // Create a file handler that uses 3 logfiles, each with a limit of 1Mbyte
     String pattern = "my%g.log";
     int limit = 1000000; // 1 Mb
     int numLogFiles = 3;
     FileHandler fh = new FileHandler(pattern, limit, numLogFiles);
    
     // Add to logger
     Logger logger = Logger.getLogger("com.mycompany");
     logger.addHandler(fh);
    } catch (IOException e) {
}
