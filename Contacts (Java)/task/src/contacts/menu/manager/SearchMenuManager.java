package contacts.menu.manager;

import contacts.command.Command;
import contacts.command.ContinueCommand;
import contacts.command.ExitCommand;
import contacts.command.InfoCommand;
import contacts.contact.Contact;
import contacts.menu.SearchMenu;

import java.util.List;

/**
 * Handles the search menu logic.
 */
public class SearchMenuManager extends AbstractMenuManager {
    private final List<Contact> contacts;
    private List<Contact> searchResults;

    public SearchMenuManager(List<Contact> contacts, List<Contact> searchResults) {
        super(new SearchMenu(contacts));
        this.contacts = contacts;
        this.searchResults = searchResults;
    }

    @Override
    protected MenuManager determineNextMenu(Command command) {
        if (command instanceof InfoCommand infoCommand) {
            Contact selectedContact = searchResults.get(infoCommand.getContactIndex());
            return new RecordMenuManager(contacts, selectedContact);
        } else if (command instanceof ContinueCommand) {
            searchResults = null; // Reset search results and redo the search
            return this;
        } else if (command instanceof ExitCommand) {
            return new MainMenuManager(contacts); // Back to MainMenu
        }
        return this;
    }
}
