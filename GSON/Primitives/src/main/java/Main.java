import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		var gson = new Gson();
		System.out.println(String.format("Serialization of %s is %s", 123, gson.toJson(123)));
		System.out.println(String.format("Serialization of %s is %s", 1.23, gson.toJson(1.23)));
		System.out.println(String.format("Serialization of %s is %s", "string", gson.toJson("string")));
		System.out.println(String.format("Serialization of %s is %s", true, gson.toJson(true)));
	}
}