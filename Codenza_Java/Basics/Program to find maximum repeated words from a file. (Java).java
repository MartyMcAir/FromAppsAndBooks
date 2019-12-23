/*
Write a program to read words from a file. Count the
repeated or duplicated words. Sort it by maximum repeated or
duplicated word count.
*/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class MaxDuplicateWordCount
{

    public Map<String, Integer> getWordCount(String fileName)
    {
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        try
            {
                fis = new FileInputStream(fileName);
                dis = new DataInputStream(fis);
                br = new BufferedReader(new InputStreamReader(dis));
                String line = null;
                while((line = br.readLine()) != null)
                    {
                        StringTokenizer st = new StringTokenizer(line, " ");
                        while(st.hasMoreTokens())
                            {
                                String tmp = st.nextToken().toLowerCase();
                                if(wordMap.containsKey(tmp))
                                    {
                                        wordMap.put(tmp, wordMap.get(tmp)+1);
                                    }
                                else
                                    {
                                        wordMap.put(tmp, 1);
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
        return wordMap;
    }

    public List<Entry<String, Integer>> sortByValue(Map<String, Integer> wordMap)
    {
        Set<Entry<String, Integer>> set = wordMap.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        return list;
    }

    public static void main(String a[])
    {
        MaxDuplicateWordCount mdc = new MaxDuplicateWordCount();
        Map<String, Integer> wordMap = mdc.getWordCount("C:/MyTestFile.txt");
        List<Entry<String, Integer>> list = mdc.sortByValue(wordMap);
        for(Map.Entry<String, Integer> entry:list)
            {
                System.out.println(entry.getKey()+" ==== "+entry.getValue());
            }
    }
}
