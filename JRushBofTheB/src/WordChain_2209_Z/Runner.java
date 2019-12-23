package WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        String fileName = SimpleMethods.getPath()[4];
        String[] words = null;
        try (BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader fileReader = new BufferedReader(new FileReader(fileName, Charset.forName("cp1251")))) {
             BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String content = fileReader.lines().collect(Collectors.joining(" "));
            if (content.isEmpty()) {
                words = new String[3];
            } else {
                words = content.split("\\s+");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        TreeSet<WordInteger> set = new TreeSet<>();
        set.add(new WordInteger("six", 6));
        set.add(new WordInteger("four", 4));
        set.add(new WordInteger("two", 2));
        set.add(new WordInteger("tree", 3));
        set.add(new WordInteger("one", 1));
        set.add(new WordInteger("onee", 1));
        set.add(new WordInteger("oneee", 1));
        set.add(new WordInteger("five", 5));

//        set.forEach(System.out::println);

//        TreeSet<Word> setWord = new TreeSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (String item : words) {
            list.add(item);
        }
        Collections.sort(list);
//        list.forEach(System.out::println);

        ArrayList<Word> setWord = new ArrayList<>();
        for (String item : words) {
            setWord.add(new Word(item));
        }
        Collections.sort(setWord);
        setWord.forEach(System.out::println);
    }

    public static void counts() {
        SimpleMethods sim = new SimpleMethods();
        String[] arr = {"abc", "cde", "efg"};
        sim.arrToList(arr); // checked!
        ArrayList<Word> list = SimpleMethods.listAllWords;
//        list.forEach(v -> System.out.print(v.getWord() + " "));

        // чтоб заработало пришлось Overide hashCode() & equals()
//        System.out.println(sim.getFirstWord(list).getWord()); // cheked!
//        SimpleMethods.listFirstWords.add(new Word("abc"));
//        System.out.println(sim.getFirstWord(list).getWord());


//        System.out.println(sim.tryAddInsideList(list, new Word("ehe"))); // cheked!
//        list.forEach(v -> System.out.print(v.getWord() + " "));

//        System.out.println("_________");
//        sim.tryAddInList(list, new Word("cba")); // checked!
//        list.forEach(v -> System.out.print(v.getWord() + " "));


//        System.out.println("_________");
//        ArrayList<Word> newList = sim.getArrList(list);
//        SimpleMethods.listFirstWords.add(new Word("abc"));
//        newList.forEach(v -> System.out.print(v.getWord() + " ")); // checked!

//        System.out.println("'" + sim.listToString(list) + "'"); // checked!


        sim.loopForWords(3);
    }
}
