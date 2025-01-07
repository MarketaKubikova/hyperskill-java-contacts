package contacts;

/**
 * The entry point of the Contacts application.
 * <p>
 * This class initializes the {@link ContactsApp} and starts the application.
 */
public class Main {
    /**
     * The main method, serving as the entry point for the Contacts application.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        ContactsApp app = new ContactsApp();
        app.run(args);
    }
}
