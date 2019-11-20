public class Listing5_2 {

    public static void main(String[] args) {
        // Объявление двумерного массива 10x15
        int[][] coord = new int[10][15];
        // Перебор элементов внешнего массива
        for(int i=0;i<coord.length;i++){
            // Перебор элементов вложенного массива
            for(int j=0;j<coord[0].length;j++){
                // Пример выражения для генерации значений
                coord[i][j]=(i+j)*j; 
            }
        }
        // Вывод сформированных значений на печать
        for(int[] tmp1:coord){
            for(int tmp2:tmp1){
                System.out.print(tmp2+"\t");
            }
            System.out.print("\n");
        }
    }  
}
