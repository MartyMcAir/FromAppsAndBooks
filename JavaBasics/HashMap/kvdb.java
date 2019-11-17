import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the simplest key-value database");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> db = new HashMap<String, String>();
		while (true) {
			System.out.println("What do you want to do?");
			System.out.println("Enter P to [P]ut, G to [G]et or L to [L]ist");
			System.out.println("Or enter Q to [Q]uit");
			String action = br.readLine().toUpperCase();
			if (action.equals("P")) {
				System.out.print("Enter key: ");
				String k = br.readLine();
				System.out.print("Enter data: ");
				String d = br.readLine();
				db.put(k, d);
			} else if (action.equals("G")) {
				System.out.print("Enter key: ");
				String k = br.readLine();
				if (db.containsKey(k))
					System.out.println("Your data: " + db.get(k));
				else
					System.out.println("No such key");
			} else if (action.equals("L")) {
				System.out.println("DB contents:");
				System.out.println(db);
			} else if (action.equals("Q")) {
				System.out.println("Bye");
				return;
			}
			System.out.println();
		}
	}
}