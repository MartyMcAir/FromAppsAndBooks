Count total number of occurences of a String in a text file

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class WordCounter {
	public static void main(String args[]) throws Exception {
		if(args.length != 1) {
			System.out.println("Invalid number of arguments!");
			return;
		}
		String sourcefile = args[0];
		String searchFor = "good bye";
		int searchLength=searchFor.length();
		String thisLine;
		try {
			BufferedReader bout = new BufferedReader (new FileReader (sourcefile));
			String ffline = null;
			int lcnt = 0;
			int searchCount = 0;
			while ((ffline = bout.readLine()) != null) {
				lcnt++;
				for(int searchIndex=0;searchIndex<ffline.length();) {
					int index=ffline.indexOf(searchFor,searchIndex);
					if(index!=-1) {
						System.out.println("Line number " + lcnt);
						searchCount++;
						searchIndex+=index+searchLength;
					} else {
						break;
					}
				}
			}
			System.out.println("SearchCount = "+searchCount);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
