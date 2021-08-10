package validation.processors;

import annotations.Length;
import validation.ValidationError;

import java.lang.reflect.Field;

public class LengthAnnotationProcessor {
    public static <T> ValidationError getValidationError(T o, Field field, Length lengthAnnotation) throws IllegalAccessException {
        String name = (String) field.get(o);
        if (name.length() < lengthAnnotation.min() || name.length() > lengthAnnotation.max()) {
            return new ValidationError(lengthAnnotation.message());
        }
        return null;
    }
}

