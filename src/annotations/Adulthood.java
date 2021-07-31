package annotations;

/**
 * Indicates the allowed age, which is 18 and above
 *
 * @author suzy
 */
public @interface Adulthood {
    String message() default "Age should be at least 18!";
}
