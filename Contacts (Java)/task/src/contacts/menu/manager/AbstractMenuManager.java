package contacts.menu.manager;

import contacts.command.Command;
import contacts.command.UnknownCommand;
import contacts.menu.Menu;

import java.util.Optional;

/**
 * Abstract class to handle common menu management logic.
 */
public abstract class AbstractMenuManager implements MenuManager {
    protected final Menu menu;

    protected AbstractMenuManager(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void displayMenu() {
        System.out.println();
        System.out.printf("[%s] Enter action (%s):%n", menu.getMenuName(), String.join(", ", menu.getActions()));
    }

    @Override
    public MenuManager handleInput(String input) {
        Command command = Optional.ofNullable(menu.getCommand(input))
                .orElse(new UnknownCommand());

        command.execute();
        return determineNextMenu(command);
    }

    /**
     * Determines the next MenuManager based on the executed command.
     *
     * @param command the executed command
     * @return the next MenuManager, or null to exit
     */
    protected abstract MenuManager determineNextMenu(Command command);
}
