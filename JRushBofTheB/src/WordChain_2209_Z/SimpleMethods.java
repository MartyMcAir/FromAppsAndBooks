package WordChain_2209_Z;

import java.util.ArrayList;

public class SimpleMethods {
    public static ArrayList<Word> listAllWords;
    public static ArrayList<Word> listFirstWords = new ArrayList<>();
    public static ArrayList<Word> listClone;

    // проблема кода неучет след слова в методе tryAddInsideList  и в tryAddInList
    // лучше просто перестановка пузырьком, а этот вариант кода слишком избыточен
    ///
    // НЕ выдает _ Правильной последовательности

    public void baseMethod(String... words) {
        arrToList(words); // массив слов в список

        // кол-во рекурсий равное кол-во элементов так что бы каждое слово
        // могло быть первым в начале цепочки
        int countInterat = listAllWords.size();
        loopForWords(countInterat); // перебираем список
    }

    public void loopForWords(int countInterat) {
        if (countInterat == 0) {
            return; // если 0 то прекращаем рекурсию
        }
        getArrList(listAllWords);
        ArrayList<Word> wordsNotAdded = new ArrayList<>(); // список не добавленных слов
        ArrayList<Word> listTmp = new ArrayList<>();

//        System.out.println("последовательность слов: ");
//        listClone.forEach(v -> System.out.print(v.getWord() + " "));
////////////////////////////////
        Word currentW, nextW;
        char leftChar, rightChar;
        for (int i = 0, j = i + 1; i < listClone.size() - 1; i++, j++) {
            currentW = listClone.get(i);
            nextW = listClone.get(j);
            // если посл букв текущ и перв букв след слов == _  т.е. при след интерации
            // предыдущ станет текущ и оно будет стыковаться в цепочке с пердыдущ
            if ((currentW.getCharLast() == nextW.getCharFirst())) {
                listTmp.add(currentW);
            } else { // иначе пытаемся вставить это слово в listTmp в начало или середину списка
                if (!tryAddInList(listTmp, currentW, i)) { // если слово не удалось добавить
                    wordsNotAdded.add(currentW); // кидаем в список не добавленных
                }
            }

            if (j == listClone.size() - 1) { // если последн интерация
                wordsNotAdded.add(nextW);
                lastLoopIs(listTmp, wordsNotAdded);
            }
        }

        // получаем строку из списка и добавляем в наш список
        String ready = listToString(listTmp);
        Tmp4.listCombinations.add(ready);
        ///////////////////////////////////////////////
//        System.out.println("\nresult is: " + ready + "\n");
        // рекурсия
//        loopForWords(--countInterat);
    }

    private void lastLoopIs(ArrayList<Word> listTmp, ArrayList<Word> wordsNotAdded) {
        Word currentW, nextW;
        String letterFL;
        // пытаемся добавить в список между слов
        Word currentNotAdd;
        for (int k = 0; k < wordsNotAdded.size(); k++) {
            currentNotAdd = wordsNotAdded.get(k);
            for (int i = 0, j = i + 1; i < listTmp.size() - 1; i++, j++) {
                currentW = listTmp.get(0);
                nextW = listTmp.get(j);
                letterFL = String.valueOf(currentW.getCharLast()) + String.valueOf(nextW.getCharFirst());
                if (currentNotAdd.getLetterFL().equals(letterFL)) {
                    listTmp.add(j, currentNotAdd);
                    wordsNotAdded.remove(currentNotAdd);
                    break; // переходим к след слову
                }
            }
        }
        // если список не добавленных слов не стал пуст _
        // пытаемся добавить их в начало или конец списка
        if (!wordsNotAdded.isEmpty()) {
            // а что если таких слов будет множество!?
            for (int i = 0; i < wordsNotAdded.size(); i++) {
                currentW = wordsNotAdded.get(i);
                // пробуем добавить в начало списка
                if (currentW.getCharLast() == listTmp.get(0).getCharFirst()) {
                    listTmp.add(0, currentW);
                }
                // пробуем добавить в конец списка
                if (currentW.getCharFirst() == listTmp.get(listTmp.size() - 1).getCharLast()) {
                    listTmp.add(currentW);
                }
            }
        }
    }


    public String listToString(ArrayList<Word> list) {
        StringBuilder res = new StringBuilder();
        for (Word item : list) {
            res.append(item.getWord() + " ");
        }
        return res.toString().substring(0, res.lastIndexOf(" ")); // обрезаем пробел в конце
    }

    public void getArrList(ArrayList<Word> listAllWords) {
        listClone = new ArrayList<>(listAllWords);
        Word firstWord = getFirstWord(listClone); // получаем перв слово которого ранее не было
//        Collections.shuffle(listClone); // перетасовываем список для большей вероятности
        Word tmp = listClone.get(0);
        if (!tmp.getWord().equals(firstWord.getWord())) {
            listClone.remove(firstWord); // удаляем для избежания дубликатов
            listClone.set(0, firstWord); // заменяем текущее слово первым
            listClone.add(tmp); // добавляем замененное слово в конец списка
        }

    }

    public boolean tryAddInList(ArrayList<Word> listTmp, Word checked, int inter) {
        boolean res = true;
        if (listTmp.size() == 0) { // если это первое слово в списке
            // и пытаемся подобрать след слово _ c 1 т.к. 0левой это и есть само слово
            Word currentW;
            for (int i = 1; i < listClone.size(); i++) {
                currentW = listClone.get(i);
                // пытаемся вставить справа от первого слова
                if (checked.getCharLast() == currentW.getCharFirst() // доп проверка на случай
                        & !(checked.getWord().equals(currentW.getWord()))) { // если слова одинак
                    listTmp.add(checked);  // удалось подобрать след слово знач add его
                    listClone.remove(currentW); // для избежания дубликатов и лишней интерации
                    listClone.add(inter + 1, currentW); // будет словом след итерации
                    return true;
                }
                // пытаемся вставить слева от первого слова
                if (currentW.getCharLast() == checked.getCharFirst()
                        & !(checked.getWord().equals(currentW.getWord()))) {
                    // первый словом стало current w
                    listTmp.add(currentW); // удалось подобрать предыдущ слово знач add его
                    listClone.remove(checked); // и порядок вставки другой!
                    listClone.add(inter + 1, checked); // будет словом след итерации
                    return true;
                }
            }
            return false; // если слово НЕ удалось подобрать
            // такое слово пойдет в список недобавляемых
        }
        if (!tryAddInsideList(listTmp, checked)) { // если в середину списка не получилось
            /////////// Тут надо след интерацию перестановку след слова

            // пытаемся вставить в начало списка
            if (listTmp.get(0).getCharFirst() == checked.getCharLast()) {
                listTmp.add(0, checked);
                // пытаемся вставить в конец списка
            } else if (listTmp.get(listTmp.size() - 1).getCharLast() == checked.getCharFirst()) {
                listTmp.add(checked);
            } else { // иначе false
                res = false;
            }
        }
        return res;
    }

    // вставить в середину списка
    public boolean tryAddInsideList(ArrayList<Word> listTmp, Word checked) {
        /////////// Тут надо след интерацию перестановку след слова
        boolean res = false;
        Word currentW, nextW;
        for (int i = 0, j = i + 1; i < listTmp.size() - 1; i++, j++) {
            currentW = listTmp.get(i);
            nextW = listTmp.get(j);
            if (currentW.getCharLast() == checked.getCharFirst() &
                    nextW.getCharFirst() == checked.getCharLast()) {
                listTmp.add(j, checked);
                res = true;
                break;
            }
        }
        return res;
    }

    public Word getFirstWord(ArrayList<Word> listClone) {
        // ставим первы слово которого ране не было первым
        Word firstWord = listClone.get(0); // на случай если уже все слова были первыми
        for (Word item : listClone) {
            if (!listFirstWords.contains(item)) { // если нет в списке ранее использовавшихся слов то
                listFirstWords.add(firstWord); // добавляем в список что слово уже было первым
                firstWord = item;
                break;
            }
        }
        return firstWord;
    }

    public void arrToList(String... words) {  // массив слов в список
        ArrayList<String> list = new ArrayList<>();
        for (String item : words) {
            list.add(item);
        }
//        Collections.sort(list);
//        Collections.shuffle(list); // от 5 до 9

        listAllWords = new ArrayList<>();
//        for (String item : words) {
        for (String item : list) {
            listAllWords.add(new Word(item));
        }
//        Collections.sort(listAllWords); // Comparable надо имплементить
    }

    public static String[] getPath() {  // путь к файлу
        String folder = "c:\\z_n\\new_test_folder\\zero\\";
        return new String[]{folder + "data_.txt",
                folder + "data5_.txt",
                folder + "data10.txt",
                folder + "data3.txt",
                folder + "example.txt",
        };
    }
}
