package contacts.menu;

import contacts.command.Command;

/**
 * The {@code Menu} class serves as an abstract base for all menu-related functionality within the application.
 *
 * <p>This class provides a framework for defining menus, printing menu options, and handling user input
 * to map actions to corresponding commands. Each specific menu type should extend this class
 * and provide a concrete implementation of the {@link #getCommand(String)} method.
 */
public abstract class Menu {
    private final String menuName;
    private final String[] actions;

    public String getMenuName() {
        return menuName;
    }

    public String[] getActions() {
        return actions;
    }

    /**
     * Constructs a new {@code Menu} with a specified name and actions.
     *
     * @param menuName the name of the menu
     * @param actions  the list of available actions for this menu
     */
    protected Menu(String menuName, String... actions) {
        this.menuName = menuName;
        this.actions = actions;
    }

    /**
     * Retrieves the {@link Command} corresponding to the provided user input.
     *
     * <p>This method must be implemented by subclasses to define how input maps to commands.
     *
     * @param input the user input representing an action
     * @return the corresponding {@code Command} object, or {@code null} if no match is found
     */
    public abstract Command getCommand(String input);
}
