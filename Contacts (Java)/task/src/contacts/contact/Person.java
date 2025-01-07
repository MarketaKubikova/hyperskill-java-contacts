package contacts.contact;

import contacts.util.InputUtils;
import contacts.validation.ContactValidator;

import java.util.List;

/**
 * The {@code Person} class represents a personal contact with details such as name, surname,
 * birthdate, gender, and phone number.
 *
 * <p>This class extends the {@link Contact} abstract class and implements methods for editing
 * and retrieving contact information specific to a person.
 */
public class Person extends Contact {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public Person(String name, String surname, String phoneNumber, String birthDate, String gender) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    /**
     * Updates the name of the person and refreshes the modification timestamp.
     *
     * @param name the new name of the person.
     */
    public void setName(String name) {
        this.name = name;
        updateModificationDateTime();
    }

    /**
     * Updates the surname of the person and refreshes the modification timestamp.
     *
     * @param surname the new surname of the person.
     */
    public void setSurname(String surname) {
        this.surname = surname;
        updateModificationDateTime();
    }

    /**
     * Updates the birthdate of the person after validation and refreshes the modification timestamp.
     *
     * <p>If the provided birthdate is invalid, it defaults to "[no data]".
     *
     * @param birthDate the new birthdate of the person.
     */
    public void setBirthDate(String birthDate) {
        if (ContactValidator.isValidBirthDate(birthDate)) {
            this.birthDate = birthDate;
        } else {
            this.birthDate = "[no data]";
        }
        updateModificationDateTime();
    }

    /**
     * Updates the gender of the person after validation and refreshes the modification timestamp.
     *
     * <p>If the provided gender is invalid, it defaults to "[no data]".
     *
     * @param gender the new gender of the person.
     */
    public void setGender(String gender) {
        if (ContactValidator.isValidGender(gender)) {
            this.gender = gender;
        } else {
            this.gender = "[no data]";
        }
        updateModificationDateTime();
    }

    /**
     * Returns a string representation of the person's details.
     *
     * @return a formatted string containing the person's details, including name, surname, birthdate,
     * gender, phone number, and timestamps for creation and last modification.
     */
    @Override
    public String toString() {
        return String.format("""
                        Name: %s
                        Surname: %s
                        Birth date: %s
                        Gender: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s""",
                name, surname, birthDate, gender, phoneNumber, creationDateTime, modificationDateTime
        );
    }

    /**
     * Allows the user to edit the details of the person.
     *
     * <p>Prompts the user to select a field (e.g., name, surname, birthdate, gender, phone number)
     * and update it with a new value. The modification timestamp is updated after each change.
     */
    @Override
    public void edit() {
        System.out.println("Select a field (name, surname, birth, gender, number):");
        String field = InputUtils.getLowerCasedInput();
        switch (field) {
            case "name" -> {
                System.out.println("Enter name:");
                setName(InputUtils.getInput());
            }
            case "surname" -> {
                System.out.println("Enter surname:");
                setSurname(InputUtils.getInput());
            }
            case "birth" -> {
                System.out.println("Enter birth date:");
                setBirthDate(InputUtils.getInput());
            }
            case "gender" -> {
                System.out.println("Enter gender:");
                setGender(InputUtils.getInput());
            }
            case "number" -> {
                System.out.println("Enter number:");
                setPhoneNumber(InputUtils.getInput());
            }
            default -> System.out.println("Invalid field.");
        }
    }

    /**
     * Returns the name and surname of the person as a single string for listing purposes.
     *
     * @return the full name of the person.
     */
    @Override
    public String getListName() {
        return name + " " + surname;
    }

    /**
     * Returns a list of searchable fields for the person.
     *
     * @return a list containing the name, surname, and phone number of the person.
     */
    @Override
    public List<String> getSearchableFields() {
        return List.of(name, surname, phoneNumber);
    }
}
