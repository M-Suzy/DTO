package validation.processors;

import annotations.Email;
import validation.ValidationError;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAnnotationProcessor {
    public static <T> ValidationError getValidationError(T o, Field field, Email emailAnnotation) throws IllegalAccessException {
        Pattern pattern = Pattern.compile(emailAnnotation.emailRegex());
        Matcher matcher = pattern.matcher((CharSequence) field.get(o));
        if (!matcher.matches()) {
            return new ValidationError(emailAnnotation.message());
        }
        return null;
    }

}

