package contacts.command;

import contacts.contact.Contact;

import java.util.List;

/**
 * Command to count the number of contacts.
 */
public class CountCommand implements Command {
    private final List<Contact> contacts;

    public CountCommand(List<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Executes the command to count and display the number of contacts.
     */
    @Override
    public void execute() {
        System.out.printf("The Phone Book has %d records.%n", contacts.size());
    }
}
