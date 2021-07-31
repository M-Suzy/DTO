package validation.util;

import validation.ValidationError;

import java.util.List;

/**
 * Helper class for printing Dto validation errors
 *
 * @author suzy
 */
public class PrintValidationErrors {
    public static void logValidationErrors(List<ValidationError> validationErrors){
        if(!validationErrors.isEmpty()){
            for(ValidationError error: validationErrors){
                System.out.println(error.getErrorMessage());
            }
        }
        else {
            System.out.println("No errors in DTO. Validation is successful.");
        }
    }
}
