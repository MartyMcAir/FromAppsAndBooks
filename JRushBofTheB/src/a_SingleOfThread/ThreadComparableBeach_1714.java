package a_SingleOfThread;

/* 
Comparable
*/
// https://javarush.ru/tasks/com.javarush.task.task17.task1714
//Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
//        Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число, которое показывает что первый пляж лучше (положительное число)
//        или второй пляж лучше (отрицательное число), и насколько он лучше.
//
//        Требования:
//        •	Класс Beach должен содержать три поля: String name, float distance, int quality.
//        •	Класс Beach должен реализовывать интерфейс Comparable<Beach>.
//        •	Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
//        •	Все методы класса Beach, кроме метода main, должны быть синхронизированы.
public class ThreadComparableBeach_1714 implements Comparable<ThreadComparableBeach_1714> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public ThreadComparableBeach_1714(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        ThreadComparableBeach_1714 bb1 = new ThreadComparableBeach_1714("one", 3, 10);
        ThreadComparableBeach_1714 bb2 = new ThreadComparableBeach_1714("one", 9, 9);
        System.out.println(bb1.compareTo(bb2));
        System.out.println(bb2.compareTo(bb1));
    }

    @Override
    public synchronized int compareTo(ThreadComparableBeach_1714 o) {
//        int result1 = (this.getDistance()> o.getDistance()) ? i++ : i--;
        int result = 0;
//        if (this.getDistance() > o.getDistance()) {
//            result++;
//        } else if (o.getDistance() > this.getDistance()) {
//            result--;
//        }
//        if (this.getQuality() > o.getQuality()) {
//            result++;
//        } else if (o.getQuality() > this.getQuality()) {
//            result--;
//        }

        // работает
//        float objNum1 = this.getDistance() + this.getQuality();
//        float objNum2 = o.getDistance() + o.getQuality();
//            result = (int) (objNum1-objNum2);

//        result = Float.compare(o.distance, this.distance);
//        if (result != 0) return result;
//        result = Integer.compare(o.quality, this.quality);
//        if (result != 0) return result;


//        int r = name.compareTo(o.name);
//        if (r > 0) {
//            result++;
//        } else if (r < 0) {
//            result--;
//        }


//        int result1 = this.quality > o.quality ? 1 : this.quality < o.quality ? -1 : 0;
//        int result2 = this.distance > o.distance ? 1 : this.distance < o.distance ? -1 : 0;
//        result = result1 > result1 ? 1 : result1 > result1 ? -1 : 0;

        int sum = 0;
        result = (int) ( o.distance - this.distance);
        sum += result;
        result = this.quality - o.quality;
        sum += result;

        return sum;
//        return result;
    }
}
