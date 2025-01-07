package contacts.command;

import contacts.contact.Contact;

/**
 * Command to edit a contact.
 */
public class EditCommand implements Command {
    private final Contact contact;

    public EditCommand(Contact contact) {
        this.contact = contact;
    }

    /**
     * Executes the command to edit the contact.
     */
    @Override
    public void execute() {
        contact.edit();
        System.out.println("Saved");
    }
}
