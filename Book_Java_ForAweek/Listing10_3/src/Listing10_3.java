public class Listing10_3 {

    public static void main(String[] args) {
        // объ€вл€ем объектную переменную
        Thread thr;
        // присваиваем переменной ссылку 
        // на объект главного потока
        thr=Thread.currentThread();
        // выводим на печать информацию о потоке
        System.out.println(thr);
        // назначаем новое им€ потока
        thr.setName("√лавный поток");
        // назначаем новый приоритет потока
        thr.setPriority(8);
        // выводим обновленную информацию о потоке
        System.out.println(thr);
    } 
}
