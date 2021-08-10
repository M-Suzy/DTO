package test;
import model.CustomerDto;
import validation.Validator;
import validation.util.PrintValidationErrors;

import java.time.LocalDate;

public class TestValidation {
    public static void main(String[] args) throws IllegalAccessException {

        //Invalid name
        System.out.println("\nInvalid name test.....................\n");
        CustomerDto dto2 = new CustomerDto("R", "r21@gmail.com",
                LocalDate.of(1998, 9, 4), 100);
        PrintValidationErrors.logValidationErrors(new Validator().validate(dto2));

        //Invalid age
        System.out.println("\nInvalid age test.....................\n");
        CustomerDto dto3 = new CustomerDto("Raa", "r21@gmail.com",
                LocalDate.of(2008, 9, 4), 100);
        PrintValidationErrors.logValidationErrors(new Validator().validate(dto3));

        //Invalid email
        System.out.println("\nInvalid email test.....................\n");
        CustomerDto dto4 = new CustomerDto("Raa", "r21gmail.com",
                LocalDate.of(2000, 9, 4), 100);
        PrintValidationErrors.logValidationErrors(new Validator().validate(dto4));

        //All valid
        System.out.println("Valid Dto Test.........................\n");
        CustomerDto dto = new CustomerDto("Bob", "bob98@gmail.com",
                LocalDate.of(1998, 9, 4), 70);
        PrintValidationErrors.logValidationErrors(new Validator().validate(dto));
    }
}

