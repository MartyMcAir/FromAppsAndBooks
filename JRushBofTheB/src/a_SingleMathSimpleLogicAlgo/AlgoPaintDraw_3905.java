package a_SingleMathSimpleLogicAlgo;

/* 
Залей меня полностью
В процессе разработки новой версии популярного графического редактора возникла необходимость реализовать
 заливку области картинки определенным цветом.
Реализуй метод paintFill в классе PhotoPaint таким образом, чтобы он возвращал:
- false, если цвет начальной точки (координаты приходят в качестве параметров) совпадает с цветом заливки или
если начальные координаты выходят за рамки массива.
- модифицировал входящий массив и возвращал true, если заливка все же может быть выполнена.

Точке с координатами (x, y) соответствует элемент массив с индексом [y][x].
P.S. Если алгоритм работы заливки не очевиден, можешь попрактиковаться в графическом редакторе Paint.
*/
// https://javarush.ru/tasks/com.javarush.task.task39.task3905#discussion
// https://habr.com/ru/post/116374/ - Алгоритмы заливки изображений, популярно и с видео
public class AlgoPaintDraw_3905 {
    public static void main(String[] args) {

    }

    public enum Color {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        INDIGO,
        VIOLET
    }

    public class PhotoPaint {
        public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
            int height = image.length;
            int width = image[0].length;

            if (x < 0 || y < 0 || x >= width || y >= height || image[y][x].equals(desiredColor)) {
                return false;
            }

            Color oldColor = image[y][x];

            image[y][x] = desiredColor;

            if (y > 0 && image[y - 1][x] == oldColor) {
                paintFill(image, x, y - 1, desiredColor);
            }

            if ((y < image.length - 1) && image[y + 1][x] == oldColor) {
                paintFill(image, x, y + 1, desiredColor);
            }

            if (x > 0 && image[y][x - 1] == oldColor) {
                paintFill(image, x - 1, y, desiredColor);
            }

            if ((x < image[0].length - 1) && image[y][x + 1] == oldColor) {
                paintFill(image, x + 1, y, desiredColor);
            }

            return true;
        }
    }
}
