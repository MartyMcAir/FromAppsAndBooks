Remove repeated Strings from Vector

public static void main(String args[])
    {
         try{
        
         Vector v1 = new Vector();
         Vector v2 = new Vector();
         Vector temp=new Vector();
         String test = "test1,test2,test3,test4,test5,test1,test5";
         StringTokenizer st = new StringTokenizer(test,",");
         while(st.hasMoreTokens())
             {
             String tmp = st.nextToken();
             v1.add(tmp);
             v2.add(tmp);
         }
         System.out.println("v1="+v1);
         System.out.println("v2="+v2);
         String item2="";
        
         for(int k=0; k < v1.size(); k++)
             {
             String item=(String)v1.get(k);
            
             if(!temp.contains(item))
             temp.addElement(item);
         }
         v2=temp;
         System.out.println("v1="+v1);
         System.out.println("v2="+v2);
     }
     catch(Exception e){ e.printStackTrace(); }
}
