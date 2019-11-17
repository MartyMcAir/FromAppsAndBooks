import java.util.Random;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		var nums = new Random().ints(25, -100, 100).boxed().collect(Collectors.toList());
		var abssort = nums.stream().sorted((a, b) -> Integer.compare(Math.abs(a), Math.abs(b))).collect(Collectors.toList());
		System.out.println(String.format("Numbers: %s", nums));
		System.out.println(String.format("Sorted by absolute value: %s", abssort));
	}
}