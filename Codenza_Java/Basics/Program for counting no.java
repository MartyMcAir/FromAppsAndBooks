Program for counting no. of Chars, Words and Lines in a file

import java.lang.*;
import java.io.*;
import java.util.*;
class WordCount
{
        public static void main(String arg[]) throws Exception
        {
                int char_count=0;
                int word_count=0;
                int line_count=0;
                String s;
                StringTokenizer st;
                BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter filename : ");
                s=buf.readLine();
                buf=new BufferedReader(new FileReader(s));
                while((s=buf.readLine())!=null)
                {
                        line_count++;
                        st=new StringTokenizer(s," ,;:.");
                        while(st.hasMoreTokens())
                        {
                                word_count++;
                                s=st.nextToken();
                                char_count+=s.length();
                        }
                }
                System.out.println("Character Count : "+char_count);
                System.out.println("Word Count : "+word_count);
                System.out.println("Line Count : "+line_count);
                buf.close();
        }
}
