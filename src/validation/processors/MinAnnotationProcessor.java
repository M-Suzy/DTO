package validation.processors;

import annotations.Min;
import validation.ValidationError;

import java.lang.reflect.Field;

public class MinAnnotationProcessor {
    public static <T> ValidationError getValidationError(T o, Field field, Min minAnnotation) throws IllegalAccessException {
        if ((int) field.get(o) < minAnnotation.value()) {
            return new ValidationError(minAnnotation.message());
        }
        return null;
    }
}
