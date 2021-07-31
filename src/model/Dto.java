package model;

import java.time.LocalDate;

/**
 * Interface for Dto type.
 *
 * @author suzy
 */

public interface Dto {
    String getName();
    String getEmail();
    LocalDate getBirthday();
    int getDiscountRate();
}
