package a_SingleMathSimpleLogicAlgo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LogicTraficLighyMy_0416 {
    public static void main(String[] args) throws Exception {
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int tmp = sc.nextInt();

        Map<Integer, String> arrMap = getGrYellRedMap(3, 1, 1);
        // System.out.println(arrMap.size()); // 36
        String res = "";
        String color = "";
        int time = 0;
        if (tmp > 0 && tmp < 61) { // если ввели в диопазоне одного часа
            for (int item : arrMap.keySet()) {
                time = item;
                color = arrMap.get(item);
                if (tmp == time || ((tmp - 3) == time)
                        || ((tmp - 2) == time)
                        || ((tmp + 1) == time) || ((tmp + 2) == time)
                ) {
                    res = color;
                }
            }

        } else {
            res = "неверное значение _ 0-60"; // need run block again _ callBack функция реккурсия
        }
        System.out.println(res);
    }

    public static Map<Integer, String> getGrYellRedMap(int a, int b, int c) {
        // green 3 m _ yellow 1m _ red 1m - and repeat again
        int time = 0;
        String color = "";
        boolean one = true, two = false, three = false;
        Map<Integer, String> arrMap = new HashMap<Integer, String>();
        for (int i = 0; i < getCountComb(60, (a + b + c), 3); i++) {
            if (one) {  // a= 3 b=1 c =1
                time += a;
                color = "зелёный";
                one = false;
                two = true;
                //continue;
            } else if (two) {
                time += b;
                color = "жёлтый";
                two = false;
                three = true;
            } else if (three) {
                time += c;
                color = "красный";
                three = false;
                one = true;
            }
            arrMap.put(time, color);
        }
        System.out.println(arrMap.toString());
        return arrMap;
    }

    public static int getCountComb(int inMinutes, int numberLoop, int countComb) {
        int j = 0, res = 0;
        while (j < inMinutes) { // вычисляем кол-во комбинаций которые поместятся в часе _ 36
            j += numberLoop; // 3 + 1 + 1;
            res += countComb;
        }
        // System.out.println("j: "+j+" кол-во комбинаций интераций переключений в часе countComb "+countComb);
        return res;
    }

    public static int abs(int a) {
        if (a < 0) {
            a = -a;
        } else {
            a = a;
        }
        return a;
    }
}