package validation;

public record ValidationError(String errorMessage) {

    public String getErrorMessage() {
        return errorMessage;
    }
}
