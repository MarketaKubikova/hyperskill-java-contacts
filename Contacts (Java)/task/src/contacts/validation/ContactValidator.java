package contacts.validation;

import java.util.regex.Pattern;

/**
 * Utility class for validating contact-related inputs such as phone number, birth date, and gender.
 */
public class ContactValidator {
    private ContactValidator() {
    }

    /**
     * Validates the format of a phone number.
     *
     * @param phoneNumber the phone number to validate
     * @return {@code true} if the phone number is valid, {@code false} otherwise
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(
                "^\\+?" +                                                                             // optional "+" sign
                        "([0-9a-z]|" +                                                                      // only one character number
                        "([0-9a-z][-\\s])?(\\([0-9a-z]{2,}\\))([-\\s][0-9a-z]{2,})*|" +                     // when number has () in first group
                        "([0-9a-z][-\\s])?([0-9a-z]{2,})([-\\s][0-9a-z]{2,})*|" +                           // when number has NO ()
                        "([0-9a-z][-\\s])?([0-9a-z]{2,})([-\\s]\\([0-9a-z]{2,}\\))([-\\s][0-9a-z]{2,})*)$", // only second group with ()
                Pattern.CASE_INSENSITIVE);

        if (pattern.matcher(phoneNumber).matches()) {
            return true;
        } else {
            System.out.println("Wrong number format!");
            return false;
        }
    }

    /**
     * Validates the format of a birthdate. Birthdate cannot be null or empty
     *
     * @param birthDate the birthdate to validate
     * @return {@code true} if the birthdate is valid, {@code false} otherwise
     */
    public static boolean isValidBirthDate(String birthDate) {
        if (birthDate != null && !birthDate.isEmpty()) {
            return true;
        } else {
            System.out.println("Bad birth date!");
            return false;
        }
    }

    /**
     * Validates the input for gender
     *
     * @param gender the gender to validate
     * @return {@code true} if the gender is valid, {@code false} otherwise
     */
    public static boolean isValidGender(String gender) {
        if (gender != null && !gender.isEmpty()) {
            return true;
        } else {
            System.out.println("Bad gender!");
            return false;
        }
    }
}
