import java.io.File;

import org.apache.commons.io.FilenameUtils;

public class Main {
	public static void main(String[] args) {
		final String FILENAME = new File("pom.xml").getAbsolutePath();
		String full = FilenameUtils.getFullPath(FILENAME);
		String base = FilenameUtils.getBaseName(FILENAME);
		String ext = FilenameUtils.getExtension(FILENAME);
		System.out.println(String.format("Full path to the file is %s", full));
		System.out.println(String.format("Basename of the file is %s", base));
		System.out.println(String.format("Extension of the file is %s", ext));
	}
}