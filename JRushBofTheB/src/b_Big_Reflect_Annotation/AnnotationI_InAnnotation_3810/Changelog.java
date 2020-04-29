package com.javarush.task.task38.task3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Changelog {
    //напиши свой код
//    Revision[] revision() default {}; // my _ тогда поле comment и остальные в Solution Обязательные..
    // и последний блок @Revision - в классе Solution ругается на отсутствующее поле comment
    Revision[] value(); // from git

}
