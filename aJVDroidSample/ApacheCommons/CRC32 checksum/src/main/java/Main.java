import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {
	public static void main(String[] args) throws IOException {
		final String FILENAME = "./pom.xml";
		System.out.println(FILENAME + " file checksum:");
		System.out.println(FileUtils.checksumCRC32(new File(FILENAME)));
	}
}