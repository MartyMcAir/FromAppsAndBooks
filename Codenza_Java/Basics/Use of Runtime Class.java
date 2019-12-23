Use of Runtime Class

import java.io.*;
class test extends Thread
{
  public void  run()
  {
    Runtime r=Runtime.getRuntime();
		 Process p=null;
		 try
		   {
		 		 for(int i=0;i<=100;i++)
		 		  {
		 		    p=r.exec("net send  vishal how r u!");
		        //p.waitFor();
		        Thread.sleep(5000);
		 		  }
		   }
		 		 catch(Exception e)
		 		 {
		 		  System.out.println(e);
		 		 }
   }

  public static void main(String args[])
      {
      test t=new test();
      t.run();

     }

}
