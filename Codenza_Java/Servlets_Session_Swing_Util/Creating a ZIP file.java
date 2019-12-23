Creating a ZIP file

public class ZipFolder {
    
     ZipOutputStream zos; // Output stream for destination zip file.
    
         ZipFolder(File src, File des) {
         zipData(src,des);
     }
    
         public static void main(String args[]) {
             try {
             File src = new File(args[0]);
             File des = new File(args[1]);
             if(!args[1].toLowerCase().substring(args[1].length() - 4, args[1].length()).equalsIgnoreCase(".zip")) throw new ArrayIndexOutOfBoundsException();
             new ZipFolder(src,des);
             } catch (ArrayIndexOutOfBoundsException aioobe) {
             System.out.println("The Usage of this command:\n ZipFolder \n Ex: ZipFolder c:\\backup c:\\feb2002.zip");
         }
     }
    
         public void zipData(File source,File destination) {
             try {
             File zipfile = new File(destination.getPath());
             zos = new ZipOutputStream( new FileOutputStream(zipfile));
             File arrFile[];
             arrFile = source.listFiles();
                 if (arrFile.length >0) {
                 checkFile(source); //Calling recursively
                 zos.close();
                 System.out.println("Winzip file is created successfully");
             }
             else
             System.out.println("There is no file in the specified source");
             }catch(Exception ze) {
             System.out.println("Exception occured in zipping file. Details :\n" + ze.getMessage());
         }
     }
    
         public void writeToZip(File src) throws DataFormatException, ZipException, FileNotFoundException, IOException {
         // This function write s the data in to Zipoutput Stream.
         byte b[] = new byte[512];
         FileInputStream is = new FileInputStream(src);
         ZipEntry ze = new ZipEntry(src.toString());
         zos.putNextEntry(ze);
         int len = 0;
         while ((len =is.read(b))!= -1)
         zos.write(b,0,len);
         zos.closeEntry();
         System.out.println("Zipping file " + src + " is done");
         is = null;
     }
    
         public void checkFile(File fo) {
         /*This is a recursive function. If the File object is a file then it calls the function
         to write to zipoutput stream. If it is a directory it gets the list of file objects
         in the child directory and calls itself
         */
             try {
             if(fo.isFile())
             writeToZip(fo);
                 else {
                 File foarr[];
                 foarr = fo.listFiles();
                 for (int i=0; i                 checkFile(foarr[i]);
             }
             }catch(java.util.zip.DataFormatException dfe) {
             System.out.println("Input data is not in proper format. Details :\n" + dfe.getMessage());
             }catch(java.util.zip.ZipException ze) {
             System.out.println("Exception occured in zipping file. Details :\n" + ze.getMessage());
             }catch(java.io.FileNotFoundException fnfe) {
             System.out.println("File is missing. Details :\n" + fnfe.getMessage());
             }catch(java.io.IOException ioe) {
             System.out.println("Input / Output problem. Details :\n" + ioe.getMessage());
         }
     }
}
