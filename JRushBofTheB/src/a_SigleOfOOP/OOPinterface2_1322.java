package a_SigleOfOOP;

/* 
Интерфейс SimpleObject
*/
// https://javarush.ru/tasks/com.javarush.task.task13.task1322
//1. Создай класс StringObject.
//        2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
//        3. Программа должна компилироваться.
//
//        Требования:
//        •	Класс StringObject должен реализовывать интерфейс SimpleObject.
//        •	Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
//        •	В классе StringObject реализовать метод getInstance интерфейса SimpleObject.
//        •	Класс StringObject должен существовать в классе Solution_3105.
//        •	Класс StringObject должен быть статическим.
public class OOPinterface2_1322 {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    // Code
    public static class StringObject<Object> implements SimpleObject<String>{
        @Override
        public StringObject<String> getInstance() {
            return (StringObject<String>) this;
        }
    }
}
