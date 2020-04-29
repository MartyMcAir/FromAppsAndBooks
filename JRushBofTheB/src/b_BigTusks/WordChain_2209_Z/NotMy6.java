package b_BigTusks.WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

// https://javarush.ru/help/22374
// РЕШЕНИе!?
public class NotMy6 {

    public static void main(String[] args) throws Exception {
        List<String> stringList = readFileAndGetWordList();
//        List<String> stringList = Arrays.asList("ab ba bx ac ca cd da xy yz zo oc".split(" "));
        StringBuilder result = getLine(stringList.toArray(new String[0]));
        System.out.println(result.toString().trim());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();
        StringBuilder builder = new StringBuilder();
        List<Entry> graph = getDirectedGraph(words);
        List<Entry> entries = graph
                .stream()
                .filter(Entry::isOutEntriesExists)
                .map(NotMy6::getMaxLenEntryList)
                .max(Comparator.comparing(List::size))
                .orElse(Collections.emptyList());
        for (Entry entry : entries) {
            builder.append(entry.getLine()).append(" ");
        }
        return builder;
    }

    private static List<String> readFileAndGetWordList() throws Exception {
        List<String> res = new ArrayList<>();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();
        BufferedReader reader = new BufferedReader(fileReader);
        while (reader.ready()) {
            List<String> strings = Arrays.asList(reader.readLine().split(" "));
            res.addAll(strings);
        }
        reader.close();
        return res;
    }

    private static List<Entry> getMaxLenEntryList(Entry entry) {
        return getMaxLenEntryListRecursive(Arrays.asList(entry));
    }

    private static List<Entry> getMaxLenEntryListRecursive(List<Entry> entryList) {
        if (entryList == null) return null;
        if (entryList.isEmpty()) return entryList;

        Entry lastEntry = entryList.get(entryList.size() - 1);
        if (entryList.size() != 1) {
            if (lastEntry == entryList.get(0)) {
                return entryList.subList(0, entryList.size() - 1);
            } else if (entryList.subList(0, entryList.size() - 1).contains(lastEntry)) {
                return entryList.subList(0, entryList.size() - 1);
            }
        }

        List<Entry> result = lastEntry.outEntries
                .stream()
                .map(entry -> {
                    ArrayList<Entry> copy = new ArrayList<>(entryList);
                    copy.add(entry);
                    return getMaxLenEntryListRecursive(copy);
                })
                .max(Comparator.comparing(entries -> entries != null ? entries.size() : 0))
                .orElse(entryList);
        return result;
    }

    private static List<Entry> getDirectedGraph(String... words) {
        List<Entry> graph = new ArrayList<>();
        for (String word : words) {
            Entry entry = new Entry(word);
            graph.forEach(e -> {
                e.addEntry(entry);
                entry.addEntry(e);
            });
            graph.add(entry);
        }
        return graph;
    }

    public static class Entry {
        private List<Entry> outEntries;
        private List<Entry> inEntries;
        private String line;
        private char firstSymbol;
        private char lastSymbol;

        public List<Entry> getOutEntries() {
            return outEntries;
        }

        public String getLine() {
            return line;
        }

        public Entry(String line) {
            this.line = line;
            this.firstSymbol = line.toLowerCase().charAt(0);
            this.lastSymbol = line.toLowerCase().charAt(line.length() - 1);
            this.outEntries = new ArrayList<>();
            this.inEntries = new ArrayList<>();
        }

        public boolean addEntry(Entry entry) {
            boolean added = false;
            if (isBefore(entry)) {
                outEntries.add(entry);
                added = true;
            }
            if (isAfter(entry)) {
                inEntries.add(entry);
                added = true;
            }
            return added;
        }

        public boolean isBefore(Entry entry) {
            return entry.firstSymbol == this.lastSymbol;
        }

        public boolean isAfter(Entry entry) {
            return entry.lastSymbol == this.firstSymbol;
        }

        public boolean isOutEntriesExists() {
            return !outEntries.isEmpty();
        }

    }
}
