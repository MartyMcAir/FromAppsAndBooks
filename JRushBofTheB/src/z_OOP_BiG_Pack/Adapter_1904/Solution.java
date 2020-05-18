package z_OOP_BiG_Pack.Adapter_1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScanner ps = new PersonScannerAdapter(new Scanner(
                new File("C:\\z_n\\new_test_folder\\1\\data.txt")));
        //Ну и заодно вызвал методы чтобы глянуть как все работает
        Person person = ps.read();
        System.out.println(person);
        ps.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
//            String line = fileScanner.nextLine(); //прочел запись в файле
            String line = "Иванов Иван Иванович 31 12 1950";
            String[] arr = line.split("\\s", 4);//Разбил на 4 строки, последняя с датой

            // Person(String firstName, String middleName, String lastName, Date birthDate)
            // toString String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
            Person person = null;
            try {
                Date date = new SimpleDateFormat("dd M y", Locale.ENGLISH).parse(arr[3]);
                person = new Person(arr[1], arr[2], arr[0], date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
