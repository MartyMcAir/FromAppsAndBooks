package b_BigTusks.RetrievesInArray_2026_Z;

// https://javarush.ru/dialogues/75128 by https://javarush.ru/users/2109837
public class NotMy4 {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 5");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                    zeroedRecursive(a, i, j);
                }
            }
        }
        return count;
    }

    public static void zeroedRecursive(byte[][] b, int i, int j) {
        if (b[i][j] == 1) {
            b[i][j] = 0;
            if (b.length - 1 > i)
                zeroedRecursive(b, i + 1, j);
            if (b[0].length - 1 > j)
                zeroedRecursive(b, i, j + 1);
        }
    }
}
