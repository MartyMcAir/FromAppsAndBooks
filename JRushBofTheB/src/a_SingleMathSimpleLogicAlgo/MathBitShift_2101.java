package a_SingleMathSimpleLogicAlgo;

/* 
Определяем адрес сети
*/
// https://javarush.ru/tasks/com.javarush.task.task21.task2101
// 1. Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - реализуй метод getNetAddress.
//Используйте операцию поразрядной конъюнкции (логическое И).
//
//Пример:
//IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
//Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
//Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)
//
//2. Реализовать метод print, который выведет в консоль данные в двоичном коде. Для IP-адреса(192.168.1.2)
//должна быть выведена строка "11000000 10101000 00000001 00000010"
//3. Метод main не участвует в тестировании
//
//Требования:
//•	Метод getNetAddress должен вычислять и возвращать адрес сети согласно переданным параметрам(IP-адрес и маска подсети).
//•	Метод getNetAddress должен быть статическим и публичным.
//•	Метод print должен быть статическим и публичным.
//•	Метод print должен преобразовывать переданный ему IP адрес в двоичный код и выводить на экран(как в условии).

// https://ru.stackoverflow.com/questions/657971/%D0%9A%D0%B0%D0%BA-%D0%BF%D1%80%D0%B5%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%B2%D0%B0%D1%82%D1%8C-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2-%D0%B1%D0%B0%D0%B9%D1%82%D0%BE%D0%B2-%D0%B2-%D0%B4%D0%B2%D0%BE%D0%B8%D1%87%D0%BD%D1%8B%D0%B9-%D0%BA%D0%BE%D0%B4
public class MathBitShift_2101 {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000


    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netA = new byte[ip.length];
        for (int i = 0; i < ip.length; i++) {
            netA[i] = (byte) (ip[i] & mask[i]);
        }

        return netA;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(String.format("%08d", Integer.valueOf("" + Integer.toBinaryString(bytes[i] & 0xFF))) + " ");

//            System.out.print(String.format("%8s", Integer.toBinaryString(bytes[i] < 0 ? bytes[i] + 256 : bytes[i])).
//                    replace(" ", "0") + " ");

//            System.out.print(String.format("%8s", Integer.toBinaryString(bytes[i] < 0 ? 256 + bytes[i] : bytes[i])).
//                    replace(' ', '0') + " ");
            System.out.print(Integer.toBinaryString((bytes[i] & 0xFF) + 256).substring(1) + " ");
        }
        System.out.println();
    }

//    public static void print(byte[] bytes) {
//        StringBuilder binA = new StringBuilder();
//        for (byte a : bytes) {
//            String bit = (Integer.toBinaryString(Byte.toUnsignedInt(a)));
//            if (bit.length() < 8) {
//                int count = 8 - bit.length();
//                for (int i = 0; i < count; i++) {
//                    binA.append("0");
//                }
//                binA.append(bit + " ");
//            } else binA.append(bit + " ");
//        }
//
//        System.out.println(binA.toString());
//    }
}
