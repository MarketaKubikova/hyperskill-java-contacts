package contacts.menu;

import contacts.command.Command;
import contacts.command.ContinueCommand;
import contacts.command.ExitCommand;
import contacts.command.InfoCommand;
import contacts.contact.Contact;

import java.util.List;

/**
 * The {@code SearchMenu} class represents a menu for managing the search results of contacts.
 *
 * <p>This menu allows users to interact with search results, providing options to view detailed
 * information about a contact, repeat the search, or return to the previous menu.
 */
public class SearchMenu extends Menu {
    private final List<Contact> contacts;

    /**
     * Constructs a {@code SearchMenu} with the given search results.
     *
     * @param contacts the list of {@link Contact} objects resulting from a search
     */
    public SearchMenu(List<Contact> contacts) {
        super("search", "[number]", "back", "again");
        this.contacts = contacts;
    }


    /**
     * Retrieves the {@link Command} corresponding to the user input.
     *
     * <p>The valid commands are:
     * <ul>
     *     <li>{@code [number]}: Displays detailed information for the contact at the specified index.</li>
     *     <li>{@code back}: Returns to the previous menu.</li>
     *     <li>{@code again}: Repeats the search process.</li>
     * </ul>
     *
     * <p>If the input does not match any valid command, {@code null} is returned.
     *
     * @param input the user input representing an action
     * @return the corresponding {@code Command}, or {@code null} if the input is invalid
     */
    @Override
    public Command getCommand(String input) {
        if (input.matches("\\d+")) {
            return new InfoCommand(contacts, Integer.parseInt(input) - 1);
        } else if (input.equalsIgnoreCase("back")) {
            return new ExitCommand();
        } else if (input.equalsIgnoreCase("again")) {
            return new ContinueCommand();
        } else {
            return null;
        }
    }
}
