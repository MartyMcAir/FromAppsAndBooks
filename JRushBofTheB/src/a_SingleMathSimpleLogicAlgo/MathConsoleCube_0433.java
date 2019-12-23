package a_SingleMathSimpleLogicAlgo;


/* 
Гадание на долларовый счет
*/
// https://javarush.ru/tasks/com.javarush.task.task04.task0433
// Вывести на экран квадрат из 10х10 букв S используя цикл while.
//Буквы в каждой строке не разделять.
//
//Пример вывода на экран:
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//SSSSSSSSSS
//
//Требования:
//•	Программа не должна считывать текст c клавиатуры.
//•	Программа должна выводить текст на экран.
//•	Программа должна выводить квадрат из 10х10 букв S.
//•	В программе должен использоваться цикл while.
public class MathConsoleCube_0433 {
    public static void main(String[] args) throws Exception {
        int i=0, j=0;
        while(i<10){
            while(j<10){
                System.out.print("S");
                j++;
            }
            System.out.println();
            j=0;
            i++;
        }
    }
}
