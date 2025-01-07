package contacts.command;

import contacts.contact.Contact;
import contacts.contact.ContactFactory;
import contacts.contact.OrganizationFactory;
import contacts.contact.PersonFactory;
import contacts.util.InputUtils;

import java.util.List;

/**
 * Command to add a new contact.
 */
public class AddCommand implements Command {
    private final List<Contact> contacts;

    public AddCommand(List<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Executes the command to add a new contact. The user is prompted to specify the type of contact
     * ("person" or "organization"), and the corresponding factory is used to create the contact.
     *
     * <p>If the user enters an invalid type, an error message is displayed and no contact is created.
     */
    @Override
    public void execute() {
        System.out.println("Enter the type (person, organization):");
        String type = InputUtils.getLowerCasedInput();

        ContactFactory factory;
        switch (type) {
            case "person" -> factory = new PersonFactory();
            case "organization" -> factory = new OrganizationFactory();
            default -> {
                System.out.println("Invalid contact type.");
                factory = null;
            }
        }

        if (factory != null) {
            contacts.add(factory.createContact());
        }
    }
}
