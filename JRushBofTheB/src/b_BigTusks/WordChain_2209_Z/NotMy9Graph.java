package b_BigTusks.WordChain_2209_Z;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// https://javarush.ru/help/30942
public class NotMy9Graph {
    public static void main(String[] args) throws IOException {
//...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
//        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream ("d:\\1.txt")));
        StringBuilder builder = new StringBuilder("");
        while (reader1.ready()) {
            builder.append(" ").append(reader1.readLine());
        }

        reader1.close();
        String[] cityNames = builder.toString().trim().split(" ");
        StringBuilder result = getLine(cityNames);
        System.out.println(builder.toString().trim());
        System.out.println(result.toString().trim());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder("");
        if (words == null || words.length == 0) return result;
        ArrayList<String> copyOfWords = new ArrayList<>(Arrays.asList(words));
        ArrayList<ArrayList<Integer>> bigList = words2graph(copyOfWords);

        int firstVertex = startVertex(bigList);

        Deque<Integer> deq = new LinkedList<>();

        ArrayList<Integer> resultArray = new ArrayList<>();
        deq.addLast(bigList.get(firstVertex).get(0));

        while (!deq.isEmpty()) {
            int x = deq.getLast();
            int index = getIndex(x, bigList);
            if (index == -1) {
                resultArray.add(deq.removeLast());
                continue;
            }

            if (bigList.get(index).size() > 1) {
                deq.addLast(bigList.get(index).get(1));
                bigList.get(index).remove(1);

            } else {
                resultArray.add(deq.removeLast());
            }
        }
        ArrayList<String> resultList = graph2words(resultArray, words);
        if (resultList.size() == words.length) {
            for (String buffer : resultList
            ) {
                result.append(buffer).append(" ");
            }
            return result;
        } else System.out.println("Link length is " + resultList.size());


        return result;
    }

    public static Integer[] getVertices(String word) {
        return new Integer[]{(int) word.toLowerCase().charAt(0), (int) word.toLowerCase().charAt(word.length() - 1)};
    }

    public static ArrayList<ArrayList<Integer>> words2graph(ArrayList<String> words) {
        ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
        for (String word : words) {
            ArrayList<Integer> buffer = new ArrayList<>(Arrays.asList(getVertices(word)));
            boolean match = false;
            if (!bigList.isEmpty()) {
                for (ArrayList<Integer> vertices : bigList
                ) {
                    if (vertices.get(0).equals(buffer.get(0))) {
                        vertices.add(buffer.get(1));
                        match = true;
                        break;
                    }
                }
                if (!match)
                    bigList.add(buffer);
            } else {
                bigList.add(buffer);
            }
        }

        return bigList;
    }

    public static int getIndex(int x, ArrayList<ArrayList<Integer>> bigList) {
        for (int i = 0; i < bigList.size(); i++) {
            if (bigList.get(i).get(0) == x) {
                return i;
            }
        }
        return -1;
    }

    public static int startVertex(ArrayList<ArrayList<Integer>> bigList) {
        int firstVertex = 0;
        int counter = 0;
        for (int i = 0; i < bigList.size(); i++) {
            int currentChar = bigList.get(i).get(0);
            int degPlus = 0;
            int degMinus = 0;
            for (int t = 1; t < bigList.get(i).size(); t++) {
                if (bigList.get(i).get(t) != currentChar) degPlus++;
                else {
                    degPlus++;
                    degMinus++;
                }
            }

            for (ArrayList<Integer> line : bigList) {
                if (line.get(0) != currentChar) {
                    for (int k : line
                    ) {
                        if (k == currentChar) degMinus++;
                    }
                }
            }
            if ((degPlus - degMinus) != 0) {

                if ((degPlus - degMinus) == 1) {
                    firstVertex = i;
                    counter++;
                } else if ((degPlus - degMinus) % 2 != 0) {
                    counter++;
                }
            }
        }
        if (counter == 2 || counter == 0) {
            return firstVertex;
        }


        return -1;
    }

    public static ArrayList<String> graph2words(ArrayList<Integer> resultList, String... words) {
        ArrayList<String> realResult = new ArrayList<>();
        ArrayList<String> wordsArrayList = new ArrayList<>(Arrays.asList(words));

        for (int i = resultList.size() - 1; i > 0; i--) {
            int[] word = new int[2];
            word[1] = resultList.get(i - 1);
            word[0] = resultList.get(i);
            for (int j = 0; j < wordsArrayList.size(); j++) {
                String singleWord = wordsArrayList.get(j);
                if ((singleWord.toLowerCase().charAt(0) == word[0]) && (singleWord.toLowerCase().charAt(singleWord.length() - 1) == word[1])) {
                    realResult.add(singleWord);
                    wordsArrayList.remove(j);
                    break;
                }
            }

        }

        return realResult;


    }

}