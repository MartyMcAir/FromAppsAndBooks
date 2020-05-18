package b_Big_Reflect_Annotation.AnnotationI_InAnnotation_3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Author {
    //напиши свой код
    String value();

    Position position() default Position.OTHER;
}
