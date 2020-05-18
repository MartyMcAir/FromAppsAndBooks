package a_SingleMathSimpleLogicAlgo;

/*
Разложение на множители с помощью рекурсии
*/
// https://javarush.ru/tasks/com.javarush.task.task34.task3403#discussion
public class Factoriztion_3403 {
    public static void main(String[] args) {
        Factoriztion_3403 sol = new Factoriztion_3403();
//        sol.recursion(132);

        sol.recurse2(132);
    }

    public void recursion(int n) {
        int a = 2; // тут метод проверки деления на простые множители
        // (мжно из учебников по правилам делимости.. мол если на 0 вконце то делится на 2 если 5 то на 3.. и .т.д.)
        while (a <= n) { // если меньше или равно a
            if ((n % a) == 0) { // если процент от деления n на a = 0
                if (a != n) { // если a не равен  n = повтор рекурсии
                    System.out.print(a + " ");
                    recursion(n / a);
                } else {
                    System.out.print(a);
                }
                return;
            }
            a++;
        }
    }

    public void recursion3(int n) { // тот же принцип ток for
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                    n = n / i;
                    recursion(n);
                    return;
                }
            }
        }
    }

    public void recurse2(int n) {
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    System.out.print("" + i + " ");
                    recurse(n / i);
                    break;
                }
            }
        }
    }

    public void recurse(int n) {
        if (n > 1) {
            if (n % 2 == 0) {
                System.out.print("2 ");
                recurse(n / 2);
            } else if (n % 3 == 0) {
                System.out.print("3 ");
                recurse(n / 3);
            } else if (n % 5 == 0) {
                System.out.print("5 ");
                recurse(n / 5);
            } else {
                System.out.print(n);
            }
        }
    }
}
