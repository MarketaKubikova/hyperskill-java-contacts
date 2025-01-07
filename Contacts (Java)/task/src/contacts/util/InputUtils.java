package contacts.util;

import java.util.Scanner;

/**
 * The {@code InputUtils} class provides utility methods for handling user input.
 *
 * <p>Provides methods for reading strings and integers from the console.</p>
 * It is designed to be a utility class and, as such, cannot be instantiated.
 */
public final class InputUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputUtils() {
    }

    /**
     * Reads a line of input from the user.
     *
     * @return the input string provided by the user
     */
    public static String getInput() {
        return SCANNER.nextLine().trim();
    }

    /**
     * Reads a line of input from the user.
     *
     * @return the input string in lower case provided by the user
     */
    public static String getLowerCasedInput() {
        return getInput().toLowerCase();
    }


}
