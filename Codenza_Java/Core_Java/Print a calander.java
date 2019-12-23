Print a calander

import java.io.*;

    class cal{
        public boolean isLeapYear(int y){
            if (y%4==0){
                 if(y%100==0) {
             if(y%400==0)return true;else return false;}
         else return true;}else
    return false;}
    public int startingDayOfYear(int y)
        {
        int ly,oy,rem;
        y%=400;
        ly=y/4;
        oy=y-ly;
        rem=(ly * 2)+oy+1;
        rem%=7;
        return rem;
        
    }
}
    class calander{
        public static void main(String args[]){
        String week[]={"sun","mon","tue","wed","thu","fri","sat"};
        String mon[]={"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
        int md[]={31,28,31,30,31,30,31,31,30,31,30,31};
        int year[][][]=new int[12][7][6],m,i,j,q;
        cal c=new cal();
        System.out.println("ok");
        q=c.startingDayOfYear(Integer.parseInt(args[0])-1);
        if(c.isLeapYear(Integer.parseInt(args[0])))md[1]=29;
        //System.out.println(week[c.startingDayOfYear(Integer.parseInt(args[0])-1)]);
        for(m=0;m<=11;m++)
            {
            j=0;
            for(i=1;i<=md[m];i++)
                {
                year[m][q][j]=i;
                q++;if(q==7){q=0;j++;}
            }
        }
        
        for(m=0;m<=11;m++)
            {
            
            System.out.println(args[0]+", "+mon[m]);
            System.out.println("--------------------");
            for(i=0;i<=6;i++)
                {
                for(j=0;j<=5;j++)
                    {
                    if (year[m][i][j]==0)
                    System.out.print(" ");
                    else
                    System.out.print(year[m][i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("--------------------");
            System.out.println();
        }
    }
}
