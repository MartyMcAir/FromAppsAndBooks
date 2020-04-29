package b_BigTusks.ConsoleCrud2_1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
//        allPeople.add(Person.createMale("Покемон Покемонов", new Date()));  //сегодня родился    id=2
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int count = 0, i = 0;
        int tmp1 = 1, tmp2 = 2, tmp3 = 3, tmp4 = 4;

        switch (args[0]) {
            case "-c":
                //  0   1     2   3  _ 4     5   6
                // -c name1 sex1 bd1 name2 sex2 bd2 ...
                // -c Покемон ж 19/05/2010 Покемо ж 19/05/2005
                synchronized (allPeople) {
                    if (args.length > 3) {
                        count = (args.length - 1) / 3;
                    }
                    do {
                        Person per;
                        if (args[tmp2].equals("м")) {
                            per = Person.createMale(args[tmp1], sdf.parse(args[tmp3]));
                        } else {
                            per = Person.createFemale(args[tmp1], sdf.parse(args[tmp3]));
                        }
                        allPeople.add(per);
                        System.out.println((allPeople.size() - 1));
//                System.out.println(allPeople.get((allPeople.size() - 1)).getName()); // work
                        tmp1 += 3;
                        tmp2 += 3;
                        tmp3 += 3;
                        i++;
                    } while (i < count);
                }
                break;
            case "-u":
                // 	0   1   2    3    4   _5    6    7   8
                // -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                // -u 0 Покемон ж 19/05/2010 1 Покемо ж 19/05/2005
                synchronized (allPeople) {
                    if (args.length > 4) {
                        count = (args.length - 1) / 4;
                    }
                    do {
                        Person per = allPeople.get(Integer.parseInt(args[tmp1]));
                        per.setName(args[tmp2]);
                        Sex sex = args[tmp3].equals("м") ? Sex.MALE : Sex.FEMALE;
                        per.setSex(sex);
                        per.setBirthDate(sdf.parse(args[tmp4]));
//                System.out.println(allPeople.get(Integer.parseInt(args[tmp1])).getName()); // work
                        tmp1 += 4;
                        tmp2 += 4;
                        tmp3 += 4;
                        tmp4 += 4;
                        i++;
                    } while (i < count);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    if (args.length >= 3) {
                        count = (args.length - 1); // отнимаем команду
                    }
                    do {
                        Person per = allPeople.get(Integer.parseInt(args[tmp1]));
                        per.setName(null);
                        per.setSex(null);
                        per.setBirthDate(null);
//                System.out.println(allPeople.get(tmp1 - 1).getName()); // индекс с нуля
                        tmp1++;
                        i++;
                    } while (i < count);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    if (args.length >= 3) {
                        count = (args.length - 1); // отнимаем команду
                    }
                    do {
                        Person per = allPeople.get(Integer.parseInt(args[tmp1]));
                        String sex = (per.getSex() == Sex.MALE) ? "м" : "ж";
                        sdf.applyPattern("dd-MMM-yyyy");
                        System.out.println(per.getName() + " " + sex + " " + sdf.format(per.getBirthDate()));
                        tmp1++;
                        i++;
                    } while (i < count);
                }
                break;
        }
    }
}
