package b_Big_Reflect_Annotation.AnnotationI_InAnnotation_3810;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Changelog {
    //напиши свой код
//    Revision[] revision() default {}; // my _ тогда поле comment и остальные в SolutionV2 Обязательные..
    // и последний блок @Revision - в классе SolutionV2 ругается на отсутствующее поле comment
    Revision[] value(); // from git

}
