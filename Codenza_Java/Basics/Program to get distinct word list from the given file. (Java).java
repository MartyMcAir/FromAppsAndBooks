/*
Write a program to find all distinct words from the given file. Remove special chars like ".,;:" etc. Ignore case sensitivity.
*/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MyDistinctFileWords
{

    public List<String> getDistinctWordList(String fileName)
    {
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        List<String> wordList = new ArrayList<String>();
        try
            {
                fis = new FileInputStream(fileName);
                dis = new DataInputStream(fis);
                br = new BufferedReader(new InputStreamReader(dis));
                String line = null;
                while((line = br.readLine()) != null)
                    {
                        StringTokenizer st = new StringTokenizer(line, " ,.;:\"");
                        while(st.hasMoreTokens())
                            {
                                String tmp = st.nextToken().toLowerCase();
                                if(!wordList.contains(tmp))
                                    {
                                        wordList.add(tmp);
                                    }
                            }
                    }
            }
        catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        catch (IOException e)
            {
                e.printStackTrace();
            }
        finally
            {
                try
                    {
                        if(br != null) br.close();
                    }
                catch(Exception ex) {}
            }
        return wordList;
    }

    public static void main(String a[])
    {
        MyDistinctFileWords distFw = new MyDistinctFileWords();
        List<String> wordList = distFw.getDistinctWordList("C:/sample.txt");
        for(String str:wordList)
            {
                System.out.println(str);
            }
    }
}
