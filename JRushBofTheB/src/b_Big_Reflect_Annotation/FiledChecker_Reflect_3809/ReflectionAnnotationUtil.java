package b_Big_Reflect_Annotation.FiledChecker_Reflect_3809;

import java.lang.reflect.Field;

public final class ReflectionAnnotationUtil {
    public static void check(Object someObject) throws IllegalAccessException {
        Class<?> testedClass = someObject.getClass();
        for (Field field : testedClass.getDeclaredFields()) { // перебирает поля
                // почему-то пропускает этот блок, словно не находит искомое поле
            if (field.isAnnotationPresent(LongPositive.class)) { // в поиске аннотации LongPositive
                // если найдено то идёт обработка Банк аккаунта
                processLongPositiveAnnotationField(someObject, testedClass, field);
            }
        }
    }

    private static void processLongPositiveAnnotationField(Object someObject, Class<?> testedClass, Field field) throws
            IllegalAccessException {
        field.setAccessible(true); // делаем поле доступным
        Class<?> fieldType = field.getType();

        //assert type is long
        if (!fieldType.equals(long.class)) { // проверка поля на соответствие требуемому типу long _ т.е. если не long
            String msg = String.format("Поле %s в классе %s имеет аннотацию LongPositive, но его тип %s.",
                    field.getName(), testedClass.getSimpleName(), fieldType.getSimpleName());
            System.out.println(msg); // если if прошло просто форматируем строку из переданного класса и выводим
            return;
        }

        //assert value is positive
        // мы знаем, что someObject есть проверяемое long поле, так что делаем его каст
        long value = (long) field.get(someObject);
        if (value <= 0) { // проверка длины поля, если не соответствует требованиям то..
            String msg = String.format("Поле %s в классе %s имеет аннотацию LongPositive, но его значение не положительное.",
                    field.getName(), testedClass.getSimpleName());
            System.out.println(msg);
        }
    }
}
