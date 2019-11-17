import java.util.Arrays;

public class Main {

	static class XorSecurityException extends Exception {
		String reason;
		XorSecurityException(String reason) {
			this.reason = reason;
		}
		@Override
		public String toString() {
			return String.format("%s: %s", this.getClass().getSimpleName(), reason);
		}
	}

	private static byte[] xorCrypt(byte[] data, byte[] key) throws XorSecurityException {
		byte zerocheck = 0;
		for (var b : key)
			zerocheck |= b;
		if (zerocheck == 0)
			throw new XorSecurityException("All zero key detected");
		var ret = Arrays.copyOf(data, data.length);
		for (int i = 0; i < data.length; i++)
			ret[i] ^= key[i % key.length];
		return ret;
	}

	public static void main(String[] args) {
		var data = "secretdata".getBytes();
		var okkey = new byte[] {1, 2, 3, 4};
		var badkey = new byte[] {0, 0};
		try {
			System.out.println("data ^ okkey = " + Arrays.toString(xorCrypt(data, okkey)));
			System.out.println("data ^ badkey = " + Arrays.toString(xorCrypt(data, badkey)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}