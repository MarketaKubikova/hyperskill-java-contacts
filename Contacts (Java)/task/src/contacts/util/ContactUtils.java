package contacts.util;

import contacts.contact.Contact;

import java.util.List;

/**
 * The {@code ContactUtils} class provides utility methods for operations related to {@link Contact} objects.
 *
 * <p>This class contains static methods to facilitate common tasks such as displaying a list of contacts.
 * It is designed to be a utility class and, as such, cannot be instantiated.
 */
public final class ContactUtils {
    private ContactUtils() {
    }

    /**
     * Prints a numbered list of contacts to the console.
     *
     * <p>This method iterates through the given list of contacts, generates a numbered representation of
     * each contact using its {@code getListName} method, and prints it to the console.
     *
     * @param contacts the list of {@link Contact} objects to be displayed
     */
    public static void listContacts(List<Contact> contacts) {
        contacts.stream()
                .map(contact -> (contacts.indexOf(contact) + 1) + ". " + contact.getListName())
                .forEach(System.out::println);
    }
}
