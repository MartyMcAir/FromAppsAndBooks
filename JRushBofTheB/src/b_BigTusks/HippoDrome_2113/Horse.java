package b_BigTusks.HippoDrome_2113;

public class Horse {
    public String name;
    public double speed, distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        double x = Math.random() * 2;
        distance = speed * x;
    }

    public void print() {
//        str = "."
//        str += str.repeat( (int) distance);

//        str+= String.join("", Collections.nCopies((int) distance,str));

//        char[] chars = new char[(int) distance];
//        Arrays.fill(chars, '.');
//        System.out.println(new String(chars) + getName());

        String dotts = "";
//        for (int i = 0; i < ((int) Math.rint(distance)); i++) {
        for (int i = 0; i < (int) distance; i++) {
            dotts += ".";
        }
        System.out.println(dotts + name);
    }
}
