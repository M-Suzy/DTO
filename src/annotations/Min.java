package annotations;

import java.lang.annotation.*;

/**
 * Indicates the allowed minimum value.
 *
 * @author suzy
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD})
public @interface Min {
    int value();
    String message() default "Too short!";
}
