package contacts.command;

/**
 * Command to perform invalid user command.
 */
public class UnknownCommand implements Command {
    /**
     * Executes the command to handle unknown input.
     */
    @Override
    public void execute() {
        System.out.println("Error: unknown command!");
    }
}
