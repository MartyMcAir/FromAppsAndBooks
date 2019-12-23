Read file



import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile 
{
    private String fileName = null;
    private int bufferSize = 1000;
    
    public ReadFile ()
    {}
    
    public ReadFile (String fileName, int bufferSize)
    {
        this.setFileName (fileName);
        this.setBufferSize (bufferSize);    
    }
    
    public ReadFile (String fileName)
    {
        this(fileName, 1000);
    }
    
    public void setFileName (String fileName)
    {
        this.fileName = fileName;    
    }
    
    public String getFileName ()
    {
        return this.fileName;    
    }
    
    public void setBufferSize (int bufferSize)
    {
        this.bufferSize = bufferSize;
    }
    
    public int getBufferSize ()
    {
        return this.bufferSize;    
    }
    
    public ArrayList read () throws java.io.FileNotFoundException, java.io.IOException
    {
        FileReader fr = new FileReader (this.getFileName());
        BufferedReader br = new BufferedReader (fr);
        ArrayList aList = new ArrayList (this.getBufferSize());
        
        String line = null;
        while (     (line = br.readLine()) != null)
        {
            aList.add(line);
        }
        
        br.close();
        fr.close();
        
        return aList;
    }
    
    public static void main (String args[])    //include main for testing purposes
    {
        try
        {
            ReadFile rf = new ReadFile("testFile");
            ArrayList a = rf.read();
            if (a.size() > 0)
            {
                System.out.println (a.get(0));
            }
        }
        catch (Exception e)
        {
            System.out.println (e.getMessage());    
        }
    }
}
