public class Listing5_1 {

    public static void main(String[] args) {
        int[] even = new int[10];
        for(int i=0;i<10;i++){
            even[i] = i*2+2;
        }
        for(int data:even){
            System.out.println(data);
        }
    } 
}
