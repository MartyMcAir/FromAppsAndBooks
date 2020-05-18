package b_Big_Reflect_Annotation.FiledChecker_Reflect_3809;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME) // необходимо было указать время исполнения аннотации в RunTime
public @interface LongPositive {
}
