package validation;

import annotations.*;
import validation.processors.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for DTO fields validation
 *
 * @author suzy
 */
public class Validator {
    /**
     * Validates Dto fields and returns a list with violation messages.
     *
     * @param dto
     * @return a list of validation errors
     * @author suzy
     */
    public static <T> List<ValidationError> validate(T dto) throws IllegalAccessException {
        List<ValidationError> validationErrors = new ArrayList<>();
        Field[] fields = dto.getClass().getDeclaredFields();
        ValidationError error;
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            field.setAccessible(true);
            for (Annotation annotation : annotations) {
                if (annotation instanceof Length) {
                    error = LengthAnnotationProcessor.getValidationError(dto, field, (Length) annotation);
                    if (error != null) {
                        validationErrors.add(error);
                    }
                }
                if (annotation instanceof Adulthood) {
                    error = AdulthoodAnnotationProcessor.getValidationError(dto, field, (Adulthood) annotation);
                    if (error != null) {
                        validationErrors.add(error);
                    }
                }
                if (annotation instanceof Email) {
                    error = EmailAnnotationProcessor.getValidationError(dto, field, (Email) annotation);
                    if (error != null) {
                        validationErrors.add(error);
                    }
                }
                if (annotation instanceof Min) {
                    error = MinAnnotationProcessor.getValidationError(dto, field, (Min) annotation);
                    if (error != null) {
                        validationErrors.add(error);
                    }
                }
                if (annotation instanceof Max) {
                    error = MaxAnnotationProcessor.getValidationError(dto, field, (Max) annotation);
                    if (error != null) {
                        validationErrors.add(error);
                    }
                }
            }
        }
        return validationErrors;
    }


}
