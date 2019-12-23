Detect ASCII values

BufferedReader inStream=new BufferedReader(new InputStreamReader(System.in));
int a;

for(int i=1;i<=26;i++)
     {
    
     System.out.println("please enter a character: ");
     a=(int)System.in.read();
     System.out.println("The integer code for " +(char)a+ " is " +(int)a);
     inStream.readLine();
}
