package a_SingleMathSimpleLogicAlgo;

/* 
Лестница
*/
// https://tproger.ru/problems/stairs/
// Вам нужно подняться по лестнице. За один раз можно подняться на одну или две ступеньки.
// Сколько существует способов добраться до N-й ступеньки?

// https://tproger.ru/problems/stairs/
public class Fibonanchi3_3904 {
    private static int n = 70;
    static long temp = 0; // added

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n == 0 | n == 1) return 1;
        if (n < 0) return 0;
        if (n == 2) return 2;
        if (n == 3) return 4;

//        long n1 = 1;
//        long n2 = 2;
//        long n3 = 4;
//
//        for (int i = 4; i <= n; i++) {
//            temp = n1 + n2 + n3;
//            n1 = n2;
//            n2 = n3;
//            n3 = temp;
//        }
//        return temp; // 2073693258389777176

        // OR
//        return numberOfPossibleAscents(n-1) * 2 - numberOfPossibleAscents(n-4);

        // OR
        long[] runups = new long[n + 3];
        runups[0] = 1L;
        runups[1] = 1L;
        runups[2] = 2L;
        for (int i = 3; i <= n; i++) {
            runups[i] = runups[i - 1] + runups[i - 2] + runups[i - 3];
        }
        return runups[n];
    }

    // Ребенок бежит по лестнице состоящей из N ступенек, за 1 шаг он может пройти одну, две или три ступеньки.
    //Реализуй метод numberOfPossibleAscents(int n), который вернет количество способов которыми ребенок может
    // пробежать всю лестницу состоящую из n ступенек.
    //
    //P.S. Если лестница состоит из 0 ступенек - метод должен возвращать 1. Для n < 0 верни 0.
    //
    //Требования:
    //1. Метод numberOfPossibleAscents должен возвращать количество способов прохождения лестницы из n ступенек.
    //2. Метод numberOfPossibleAscents должен возвращать 1 для n = 0.
    //3. Метод numberOfPossibleAscents должен возвращать 0 для n < 0.
    //4. Время выполнения метода numberOfPossibleAscents должно быть линейным.

    // from comment
    // Решается аналогично через числа фибоначчи, но прибавлять нужно не последние 2 предыдущих числа,
    // а последние 3 предыдущих. Первая попытка ушла на то что не принял самый лёгкий вариант с рекурсией.
    // Потом долго тупил на ровном месте как адаптировать решение с использованием цикла с учётом 3 ступенек за шаг.
}

