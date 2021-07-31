package annotations;

/**
 * Indicates the allowed maximum value.
 *
 * @author suzy
 */
public @interface Max {
    int value();
    String message() default "Exceeds the maximum limit!";
}
