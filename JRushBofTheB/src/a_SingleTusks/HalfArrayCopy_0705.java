package a_SingleTusks;

import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/
// https://javarush.ru/tasks/com.javarush.task.task07.task0705
//1. Создать массив на 20 чисел.
//        2. Ввести в него значения с клавиатуры.
//        3. Создать два массива на 10 чисел каждый.
//        4. Скопировать большой массив в два маленьких: половину чисел в первый маленький,
//        вторую половину во второй маленький.
//        5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
//
//        Требования:
//        •	Программа должна создавать большой массив на 20 целых чисел.
//        •	Программа должна считывать с клавиатуры 20 чисел для большого массива.
//        •	Программа должна создавать два маленьких массива на 10 чисел каждый.
//        •	Программа должна скопировать одну половину большого массива в первый маленький,
//        а вторую - во второй и вывести второй маленький массив на экран.
public class HalfArrayCopy_0705 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int[] arrIntBig = new int[20];
        int[] arrInt1 = new int[10], arrInt2 = new int[10];

        for (int i = 0; i < 20; i++) {
            arrIntBig[i] = sc.nextInt();
        }

        int tmp;
        for (int i = 0, j=0; i < 20; i++) {
            tmp = arrIntBig[i];
            if (i <10) {
                arrInt1[i]= tmp;
            } else if(i>=10){
                arrInt2[j]=tmp;
                j++;
            }
        }

        for(int i=0; i<10; i++){
            System.out.println(arrInt2[i]);
        }
    }
}
