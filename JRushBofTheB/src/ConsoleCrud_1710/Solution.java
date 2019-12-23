package ConsoleCrud_1710;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args[0].equals("-c")) { // Create _ add
            String name = args[1], sex = args[2], date = args[3];
            Person p;
            if (sex.equals("ж")) p = Person.createFemale(name, sdf.parse(date));
            else p = Person.createMale(name, sdf.parse(date));
            allPeople.add(p);
            System.out.println((allPeople.size() - 1));
        } else if (args[0].equals("-d")) {  // Delete _
            String id = args[1];
            Person per = allPeople.get(Integer.parseInt(id));
            per.setBirthDate(null);
            per.setName(null);
            per.setSex(null);
        } else if (args[0].equals("-u")) {   // Update
            int id = Integer.parseInt(args[1]);
            String name = args[2], sex = args[3], date = args[4];
            Person per = allPeople.get(id);
            if (sex.equals("м")) {
                per.setSex(Sex.MALE);
            } else if (sex.equals("ж")) {
                per.setSex(Sex.FEMALE);
            }
            per.setName(name);
            per.setBirthDate(sdf.parse(date));
        } else if (args[0].equals("-i")) { // get show by index
            String id = args[1];
            Person per = allPeople.get(Integer.parseInt(id));
            Sex sex = per.getSex();
            String setSex = null;
            if (sex == Sex.MALE) {
                setSex = "м";
            } else if (sex == Sex.FEMALE) {
                setSex = "ж";
            }
            sdf.applyPattern("dd-MMM-yyyy");
            System.out.println(per.getName() + " " + setSex + " " + sdf.format(per.getBirthDate()));
        }
    }

}
