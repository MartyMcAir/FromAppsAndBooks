Print total number of lines in a file

import java.io.*;

public class LineCount
{
	static public void main(String args[]) throws Exception
	{

		//Change the directory where the count files are existing
		File di   = new File("c:/count");
		File fl[] = di.listFiles();
		int j;
		int count=0;
		String str="";
		String totalinfo="";


		for (j=0; j < fl.length; j++)
		{
			System.out.println(""+fl[j]);
			FileInputStream fis = new FileInputStream(fl[j].getCanonicalFile());
			LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
			while ((str=l.readLine())!=null)
			{
				count = l.getLineNumber();
			}
			System.out.println(count);

			String filename = fl[j].getName().toString();
			totalinfo = filename+"-------------"+count;

			FileOutputStream file = new FileOutputStream("c:/one.txt",true); //append
			PrintStream printtofile = new PrintStream(file);
			printtofile.println(totalinfo);
			printtofile.close();
			file.close();



			//BufferedWriter bw = new BufferedWriter(new FileWriter("c:/one.txt", false));
			//bw.write(totalinfo);
			//bw.newLine();
			//bw.close();


		}
	}
}
