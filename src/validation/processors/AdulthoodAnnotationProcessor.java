package validation.processors;

import annotations.Adulthood;
import validation.ValidationError;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class AdulthoodAnnotationProcessor {
    private static final int ADULTHOOD_AGE = 18;

    public static <T> ValidationError getValidationError(T o, Field field, Adulthood annotation) throws IllegalAccessException {
        ValidationError error = null;
        int years = Period.between((LocalDate) field.get(o), LocalDate.now()).getYears();
        if (years < ADULTHOOD_AGE) {
            error = new ValidationError(annotation.message());
        }
        return error;
    }
}
