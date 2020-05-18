package a_SingleMathSimpleLogicAlgo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
Сколько у человека потенциальных друзей?
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3611#discussion
public class CocialNewFriendMarix_3611 {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        CocialNewFriendMarix_3611 solution = new CocialNewFriendMarix_3611();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }


    // from https://github.com/msamichev/javarush/blob/c1b53a589cf8c509fd7f6beab5fe5ff2e049d3e9/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task36/task3611/Solution.java
    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        Set<Integer> result = new HashSet<>();
        //напишите тут ваш код
        if (deep == 0) return result;
        for (int i = 0; i < humanRelationships.length; i++) {
            if (i < index) {
                if (humanRelationships[index][i]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            } else {
                if (humanRelationships[i][index]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            }
        }
        result.remove(index);
        return result;
    }

    public Set<Integer> getAllFriendsAndPotentialFriends_V2(int index, int deep) {
        Set<Integer> result = new TreeSet<>();
        //напишите тут ваш код    // не дошло = копипаст
        Set<Integer> set = new HashSet<>();

        while (deep > 0) {
            for (int i = 0; i < humanRelationships.length; i++) {
                if (i < index && humanRelationships[index][i])
                    set.add(i);
                else if (i > index && humanRelationships[i][index])
                    set.add(i);
            }
            if (!set.isEmpty()) {
                if (set.contains(index))
                    set.remove(index);
                result.addAll(set);

                deep -= 1;
                for (int i : result)
                    set.addAll(getAllFriendsAndPotentialFriends_V2(i, deep));
            } else break;
        }

        return result;
    }

    // https://javarush.ru/images/comment/f6a74fb9-8967-482d-b099-c59dcde848d7/original.jpeg
    // достраивать ничего не нужно, можно понять и так
    //как только разбираемся как работает метод удаления друзей, используем его код для рекурсивного метода добавления
    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }

    // from comment
    // Для тех кто не понял где в таблице искать людей. В таблице всего представлено 8 человек (0-7).
    // Весь список повторяется по вертикале и по горизонтали. Значение это отношения между людьми.
    //Т.Е. humanRelationships [3][3] описывает отношение человека с индексом 3 к самому себе (та самая диагональ).
    // humanRelationships [6][4] Описывает отношение человека с индексом 6 к человеку с индексом 4 - То есть, являются ли они друзьями.
    //
    //Вроде бы просто а сразу и не понял.

    //   Самое сложное это было понять что от тебя требуеться в задании, но в этом очень помог комментарий
    //   Сергея от 28.09.2018. Суть в том что index - это humanRelationships[index],
    //   то есть внутренний массив двумерного массива. Самое не понятное это как понять кто этому человеку друг.
    //   Тут всё тоже как бы просто: люди с index < проверяемыйЧеловек.index вычисляються по значениям true в диапазоне значений
    //humanRelationships[index][0] - humanRelationships[index][length - 2]
    //// в данном случае length - 2 потому что length - 1 это и есть наш человек,
    //// по этому всегда true так как каждый человек сам себе друг)))
    //а люди с index > проверяемыйЧеловек.index вычисляються по значениям true в диапазоне значений
    //humanRelationships[index + 1][index] - humanRelationships[length - 1][index]

    // Алгоритм вкратце таков:
    //1. Создаём трисет куда будем класть индексы друзей, друзей друзей и т.д.
    //2. Создаем двустороннюю очередь, кладём туда индекс из аргументов метода
    //3.Создаём  цикл for с 0 по deep
    //4. В нём создаём локальную переменную dequeSize размера очереди, т.к. размер будет меняться динамически
    //5.  Создаём внутри цикл while пока dequeSize>0
    //6. Внутри вытаскиваем первый элемент из очереди, это по сути индекс того для кого в данный момент ищем друзей, dequeSize--
    //7.  Двумя циклами ищем всех друзей для индекса который достали из очереди.
    // В первом проходим по подмассиву с 0 по length -1 и если ячейка true и не равна индексу из
    // аргументов метода кладём i в treeset и добавляем его в очередь. Во втором цикле проходимся
    // по оставшимся массивам с индекса который достали на 6 шаге до конца(кроме того, который указан
    // в аргументе метода) и ищем, содержат ли они в ячейке с индексом из 6 шага true и , если да,
    // то также добавляем в treeSet и очередь.
    //
    //Кратко не получилось, надеюсь кому - то поможет)
}