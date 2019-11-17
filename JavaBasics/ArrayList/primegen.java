import java.util.ArrayList;

public class Main {

	public static boolean isPrimeSimple(int x) {
		for (int i = 2; i * i <= x; i++)
			if (x % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int N = 100;
		for (int i = 2; primes.size() < N; i++)
			if (isPrimeSimple(i))
				primes.add(i);
		System.out.println(String.format("First %d primes:", N));
		System.out.println(primes);
	}
}