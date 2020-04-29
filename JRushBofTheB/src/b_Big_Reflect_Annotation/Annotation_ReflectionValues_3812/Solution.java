package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

public class Solution {
    public static void main(String[] args) throws NoSuchMethodException {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) throws NoSuchMethodException {
        // My
//        AnnotatedType annotatedReceiverType = c.getConstructor().getAnnotatedReceiverType();
//        Annotation[] annotationsArr = c.getAnnotations();
//        for (Annotation item : annotationsArr) {
//            if (item.getClass().getSimpleName().equals("PrepareMyTest"))
//                System.out.println("fullyQualifiedNames");
//        }
        if (c == null) return false; // забыл про NPE

        // From Articles
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
//            System.out.println("fullyQualifiedNames"); // в условии: необходимо вывести на экран fullyQualifiedNames

            // а в реале: должен выводить на экран все элементы массива fullyQualifiedName
            // сходу не дошло
            // до каста не догадался _ для получения  fullyQualifiedName из аннотации
//            Annotation annotation = c.getAnnotation(PrepareMyTest.class);
            PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            String[] strings = annotation.fullyQualifiedNames();
            for (String item : strings)
                System.out.println(item);

//            Method[] methods = c.getMethods(); // так можно перебирать аннотации всех методов
//            for (Method item : methods) {
//                Annotation[] annotations = item.getAnnotations();
//            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c == null) return false;

        if (c.isAnnotationPresent(PrepareMyTest.class)) {
//            Class<? extends Annotation> aClass = annotation.annotationType();
//            System.out.println(c.getSimpleName());

            // должен выводить на экран все элементы массива value используя их сокращенное имя
            PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class<?>[] values = annotation.value();
            for (Class<?> item : values)
                System.out.println(item.getSimpleName());
            return true;
        }
        return false;
    }
}
