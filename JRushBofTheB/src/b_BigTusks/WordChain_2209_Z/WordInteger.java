package b_BigTusks.WordChain_2209_Z;

import java.util.Objects;

public class WordInteger implements Comparable<WordInteger> {
    private String word;
    private Integer num;

    public WordInteger(String word, Integer num) {
        this.word = word;
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof WordInteger)) return false;
//        WordInteger that = (WordInteger) o;
//        return word.equals(that.word) &&
//                getNum().equals(that.getNum());
//    }

    @Override
    public int hashCode() {
        return Objects.hash(word, getNum());
    }

    @Override
    public int compareTo(WordInteger o) {
        if (this.num > o.num) {
            return 1;
        }
        if (this.num < o.num) {
            return -1;
        }
        if (this.num == o.num) { // если значения равны
            return this.word.compareTo(o.word); // сравниваем их по строке
        }
        return 0;
    }

    @Override
    public String toString() {
        return word;
    }
}
