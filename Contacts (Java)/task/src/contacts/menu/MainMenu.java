package contacts.menu;

import contacts.command.*;
import contacts.contact.Contact;
import contacts.search.SimpleSearchStrategy;

import java.util.List;

/**
 * The {@code MainMenu} class provides the main menu interface for the Contacts application.
 *
 * <p>This menu allows users to perform various operations on a list of contacts, such as adding a new contact,
 * viewing the list of contacts, searching, counting contacts, or exiting the application.
 * It is a concrete implementation of the {@link Menu} class.
 */
public class MainMenu extends Menu {
    private final List<Contact> contacts;

    /**
     * Constructs a new {@code MainMenu} with the provided list of contacts.
     *
     * @param contacts the list of {@link Contact} objects to manage
     */
    public MainMenu(List<Contact> contacts) {
        super("menu", "add", "list", "search", "count", "exit");
        this.contacts = contacts;
    }

    /**
     * Retrieves the {@link Command} corresponding to the user input.
     *
     * <p>The valid commands are:
     * <ul>
     *     <li>{@code add}: Adds a new contact to the list.</li>
     *     <li>{@code list}: Displays the list of contacts and provides additional actions for each.</li>
     *     <li>{@code search}: Searches contacts using a simple search strategy.</li>
     *     <li>{@code count}: Displays the number of contacts in the list.</li>
     *     <li>{@code exit}: Exits the application.</li>
     * </ul>
     *
     * <p>If the input does not match any valid command, {@code null} is returned.
     *
     * @param input the user input representing an action
     * @return the corresponding {@code Command}, or {@code null} if the input is invalid
     */
    @Override
    public Command getCommand(String input) {
        return switch (input.toLowerCase()) {
            case "add" -> new AddCommand(contacts);
            case "list" -> new ListCommand(contacts);
            case "search" -> new SearchCommand(contacts, new SimpleSearchStrategy());
            case "count" -> new CountCommand(contacts);
            case "exit" -> new ExitCommand();
            default -> null;
        };
    }
}
