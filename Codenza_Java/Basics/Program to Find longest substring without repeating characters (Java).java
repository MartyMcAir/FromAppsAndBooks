/*
Given a string, find the longest substrings without repeating characters. Iterate through the given string, find the longest maximum substrings.

*/

import java.util.HashSet;
import java.util.Set;

public class MyLongestSubstr
{

    private Set<String> subStrList = new HashSet<String>();
    private int finalSubStrSize = 0;

    public Set<String> getLongestSubstr(String input)
    {
        //reset instance variables
        subStrList.clear();
        finalSubStrSize = 0;
        // have a boolean flag on each character ascii value
        boolean[] flag = new boolean[256];
        int j = 0;
        char[] inputCharArr = input.toCharArray();
        for (int i = 0; i < inputCharArr.length; i++)
            {
                char c = inputCharArr[i];
                if (flag[c])
                    {
                        extractSubString(inputCharArr,j,i);
                        for (int k = j; k < i; k++)
                            {
                                if (inputCharArr[k] == c)
                                    {
                                        j = k + 1;
                                        break;
                                    }
                                flag[inputCharArr[k]] = false;
                            }
                    }
                else
                    {
                        flag[c] = true;
                    }
            }
        extractSubString(inputCharArr,j,inputCharArr.length);
        return subStrList;
    }

    private String extractSubString(char[] inputArr, int start, int end)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<end; i++)
            {
                sb.append(inputArr[i]);
            }
        String subStr = sb.toString();
        if(subStr.length() > finalSubStrSize)
            {
                finalSubStrSize = subStr.length();
                subStrList.clear();
                subStrList.add(subStr);
            }
        else if(subStr.length() == finalSubStrSize)
            {
                subStrList.add(subStr);
            }
        return sb.toString();
    }

    public static void main(String a[])
    {
        MyLongestSubstr mls = new MyLongestSubstr();
        System.out.println(mls.getLongestSubstr("java2novice"));
        System.out.println(mls.getLongestSubstr("java_language_is_sweet"));
        System.out.println(mls.getLongestSubstr("java_java_java_java"));
        System.out.println(mls.getLongestSubstr("abcabcbb"));
    }
}
