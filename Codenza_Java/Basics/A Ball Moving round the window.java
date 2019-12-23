A Ball Moving round the window

:/*             <applet code="screencircle2" width=300 height=300>
              </applet>                       */
import java.applet.*;
import java.awt.*;
public class screencircle2 extends Applet implements Runnable
{
       Thread t;
       int i,j,k,l,flag=0,m,x1,y1,x2,y2,m1,x3,y3,m2,m3;
       Color bg;
       public void init()
       {
       }
       public void start()
       {
               t=new Thread(this,"a");
               t.start();
       }
       public void run()
       {
                               paint1();
       }
       public void paint1()
       {
               Graphics g=getGraphics();
               try
               {
                       for(i=0;i<260;i++)
                       {
                               for(j=130;j<=260;j++)
                               {
                                       g.setColor(Color.red);
                                       g.fillOval(i,j,40,40);
                                       Thread.sleep(50);
                                       i=i+5;
                                       j=j+5;
                                       paint2();
                                       if(j>=260)
                                       {
                                               k=i;
                                               l=j;
                                               paint3();
                                               break;
                                       }
                               }
                       }
               }
               catch(InterruptedException s)
               {
                       //ShowStatus("error");
               }
       }
       public void paint3()
       {
               setBackground(Color.black);
               Graphics h=getGraphics();
               try
               {
                               for(x1=k;x1<=260;x1++)
                               {
                                       for(y1=j;y1>1;y1--)
                                       {
                                               h.setColor(Color.red);
                                               h.fillOval(x1,y1,40,40);
                                               Thread.sleep(50);
                                               x1=x1+6;
                                               y1=y1-4;
                                               paint2();
                                               if(x1>=260)
                                               {
                                                       m=x1;
                                                       m1=y1;
                                                       paint4();
                                               }
                                       }
                               }
               }
               catch(InterruptedException s1)
               {
                       //ShowStatus("error");
               }
       }
       public void paint4()
       {
               Graphics h1=getGraphics();
               try
               {
                               for(x2=m;x2>=40;x2--)
                               {
                                       for(y2=m1;y2>=1;y1--)
                                       {
                                               h1.setColor(Color.red);
                                               h1.fillOval(x2,y2,40,40);
                                               Thread.sleep(50);
                                               x2=x2-5;
                                               y2=y2-6;
                                               paint2();
                                               if(y2<=1)
                                               {
                                                       m2=x2;
                                                       m3=y2;
                                                       paint5();
                                               }
                                       }
                               }
               }
               catch(InterruptedException s1)
               {
                       //ShowStatus("error");
               }
       }
       public void paint5()
       {
               setBackground(Color.black);

               Graphics h2=getGraphics();
               try
               {
                               for(x3=m2;x3>=1;x3--)
                               {
                                       for(y3=m3;y3<260;y3++)
                                       {
                                               h2.setColor(Color.red);
                                               h2.fillOval(x3,y3,40,40);
                                               Thread.sleep(50);
                                               x3=x3-6;
                                               y3=y3+4;
                                               paint2();
                                               if(x3<=1)
                                               {
                                                       m=x1;
                                                       m1=y1;
                                                       paint1();
                                               }
                                       }
                               }
               }
               catch(InterruptedException s1)
               {
                       //ShowStatus("error");
               }
       }


       public void paint2()
       {
               Graphics d=getGraphics();
               d.setColor(Color.white);
               d.fillRect(0,0,300,300);
               setBackground(Color.black);
       }
}
