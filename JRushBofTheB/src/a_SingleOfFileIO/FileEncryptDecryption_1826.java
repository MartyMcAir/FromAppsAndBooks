package a_SingleOfFileIO;

/* 
Шифровка
*/

import java.io.*;
// https://javarush.ru/tasks/com.javarush.task.task18.task1826
//Придумать механизм шифровки/дешифровки.
//
//        Программа запускается с одним из следующих наборов параметров:
//        -e fileName fileOutputName
//        -d fileName fileOutputName
//
//        где:
//        fileName - имя файла, который необходимо зашифровать/расшифровать.
//        fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
//        -e - ключ указывает, что необходимо зашифровать данные.
//        -d - ключ указывает, что необходимо расшифровать данные.
//
//        Требования:
//        •	Считывать с консоли ничего не нужно.
//        •	Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
//        •	Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
//        •	В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
//        •	В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
//        •	Созданные для файлов потоки должны быть закрыты.
public class FileEncryptDecryption_1826 {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrPath = new String[]{dir + "data.txt", dir + "dataCrypt.txt.crypt",
                dir + "dataEncrypt.txt", "end"};
        // -e C:\z_n\new_test_folder\1\data.txt C:\z_n\new_test_folder\1\dataCrypt.txt.crypt
        // -d C:\z_n\new_test_folder\1\dataCrypt.txt.crypt C:\z_n\new_test_folder\1\dataEncrypt.txt

//        System.out.println(args[0]); // -e
//        System.out.println(args[1]); // C:\z_n\new_test_folder\1\data.txt
//        System.out.println(args[2]); // C:\z_n\new_test_folder\1\dataCrypt.txt.crypt
//        String tmp = args[0];

        String tmpEcrypt = "-e " + arrPath[0] + " " + arrPath[1];
        String tmpDcrypt = "-d " + arrPath[1] + " " + arrPath[2];
        String[] arrEcrypt = tmpEcrypt.split(" ");
        String[] arrDcrypt = tmpDcrypt.split(" ");
//        System.out.println(arrEcrypt[1]); // C:\z_n\new_test_folder\1\data.txt

//        if (arrEcrypt[0].startsWith("-e")) {
//            encryptFile(arrEcrypt[1], arrEcrypt[2]);
//        } else if (arrDcrypt[0].startsWith("-d")) {
//            decryptFile(arrDcrypt[1], arrDcrypt[2]);
//        }

        if (args[0].startsWith("-e")) {
            encryptFile(args[1], args[2]);
        } else if (args[0].startsWith("-d")) {
            decryptFile(args[1], args[2]);
        }

    }

    public static void encryptFile(String original, String crypted) throws IOException {
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(original));
        int allByte = bfIn.available();
        int cryptSize = (allByte / 2) + allByte;
        byte[] buffer = new byte[allByte];
//        while (bfIn.available() > 0) {
//            bfIn.read(buffer);
//        }
        for (int i = 0; i < allByte; i++) {
            buffer[i] = (byte) (bfIn.read() + 100);
        }
        bfIn.close();

        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(crypted));
        bfOut.write(buffer);
        bfOut.close();
    }

    public static void decryptFile(String cryptedOrig, String decryptedF) throws IOException {
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(cryptedOrig));
        int allByte = bfIn.available();
        byte[] buffer = new byte[allByte];
        for (int i = 0; i < allByte; i++) {
            buffer[i] = (byte) (bfIn.read() - 100);
        }
        bfIn.close();

        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(decryptedF));
        bfOut.write(buffer);
        bfOut.close();
    }

}
