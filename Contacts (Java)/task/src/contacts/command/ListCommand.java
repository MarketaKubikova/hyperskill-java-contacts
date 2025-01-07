package contacts.command;

import contacts.contact.Contact;
import contacts.util.ContactUtils;

import java.util.List;

/**
 * Command to list all contacts.
 */
public class ListCommand implements Command {
    private final List<Contact> contacts;

    public ListCommand(List<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Executes the command to list all contacts.
     */
    @Override
    public void execute() {
        if (contacts.isEmpty()) {
            System.out.println("No records to list.");
        } else {
            ContactUtils.listContacts(contacts);
        }
    }
}
