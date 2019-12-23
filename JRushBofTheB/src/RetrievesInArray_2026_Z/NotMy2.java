package RetrievesInArray_2026_Z;

public class NotMy2 {
    // взято от сюда https://gist.github.com/Anatolf/4a7b41c113d8a4cec3a346591a557bf7
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
        System.out.println();
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        System.out.println();
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 5");
        System.out.println();

    }

    public static int getRectangleCount(byte[][] a) {

        byte[][] matrix = a;
        int countRect = 0;


        // проверяем наличие прямоугольников вне последней строчки и правого столбца:
        System.out.println("Так выглядит вся матрица которую нам передали:");
        for (int i = 0; i<matrix.length; i++){          //идём по строкам
            for (int j = 0; j < matrix.length; j++){         //идём по столбцам
                System.out.print(" " + matrix[i][j] + " ");        //вывод каждого элемента матрицы (с пробелами для красоты)

                if (matrix[i][j] == 1 ){                                   // если в ячейке (1)
                    if (i < matrix.length-1 && j < matrix.length-1) {        // и это не последняя строчка и не последний столбец (их пока не учитываем)
                        if (matrix[i][j + 1] == 0 && matrix[i + 1][j] == 0 && matrix[i + 1][j+1] == 0 ) {   // если снизу, справа и подиогонали соседи = (0)
                            countRect++;           // это я прибавляю в каунт прямоугольники, у которых правый нижний угол с трёх сторон окружён нулями
                        }
                    }

                }
            }
            System.out.println();   //перенос строки ради визуального сохранения табличной формы
        }


        // проверяем нижнюю строку матрицы на наличие прямоугольников:
        System.out.println("Так выглядит самая нижняя строка");
        for (int j = 0; j<matrix.length; j++) {                           // бежим по самой нижней строке
            System.out.print(" " + matrix[matrix.length - 1][j] + " ");

            if (matrix[matrix.length - 1][j] == 1 && j < matrix.length - 1) {  // если в ячейке (1) и это не последняя ячейка
                if (matrix[matrix.length - 1][j + 1] == 0) {                 // смотрим есть ли в следующей (0)
                    countRect++;                                         // если есть то +прямоугольник
                }
            }
        }
        System.out.println();


        // проверяем правый столбец матрицы на наличие прямоугольников:
        System.out.println("Так выглядит самый правый столбец:");
        for (int i = 0; i<matrix.length; i++){                                // бежим по правому столбцу
            System.out.println(" " + matrix[i][matrix.length-1] + " ");

            if (matrix[i][matrix.length-1] == 1 && i< matrix.length-1){  // если в ячейке (1) и это не последняя ячейка
                if (matrix[i+1][matrix.length-1] == 0 ){                 // смотрим есть ли в следующей (0)
                    countRect++;                                         // если есть то +прямоугольник
                }
            }
        }

        // проверяем самую нижнюю правую ячейку в углу матрицы:
        if (matrix[matrix.length-1][matrix.length-1] == 1) countRect++;    // если в правом нижнем углу (1) то +прямоугольник



        System.out.println();
        System.out.println("countRect = " + countRect);
        System.out.println("____________________________________________" );
        return countRect;
    }
}
