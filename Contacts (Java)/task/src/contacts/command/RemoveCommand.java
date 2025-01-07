package contacts.command;

import contacts.contact.Contact;

import java.util.List;

/**
 * Command to remove a contact.
 */
public class RemoveCommand implements Command {
    private final List<Contact> contacts;
    private final Contact contact;

    public RemoveCommand(List<Contact> contacts, Contact contact) {
        this.contacts = contacts;
        this.contact = contact;
    }

    /**
     * Executes the command to remove the specified contact.
     *
     * <p>The contact is removed from the provided list, and a confirmation message is printed to the console.
     */
    @Override
    public void execute() {
        contacts.remove(contact);
        System.out.println("The record removed!");
    }
}
