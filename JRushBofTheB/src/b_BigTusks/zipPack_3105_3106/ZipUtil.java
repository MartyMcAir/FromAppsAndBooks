package b_BigTusks.zipPack_3105_3106;

import java.io.*;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

// From http://www.javenue.info/post/35 ___ решение с рекурсией
public class ZipUtil {
    public static void main(String[] args) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("C:\\z_pathToTest\\2.zip"));

        File file = new File("C:\\z_n\\new_test_folder\\1\\2");

        doZip(file, out);

        out.close();
    }

    private static void doZip(File dir, ZipOutputStream out) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                doZip(f, out);
            else {
                out.putNextEntry(new ZipEntry(f.getPath()));
                write(new FileInputStream(f), out);
            }
        }
    }

    public static void unZip(Path pathForUnZip) {
        File file = new File(pathForUnZip.toString());
        if (!file.exists() || !file.canRead()) {
            System.out.println("File cannot be read");
            return;
        }

        try {
            ZipFile zip = new ZipFile(pathForUnZip.toString());
            Enumeration entries = zip.entries();

            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                System.out.println(entry.getName());

                if (entry.isDirectory()) {
                    new File(file.getParent(), entry.getName()).mkdirs();
                } else {
                    write(zip.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(
                            new File(file.getParent(), entry.getName()))));
                }
            }

            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }
}
