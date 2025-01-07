package contacts.command;

import contacts.contact.Contact;
import contacts.search.SearchStrategy;
import contacts.util.ContactUtils;
import contacts.util.InputUtils;

import java.util.List;

/**
 * Command to perform a search on the contacts.
 */
public class SearchCommand implements Command {
    private final List<Contact> contacts;
    private final SearchStrategy searchStrategy;
    private List<Contact> searchResults;

    public SearchCommand(List<Contact> contacts, SearchStrategy searchStrategy) {
        this.contacts = contacts;
        this.searchStrategy = searchStrategy;
    }

    /**
     * Executes the command to search contacts and list results.
     */
    @Override
    public void execute() {
        System.out.println("Enter search query:");
        String query = InputUtils.getLowerCasedInput();
        searchResults = searchStrategy.search(contacts, query);

        if (searchResults.isEmpty()) {
            System.out.println("No results found.");
        } else {
            ContactUtils.listContacts(searchResults);
        }

        System.out.println();
    }

    public List<Contact> getSearchResults() {
        return searchResults;
    }
}
