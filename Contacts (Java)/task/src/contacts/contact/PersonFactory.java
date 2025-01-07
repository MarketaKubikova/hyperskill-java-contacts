package contacts.contact;

import contacts.util.InputUtils;
import contacts.validation.ContactValidator;

import java.util.Scanner;

/**
 * The {@code PersonFactory} class is responsible for creating {@link Person} contact instances.
 *
 * <p>It implements the {@link ContactFactory} interface, providing a concrete implementation of the
 * {@code createContact} method. This class prompts the user for personal details and validates
 * input fields such as birthdate, gender, and phone number.
 */
public class PersonFactory implements ContactFactory {
    /**
     * Creates a new {@link Person} contact by prompting the user for details.
     *
     * <p>The method validates user inputs for birthdate, gender, and phone number using the
     * {@link ContactValidator} utility. If any input is invalid, the respective field is set
     * to a default value ("[no data]" or "[no number]").
     *
     * @return a newly created {@code Person} instance populated with the provided and validated details.
     */
    @Override
    public Contact createContact() {
        System.out.println("Enter the name:");
        String name = InputUtils.getInput();

        System.out.println("Enter the surname:");
        String surname = InputUtils.getInput();

        System.out.println("Enter the birth date:");
        String birthDate = "[no data]";
        String birthDateInput = InputUtils.getInput();
        if (ContactValidator.isValidBirthDate(birthDateInput)) {
            birthDate = birthDateInput;
        }

        System.out.println("Enter the gender:");
        String gender = "[no data]";
        String genderInput = InputUtils.getInput();
        if (ContactValidator.isValidGender(genderInput)) {
            gender = genderInput;
        }

        System.out.println("Enter the phone number:");
        String phoneNumber = "[no number]";
        String phoneNumberInput = InputUtils.getInput();
        if (ContactValidator.isValidPhoneNumber(phoneNumberInput)) {
            phoneNumber = phoneNumberInput;
        }

        System.out.println("The record added.");

        return new Person(name, surname, phoneNumber, birthDate, gender);
    }
}
