package contacts.menu.manager;

import contacts.command.Command;
import contacts.command.EditCommand;
import contacts.command.ExitCommand;
import contacts.command.RemoveCommand;
import contacts.contact.Contact;
import contacts.menu.RecordMenu;

import java.util.List;

/**
 * Handles the record menu logic.
 */
public class RecordMenuManager extends AbstractMenuManager {
    private final List<Contact> contacts;

    public RecordMenuManager(List<Contact> contacts, Contact contact) {
        super(new RecordMenu(contacts, contact));
        this.contacts = contacts;
    }

    @Override
    protected MenuManager determineNextMenu(Command command) {
        if (command instanceof EditCommand) {
            return this;
        }else if (command instanceof RemoveCommand) {
            return new ListMenuManager(contacts); // Return to ListMenu or remove
        } else if (command instanceof ExitCommand) {
            return new MainMenuManager(contacts); // Back to MainMenu
        }
        return this;
    }
}
