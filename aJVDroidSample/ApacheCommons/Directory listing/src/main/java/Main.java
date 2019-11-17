import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class Main {
	public static void main(String[] args) {
		System.out.println("Listing the current directory:");
		for (var f : FileUtils.listFilesAndDirs(new File("."), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE))
			System.out.println(f);
	}
}