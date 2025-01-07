package contacts.menu.manager;

/**
 * Represents a manager for handling menus.
 */
public interface MenuManager {
    /**
     * Displays the current menu to the user.
     */
    void displayMenu();

    /**
     * Processes user input and executes the corresponding command.
     *
     * @param input the user input
     * @return the next MenuManager to handle the flow, or null to exit.
     */
    MenuManager handleInput(String input);
}
