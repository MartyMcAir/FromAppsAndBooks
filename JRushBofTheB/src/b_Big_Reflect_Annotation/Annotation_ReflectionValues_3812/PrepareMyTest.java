package com.javarush.task.task38.task3812;

// https://mvnrepository.com/artifact/org.powermock/powermock-core/2.0.6
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// https://www.codeflow.site/ru/article/intro-to-powermock - объяснения анноотации
@PrepareForTest
public @interface PrepareMyTest {
    Class<?>[] value() default Solution.class;

    String[] fullyQualifiedNames() default "";
}