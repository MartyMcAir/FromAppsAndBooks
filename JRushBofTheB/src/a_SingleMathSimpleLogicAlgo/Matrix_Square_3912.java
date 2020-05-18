package a_SingleMathSimpleLogicAlgo;

/* 
Максимальная площадь
*/
// Реализуй метод int maxSquare(int[][] matrix), возвращающий площадь самого большого квадрата состоящего из единиц в двумерном массиве matrix.
//Массив matrix заполнен только нулями и единицами.
public class Matrix_Square_3912 {
    public static int[][] rectx = {
            {0, 0, 0, 0},
            {0, 1, 1, 1},
            {0, 1, 1, 1},
            {0, 1, 1, 1}

    };

    public static void main(String[] args) {
        System.out.print(maxSquare(rectx));
    }

    public static int maxSquare(int[][] matrix) {
        int max =0;
        int[][] peocessed = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j]==1){
                    peocessed[i+1][j+1] = Math.min(Math.min(peocessed[i][j],peocessed[i+1][j]),peocessed[i][j+1])+1;
                    max = Math.max(peocessed[i+1][j+1],max);
                }
            }
        }
        return max*max;
    }


    public static int maxSquareV1(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int[][] sizes = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row ==0 || col == 0) {
                    sizes[row][col] = matrix[row][col];
                    continue;
                }
                if (matrix[row][col] == 1) {
                    sizes[row][col] = Math.min(sizes[row - 1][col], Math.min(sizes[row][col - 1], sizes[row - 1][col - 1])) + 1;
                    if (sizes[row][col] > max) {
                        max = sizes[row][col];
                    }
                } else {
                    sizes[row][col] = 0;
                }
            }
        }
        return max * max;
    }

    public static int maxSquare2(int[][] matrix) {
//        int[][] matrixForCalc = new int[matrix.length+1][matrix[0].length];
        int maxSquare = 0;
//        for (int i = 0; i < matrixForCalc.length; i++) {
//            for (int j = 0; j < matrixForCalc[i].length; j++) {
//                if (i == 0 || j== 0) {
//                    matrixForCalc[i][j] = 0;
//                }else {
//                    matrixForCalc[i][j] = minValue(matrixForCalc[i-1][j], matrixForCalc[i-1][j-1], matrixForCalc[i][j-1])
//                            + matrix[i-1][j-1];
//                    if (maxSquare < matrixForCalc[i][j]) maxSquare = matrixForCalc[i][j];
//                }
//            }
//        }
//        return maxSquare;

        int[][]matrixForCalc = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    matrixForCalc[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        matrixForCalc[i][j] = matrix[i][j] + minValue(matrixForCalc[i][j-1], matrixForCalc[i-1][j], matrixForCalc[i-1][j-1]);
                    } else {
                        matrixForCalc[i][j] = 0;
                    }
                    if (maxSquare < matrixForCalc[i][j]) maxSquare = matrixForCalc[i][j];
                }

            }
        }
        return maxSquare * maxSquare;
    }

    private static int minValue(int a, int b, int c){
        int min = a < b ? a : b;
        return min < c ? min : c;
    }
}
