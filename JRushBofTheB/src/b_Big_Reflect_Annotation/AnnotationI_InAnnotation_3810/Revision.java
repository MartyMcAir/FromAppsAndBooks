package com.javarush.task.task38.task3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Revision {
    //напиши свой код _ порядок полей не важен
    int revision(); // содержит поле тип int

    //    Date[] date() default {}; // тож работает, но это не то
    // а date = @Date(
    Date date(); // содержит аннотацию как эмулирование структуры данных Date

    // содержит аннотацию (т.е. внутри аннотации Revision аннотация Author)
//    Author authors();   // неверный вариант т.к. authors = {@Author(..
    Author[] authors() default {};   // без default - не работает

//    String comment();   // my _ ругается на осутствие поля comment третий блок @Revision в классе Solution
    String comment() default "";  // from git _ не ругается..

}
