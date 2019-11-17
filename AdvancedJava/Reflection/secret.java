public class Main {

	public static void main(String[] args) throws Exception {
		var storage = new SecretStorage(1337);
		var clazz = Class.forName("SecretStorage");
		var getSecretData = clazz.getDeclaredMethod("getSecretData");
		getSecretData.setAccessible(true);
		System.out.println((String) getSecretData.invoke(storage));
	}
}

class SecretStorage {
	int id;
	SecretStorage(int id) {
		this.id = id;
	}

	private String getSecretData() {
		return "This string is not accesible from outside classes, object id: " + id;
	}
}