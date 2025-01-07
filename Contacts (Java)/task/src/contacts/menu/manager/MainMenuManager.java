package contacts.menu.manager;

import contacts.command.Command;
import contacts.command.ExitCommand;
import contacts.command.ListCommand;
import contacts.command.SearchCommand;
import contacts.contact.Contact;
import contacts.menu.MainMenu;

import java.util.List;

/**
 * Handles the main menu logic.
 */
public class MainMenuManager extends AbstractMenuManager {
    private final List<Contact> contacts;

    public MainMenuManager(List<Contact> contacts) {
        super(new MainMenu(contacts));
        this.contacts = contacts;
    }

    @Override
    protected MenuManager determineNextMenu(Command command) {
        if (command instanceof ListCommand) {
            return new ListMenuManager(contacts);
        } else if (command instanceof SearchCommand) {
            return new SearchMenuManager(contacts, ((SearchCommand) command).getSearchResults());
        } else if (command instanceof ExitCommand) {
            return null; // Exit the program
        }
        return this;
    }
}
