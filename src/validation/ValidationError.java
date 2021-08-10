package validation;

/**
 * Used for keeping error messages after dto validation
 *
 * @author suzy
 */
public record ValidationError(String errorMessage) {

    public String getErrorMessage() {
        return errorMessage;
    }

}
