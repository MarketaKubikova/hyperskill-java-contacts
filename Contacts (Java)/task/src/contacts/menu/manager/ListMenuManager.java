package contacts.menu.manager;

import contacts.command.Command;
import contacts.command.ExitCommand;
import contacts.command.InfoCommand;
import contacts.contact.Contact;
import contacts.menu.ListMenu;

import java.util.List;

/**
 * Handles the list menu logic.
 */
public class ListMenuManager extends AbstractMenuManager {
    private final List<Contact> contacts;

    public ListMenuManager(List<Contact> contacts) {
        super(new ListMenu(contacts));
        this.contacts = contacts;
    }

    @Override
    protected MenuManager determineNextMenu(Command command) {
        if (command instanceof InfoCommand infoCommand) {
            return new RecordMenuManager(contacts, contacts.get(infoCommand.getContactIndex()));
        } else if (command instanceof ExitCommand) {
            return new MainMenuManager(contacts); // Back to MainMenu
        }
        return this;
    }
}
