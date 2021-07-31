package annotations;

import java.lang.annotation.*;

/**
 * Keeps minimum and maximum allowed length, and the error message for the violation case.
 *
 * @author suzy
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD})
public @interface Length {
    int min();
    int max();
    String message() default "Length is not valid!";
}
