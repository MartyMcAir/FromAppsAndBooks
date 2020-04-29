package b_BigTusks.WordChain_2209_Z;


// при использовании Comparable так же идеал результа при более чем 5 слов нет
public class Word implements Comparable<Word> {
    private char charFirst;
    private char charLast;
    private String word;
    private String letterFL; // перв и последн буква

    public Word(String word) {
        this.word = word;
        this.charFirst = this.word.toLowerCase().charAt(0);
        this.charLast = this.word.toLowerCase().charAt(this.word.length() - 1);
        this.letterFL = String.valueOf(this.charFirst) + String.valueOf(this.charLast);
    }

    public char getCharFirst() {
        return charFirst;
    }

    public char getCharLast() {
        return charLast;
    }

    public String getWord() {
        return word;
    }

    public String getLetterFL() {
        return letterFL;
    }

    @Override
    public int hashCode() {
        int res = 31 * (Character.hashCode(this.charFirst) + Character.hashCode(this.charLast));
        res = 31 * (res + this.word.hashCode());
        res = 31 * (res + this.letterFL.hashCode());
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        // проверка на null
        if (obj == null) {
            return false;
        }
        // если объект не является объектом нужного класса
        if (!(obj instanceof Word) || obj.getClass() != this.getClass()) {
            return false;
        }
        // если бъекты равны
        if (this == obj) {
            return true;
        }
        // проверки c приведением к типу
        Word other = (Word) obj;
        if (!this.word.equals(other.word))
            return false;
        if (this.charFirst != other.charFirst)
            return false;
        if (this.charLast != other.charLast)
            return false;
        if (this.letterFL != other.letterFL)
            return false;
        return true;
    }


    @Override
    public int compareTo(Word o) {
        if (this.getCharLast() == o.getCharFirst()) {
            return -1;
        }
        if (this.getCharLast() != o.getCharFirst()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return word;
    }
}
