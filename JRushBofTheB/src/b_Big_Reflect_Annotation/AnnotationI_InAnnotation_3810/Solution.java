package b_Big_Reflect_Annotation.AnnotationI_InAnnotation_3810;

/* 
Реализуй аннотации
*/

@Changelog({
        @Revision(
                revision = 4089,
                date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
                comment = "Новый файл добавлен"),
        @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Серега", position = Position.MIDDLE)},
                comment = "Фикс багов"),
        @Revision( // ругается что нет поля comment
                revision = 10135,
                date = @Date(year = 2014, month = 12, day = 31, hour = 23, minute = 59, second = 59),
                authors = {@Author(value = "Диана", position = Position.OTHER),
                        @Author("Игорь"),
                        @Author(value = "Витек", position = Position.SENIOR)})
})
// https://javarush.ru/tasks/com.javarush.task.task38.task3810#discussion
// ошибся ток в 2х полях from git _ не знал такой особенности _ остальное дошло из статей
public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.class.getAnnotation(Changelog.class).toString());
    }
}
