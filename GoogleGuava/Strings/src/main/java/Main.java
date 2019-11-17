import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.base.Strings;

public class Main {
	public static void main(String[] args) {
		for (int y = 0; y <= 10; y++) {
			final int yf = y;
			String line = IntStream.rangeClosed(1, 10).boxed().map(x -> Strings.padStart("" + x * ((yf == 0) ? 1 : yf), 4, ' ')).collect(Collectors.joining(""));
			String header;
			if (y != 0)
				header = Strings.padStart("" + y, 4, ' ');
			else
				header = Strings.padStart("*", 4, ' ');
			System.out.println(header + line);
			System.out.println();
		}
	}
}