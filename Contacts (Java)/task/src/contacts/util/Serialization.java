package contacts.util;

import contacts.contact.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Serialization} class provides utility methods for serializing and deserializing a list of {@link Contact} objects.
 *
 * <p>This class is designed to handle the persistence of contact records by writing them to and reading them from a file.
 */
public final class Serialization {
    private Serialization() {
    }

    /**
     * Serializes the given list of contacts and saves it to the specified file.
     *
     * @param contacts the list of {@link Contact} objects to save
     * @param file     the {@link File} object representing the file to write to
     */
    public static void serialize(List<Contact> contacts, File file) {
        if (file != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(contacts);
            } catch (IOException e) {
                System.out.println("Failed to save records: " + e.getMessage());
            }
        }
    }

    /**
     * Deserializes the list of contacts from the specified file.
     *
     * @param file the {@link File} object representing the file to read from
     * @return a list of {@link Contact} objects loaded from the file, or an empty list if the operation fails
     */
    @SuppressWarnings("unchecked")
    public static List<Contact> deserialize(File file) {
        if (file != null && file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (List<Contact>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Failed to load records: " + e.getMessage());
            }
        }

        return new ArrayList<>();
    }
}
