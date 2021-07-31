package validation;

import annotations.*;
import model.Dto;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public List<ValidationError> validate(Dto dto) throws NoSuchFieldException {
        List<ValidationError> errors = new ArrayList<>();
        Field[] fields = dto.getClass().getDeclaredFields();
        //System.out.println(dto.getClass().getDeclaredField("name").getAnnotation(Length.class));
        for(Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if ((annotation instanceof Length) && (((Length) annotation).min() > dto.getName().length()
                        || dto.getName().length() > ((Length) annotation).max())) {
                    errors.add(new ValidationError(((Length) annotation).message()));
                }
                if ((annotation instanceof Adulthood) &&
                        (Period.between(dto.getBirthday(), LocalDate.now()).getYears() < 18)) {
                    errors.add(new ValidationError(((Adulthood) annotation).message()));
                }
                if (annotation instanceof Email) {
                    Pattern pattern = Pattern.compile(((Email) annotation).emailRegex());
                    Matcher matcher = pattern.matcher(dto.getEmail());
                    if (!matcher.matches()) {
                        errors.add(new ValidationError(((Email) annotation).message()));
                    }
                }
                if ((annotation instanceof Min) && (((Min) annotation).value() > dto.getDiscountRate())) {
                    errors.add(new ValidationError(((Min) annotation).message()));
                }
                if ((annotation instanceof Max) && (((Max) annotation).value() < dto.getDiscountRate())) {
                    errors.add(new ValidationError(((Max) annotation).message()));
                }
            }
        }
        return errors;
    }


}
