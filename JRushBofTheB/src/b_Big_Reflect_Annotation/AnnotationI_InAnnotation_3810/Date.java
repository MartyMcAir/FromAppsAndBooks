package b_Big_Reflect_Annotation.AnnotationI_InAnnotation_3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Date {
    //напиши свой код ___  эмулировать записи/структуры   Date   на аннотациях
    int year();

    int month();

    int day();

    int hour();

    int minute();

    int second();

}
