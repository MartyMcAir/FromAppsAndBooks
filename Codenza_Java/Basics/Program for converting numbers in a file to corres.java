Program for converting numbers in a file to corresponding words

import java.io.*;
import java.lang.*;

class NumToWords
{
        public static void main(String a[]) throws IOException
        {
                String s="";
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter filename : ");
                try
                {
                        s=br.readLine();
                }catch(Exception e){}
                InputStream in=new FileInputStream(s);
                MyInputStream mis=new MyInputStream(in);
                mis.changeNumbers();
                in.close();
                mis.close();
        }
}
class MyInputStream extends FilterInputStream
{
        InputStream is;
        MyInputStream(InputStream in)
        {
                super(in);
                is=in;
        }
        public void changeNumbers() throws IOException
        {
                PushbackInputStream pis;
                String num="";
                char ch;
                int c;
                pis=new PushbackInputStream(is);
                while((c=pis.read())!=-1)
                {
                        ch=(char)c;
                        if('0'<=ch&&ch<='9')
                        {
                                num="";
                                while('0'<=ch&&ch<='9'&&c!=-1)
                                {
                                        num=num+ch;
                                        c=pis.read();
                                        ch=(char)c;
                                }
                                System.out.print(MyInputStream.process(num));
                                pis.unread(ch);
                        }
                        else
                                System.out.print(ch);
                }
        }
        static String process(String str)
        {
                String a1[]={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
                String a2[]={"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
                String a3[]={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
                String a4[]={"Hundered","Thousand","Lakhs","Crores"};
                int num=0;
                try
                {
                        num=Integer.parseInt(str);
                }catch(Exception e){}
                if(num==0)
                        return "Zero";
                int n,n1;
                String ans="";
                String ans1="";
                n1=num%10;
                num=num/10;
                if(n1!=0)
                        ans=a1[n1-1];
                if(num>0)
                {
                        n=num%10;
                        num=num/10;
                        if(n==1)
                                ans=a3[n1];
                        else if(n!=0)
                                ans=a2[n-2]+" "+ans;
                }
                if(num>0)
                {
                        n=num%10;
                        num=num/10;
                        if(n!=0)
                                ans=a1[n-1]+" "+a4[0]+" "+ans;
                }
                for(int i=1;num>0;i++)
                {
                        n1=num%10;
                        num=num/10;
                        if(n1!=0)
                                ans1=a1[n1-1];
                        if(num>0)
                        {
                                n=num%10;
                                num=num/10;
                                if(n==1)
                                        ans1=a3[n1];
                                else if(n!=0)
                                        ans1=a2[n-2]+" "+ans1;
                        }
                        ans=ans1+" "+a4[i]+" "+ans;
                        ans1="";
                }
                return(ans);
        }
}
