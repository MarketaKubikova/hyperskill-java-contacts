package contacts.contact;

import contacts.util.InputUtils;
import contacts.validation.ContactValidator;

/**
 * The {@code OrganizationFactory} class implements the {@link ContactFactory} interface
 * to create instances of {@link Organization}.
 *
 * <p>This factory prompts the user to enter the organization's details, validates the phone number,
 * and constructs an {@code Organization} object with the provided information.
 */
public class OrganizationFactory implements ContactFactory {
    /**
     * Creates a new {@link Organization} instance by prompting the user for input.
     *
     * <p>The user is asked to provide the organization's name, address, and phone number.
     * If the phone number is invalid, it defaults to "[no number]". After creation, a confirmation message is displayed.
     *
     * @return a new {@code Organization} object with the entered details.
     */
    @Override
    public Contact createContact() {
        System.out.println("Enter the organization name:");
        String organizationName = InputUtils.getInput();

        System.out.println("Enter the address:");
        String address = InputUtils.getInput();

        System.out.println("Enter the number:");
        String phoneNumber = "[no number]";
        String phoneNumberInput = InputUtils.getInput();
        if (ContactValidator.isValidPhoneNumber(phoneNumberInput)) {
            phoneNumber = phoneNumberInput;
        }

        System.out.println("The record added.");

        return new Organization(organizationName, address, phoneNumber);
    }
}
