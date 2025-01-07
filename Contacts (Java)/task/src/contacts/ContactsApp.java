package contacts;

import contacts.contact.Contact;
import contacts.menu.manager.MainMenuManager;
import contacts.menu.manager.MenuManager;
import contacts.util.InputUtils;
import contacts.util.Serialization;

import java.io.File;
import java.util.List;

/**
 * The {@code ContactsApp} class serves as the main application logic for managing contacts.
 * It provides functionalities for loading, interacting with, and saving contacts.
 * The application uses a command-driven menu system to process user inputs.
 *
 * <p>The application lifecycle consists of:
 * <ul>
 *   <li>Loading contacts from a file</li>
 *   <li>Interacting with the user through a menu-driven interface</li>
 *   <li>Saving contacts back to the file upon exiting</li>
 * </ul>
 * <p>
 * Dependencies:
 * <ul>
 *   <li>{@link contacts.command.Command}</li>
 *   <li>{@link contacts.contact.Contact}</li>
 *   <li>{@link contacts.menu.MainMenu}</li>
 *   <li>{@link contacts.util.Serialization}</li>
 * </ul>
 */
public class ContactsApp {
    /**
     * Runs the application. This method orchestrates the application's lifecycle
     * from loading contacts to interacting with the user and saving contacts.
     *
     * @param args optional command-line arguments; the first argument can specify the file to load contacts from.
     */
    public void run(String[] args) {
        File file = getFile(args);
        List<Contact> contacts = loadContacts(file);

        MenuManager menuManager = new MainMenuManager(contacts);

        while (menuManager != null) {
            menuManager.displayMenu();
            String input = InputUtils.getLowerCasedInput();
            menuManager = menuManager.handleInput(input);
        }

        saveContacts(contacts, file);
    }

    /**
     * Determines the file to be used for storing contacts.
     * If a file name is provided as a command-line argument, it will be used;
     * otherwise, a default file named "phonebook.db" is used.
     *
     * @param args command-line arguments; the first argument may specify the file name.
     * @return the {@link File} object representing the chosen file.
     */
    private File getFile(String[] args) {
        File file;
        if (args.length != 0) {
            file = new File(args[0]);
        } else {
            file = new File("phonebook.db");
        }
        System.out.println("open " + file.getName());

        return file;
    }

    /**
     * Loads contacts from the specified file.
     *
     * @param file the {@link File} from which contacts are to be loaded.
     * @return a {@link List} of {@link Contact} objects loaded from the file.
     */
    private List<Contact> loadContacts(File file) {
        return Serialization.deserialize(file);
    }

    /**
     * Saves the current list of contacts to the specified file.
     *
     * @param contacts the {@link List} of {@link Contact} objects to be saved.
     * @param file     the {@link File} to which the contacts are to be saved.
     */
    private void saveContacts(List<Contact> contacts, File file) {
        Serialization.serialize(contacts, file);
    }
}
