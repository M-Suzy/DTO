package test;

import model.CustomerDto;
import model.Dto;
import validation.Validator;
import validation.util.PrintValidationErrors;

import java.time.LocalDate;

public class TestValidation {
    public static void main(String[] args) throws NoSuchFieldException {

        System.out.println("Valid Dto Test.........................\n");
        Dto dto = new CustomerDto("Bob", "bob98@gmail.com",
                LocalDate.of(1998, 9, 4), 70);
        PrintValidationErrors.logValidationErrors(new Validator().validate(dto));


        System.out.println("\nInvalid data test.....................\n");
        Dto dto2 = new CustomerDto("R", "r21gmail.com",
                LocalDate.of(2021, 9, 4), 101);
        PrintValidationErrors.logValidationErrors(new Validator().validate(dto2));
    }
}

