import com.google.gson.Gson;

import org.apache.commons.codec.digest.DigestUtils;

public class Main {

	public static class User {
		String name;
		// Make sure plaintext password doesn't appear in serialization
		transient String password;
		String password_hash;
		long timestamp;
		User(String name, String password) {
			this.name = name;
			this.password = password;
			this.password_hash = DigestUtils.md5Hex(password);
			this.timestamp = System.currentTimeMillis();
		}
		@Override
		public String toString() {
			return String.format("User(name=%s, password=%s, password_hash=%s, timestamp=%s)", name, password, password_hash, timestamp);
		}
	}

	public static void main(String[] args) {
		var user = new User("admin", "password");
		System.out.println("User before serialization:");
		System.out.println(user);
		var gson = new Gson();
		String json = gson.toJson(user);
		System.out.println("Serialized user:");
		System.out.println(json);
		var user_deserialized = gson.fromJson(json, User.class);
		System.out.println("Deserialized user:");
		System.out.println(user_deserialized);
	}
}