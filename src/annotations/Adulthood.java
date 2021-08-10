package annotations;

import java.lang.annotation.*;

/**
 * Indicates the allowed age, which is 18 and above
 *
 * @author suzy
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Adulthood {
    String message() default "Age should be at least 18!";
}
