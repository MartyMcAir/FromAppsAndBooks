import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static boolean isPrimeJ8(int x) {
		return IntStream.rangeClosed(2, (int)Math.sqrt(x)).allMatch(n -> x % n != 0);
	}

	public static void main(String[] args) {
		int N = 100;
		var primes = Stream.iterate(2, x -> x + 1).filter(Main::isPrimeJ8).limit(N).collect(Collectors.toList());
		System.out.println(String.format("First %d primes:", N));
		System.out.println(primes);
	}
}