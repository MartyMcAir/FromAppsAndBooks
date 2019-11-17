import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		int N = 10;
		var threads = Stream.iterate(0, i -> i + 1).map(i -> new Thread(() -> {
			System.out.println("Thread " + i + " running");
		})).limit(N).collect(Collectors.toList());
		for (var t : threads)
			t.start();
	}
}