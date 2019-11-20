public class Listing4_3 {
    public static void main(String[] args) {
        for(int weekDay=1; weekDay<=7; weekDay++) {
	System.out.print("День недели: "+weekDay+" Часы: ");
	for(int dayHour=1; dayHour<=24; dayHour++) {
		System.out.print(dayHour+" ");
	}
	System.out.print("\n");
        }
    } 
}
