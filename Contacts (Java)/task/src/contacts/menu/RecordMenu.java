package contacts.menu;

import contacts.command.Command;
import contacts.command.EditCommand;
import contacts.command.ExitCommand;
import contacts.command.RemoveCommand;
import contacts.contact.Contact;

import java.util.List;

/**
 * The {@code RecordMenu} class represents a menu for managing a specific contact record.
 *
 * <p>This menu provides options to edit a contact, delete a contact, or return to the main menu.
 * It is a concrete implementation of the {@link Menu} class.
 */
public class RecordMenu extends Menu {
    private final List<Contact> contacts;
    private final Contact contact;

    /**
     * Constructs a new {@code RecordMenu} for a specific contact.
     *
     * @param contacts the list of {@link Contact} objects
     * @param contact  the specific {@link Contact} this menu is managing
     */
    public RecordMenu(List<Contact> contacts, Contact contact) {
        super("record", "edit", "delete", "menu");
        this.contact = contact;
        this.contacts = contacts;
    }

    /**
     * Retrieves the {@link Command} corresponding to the user input.
     *
     * <p>The valid commands are:
     * <ul>
     *     <li>{@code edit}: Edits the details of the contact.</li>
     *     <li>{@code delete}: Removes the contact from the list.</li>
     *     <li>{@code menu}: Returns to the main menu.</li>
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
            case "edit" -> new EditCommand(contact);
            case "delete" -> new RemoveCommand(contacts, contact);
            case "menu" -> new ExitCommand();
            default -> null;
        };
    }
}
