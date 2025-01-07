package contacts.menu;

import contacts.command.Command;
import contacts.command.ExitCommand;
import contacts.command.InfoCommand;
import contacts.contact.Contact;

import java.util.List;

/**
 * The {@code ListMenu} class provides a menu interface for listing contacts and performing actions on them.
 *
 * <p>This menu allows users to view detailed information about a specific contact or exit the menu.
 * It is a specialized implementation of the {@link Menu} class.
 */
public class ListMenu extends Menu {
    private final List<Contact> contacts;

    public ListMenu(List<Contact> contacts) {
        super("list", "[number]", "back");
        this.contacts = contacts;
    }

    /**
     * Retrieves the {@link Command} corresponding to the user input.
     *
     * <p>The valid commands are:
     * <ul>
     *     <li>{@code [number]}: Displays detailed information for the contact at the specified index.</li>
     *     <li>{@code back}: Returns to the previous menu.</li>
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
        } else {
            return null;
        }
    }
}
