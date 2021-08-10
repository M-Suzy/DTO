package validation.processors;

import annotations.Max;
import validation.ValidationError;

import java.lang.reflect.Field;

public class MaxAnnotationProcessor {

    public static <T> ValidationError getValidationError(T o, Field field, Max maxAnnotation) throws IllegalAccessException {
        if ((int)field.get(o) > maxAnnotation.value()) {
            return new ValidationError(maxAnnotation.message());
        }
        return null;
    }
}
