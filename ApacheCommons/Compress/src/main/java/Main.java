import java.io.ByteArrayOutputStream;

import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		final var STRING_SIZE = 10 * 1024 * 1024;
		var uncompressed = "A".repeat(STRING_SIZE);
		var bos = new ByteArrayOutputStream();
		var gcos = new GzipCompressorOutputStream(bos);
		gcos.write(uncompressed.getBytes(), 0, STRING_SIZE);
		gcos.close();
		System.out.println("Uncompressed data size: " + STRING_SIZE);
		System.out.println("Gzip compressed data size: " + bos.size());
	}
}