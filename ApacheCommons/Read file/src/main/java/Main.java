import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {
	public static void main(String[] args) throws IOException {
		final String FILENAME = "./textfile";
		System.out.println(FILENAME + " file contents:");
		System.out.println(FileUtils.readFileToString(new File(FILENAME), "UTF-8"));
	}
}