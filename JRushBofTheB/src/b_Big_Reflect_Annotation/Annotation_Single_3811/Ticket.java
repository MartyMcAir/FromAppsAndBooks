package b_Big_Reflect_Annotation.Annotation_Single_3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Аннотация Ticket должна применяться только к новым типам данных.
@Retention(RetentionPolicy.RUNTIME) // Должна быть публичная и доступна во время выполнения программы.
public @interface Ticket {
    enum Priority {
        LOW, MEDIUM, HIGH
    }

    Priority priority() default Priority.MEDIUM;

    String createdBy() default "Amigo";

    // Аннотация Ticket должна содержать свойство tags - массив строк, пустой по умолчанию.
    // default {} - это пустой по умолчанию
    String[] tags() default {};

}
