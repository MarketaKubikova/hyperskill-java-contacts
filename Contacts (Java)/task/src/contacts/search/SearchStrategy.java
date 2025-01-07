package contacts.search;

import contacts.contact.Contact;

import java.util.List;

/**
 * The {@code SearchStrategy} interface defines the contract for implementing different search strategies
 * for filtering a list of contacts based on a query.
 *
 * <p>Classes implementing this interface must provide an implementation for the {@code search} method,
 * which performs the search operation on a given list of contacts and returns the results that match
 * the specified query.
 */
public interface SearchStrategy {
    /**
     * Searches the given list of contacts for matches based on the specified query.
     *
     * <p>The specific matching logic depends on the implementation of this interface.
     *
     * @param contacts the list of {@link Contact} objects to search
     * @param query    the search query string used to filter contacts
     * @return a list of contacts that match the query
     */
    List<Contact> search(List<Contact> contacts, String query);
}
