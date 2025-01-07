package contacts.search;

import contacts.contact.Contact;

import java.util.List;

/**
 * The {@code SimpleSearchStrategy} class provides a straightforward implementation of the {@link SearchStrategy}
 * interface to search for contacts that match a given query.
 *
 * <p>This strategy filters the list of contacts by leveraging the {@code matches} method of each {@link Contact}
 * object to determine whether it satisfies the search criteria.
 */
public class SimpleSearchStrategy implements SearchStrategy {
    /**
     * Searches the given list of contacts for matches based on the specified query.
     *
     * <p>This implementation uses Java Streams to filter the contacts by checking each contact's
     * {@code matches} method with the query. The results are collected into a new list.
     *
     * @param contacts the list of {@link Contact} objects to search
     * @param query    the search query string used to filter contacts
     * @return a list of contacts that match the query
     */
    @Override
    public List<Contact> search(List<Contact> contacts, String query) {
        return contacts.stream()
                .filter(contact -> contact.matches(query))
                .toList();
    }
}
