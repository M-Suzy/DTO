package model;

import annotations.*;

import java.time.LocalDate;

/**
 * CustomerDto is a specification of Dto interface.
 *
 * @author suzy
 */
public class CustomerDto {
    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthday;

    @Min(0)
    @Max(100)
    private int discountRate;

    public CustomerDto(String name, String email, LocalDate birthday, int discountRate) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.discountRate = discountRate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

}

