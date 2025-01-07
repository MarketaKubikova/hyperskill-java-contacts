package contacts.command;

import contacts.contact.Contact;

import java.util.List;

/**
 * Command to display information about a specific contact.
 */
public class InfoCommand implements Command {
    private final List<Contact> contacts;
    private final int contactIndex;

    public InfoCommand(List<Contact> contacts, int contactIndex) {
        this.contacts = contacts;
        this.contactIndex = contactIndex;
    }

    /**
     * Executes the command to display the contact information.
     */
    @Override
    public void execute() {
        if (contactIndex >= 0 && contactIndex < contacts.size()) {
            System.out.println(contacts.get(contactIndex).toString());
        } else {
            System.out.println("Invalid record number.");
        }
    }

    public int getContactIndex() {
        return contactIndex;
    }
}
