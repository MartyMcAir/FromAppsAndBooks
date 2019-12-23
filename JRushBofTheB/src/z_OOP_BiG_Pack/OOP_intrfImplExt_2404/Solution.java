package z_OOP_BiG_Pack.OOP_intrfImplExt_2404;

/*
Рефакторинг Rectangle
*/
// https://javarush.ru/tasks/com.javarush.task.task24.task2404#discussion
public class Solution {
    // решил но что делает не понял
    // comment чей - то
    // Получается, при вызове getHeight() из мейна вызывается getHeight() из анонимного класса,
    // созданного в классе Rectangle? Иначе не понятно как это работает, учитывая,
    // что этих в самом классе уже нет, но они спокойно вызываются.
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
//        System.out.println(getHeight(rectangle));
//        System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));
        System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }


    public static class Rectangle {
        //    public static class Rectangle implements HasHeight, HasWidth {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        // вычислять высоту, как разницу между y координатами.
        public HasHeight castToHasHeight() {
            //        public double getHeight() {
            HasHeight hasHeight = new HasHeight() {
                @Override
                public double getHeight() {
                    return Math.abs(point1.getY() - point2.getY());
                }
            };
            return hasHeight;
//            return Math.abs(point1.getY() - point2.getY());
        }

        // вычислять ширину, как разницу между x координатами.
        public HasWidth castToHasWidth() {
            //        public double getWidth() {
            HasWidth hasWidth = new HasWidth() {
                @Override
                public double getWidth() {
                    return Math.abs(point1.getX() - point2.getX());
                }
            };
            return hasWidth;
//            return Math.abs(point1.getX() - point2.getX());
        }
    }
}
