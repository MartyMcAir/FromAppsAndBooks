import java.util.Random;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main {
	public static void main(String[] args) {
		Multimap<Boolean, Integer> map = ArrayListMultimap.create();
		for (var i : new Random().ints(20, 0, 100).toArray())
			map.put(i % 2 == 0, i);
		System.out.print("Even numbers: ");
		System.out.println(map.get(true));
		System.out.print("Odd numbers: ");
		System.out.println(map.get(false));
	}
}