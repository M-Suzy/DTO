package annotations;

/**
 * Indicates the allowed minimum value.
 *
 * @author suzy
 */
public @interface Min {
    int value();
    String message() default "Too short!";
}
