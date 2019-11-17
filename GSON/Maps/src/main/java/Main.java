import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("Number", 123);
		map.put("String", "string");
		map.put("Boolean", true);

		var gson = new Gson();
		var serialized = gson.toJson(map);
		System.out.println("Serialized map:");
		System.out.println(serialized);
		var deserialized = gson.fromJson(serialized, Map.class);
		System.out.println("Deserialized map:");
		System.out.println(deserialized);
	}
}