package annotations;

import java.lang.annotation.*;

/**
 * Indicates the allowed maximum value.
 *
 * @author suzy
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD})
public @interface Max {
    int value();
    String message() default "Exceeds the maximum limit!";
}
