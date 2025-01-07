package contacts.contact;

import contacts.util.InputUtils;

import java.util.List;

/**
 * The {@code Organization} class represents an organizational contact in the phone book.
 *
 * <p>An organization has a name, an address, and a phone number. This class provides functionality to
 * manage these attributes, including editing and retrieving information.
 */
public class Organization extends Contact {
    private final String organizationName;
    private String address;

    /**
     * Constructs a new {@code Organization} with the specified name, address, and phone number.
     *
     * @param organizationName the name of the organization.
     * @param address          the address of the organization.
     * @param phoneNumber      the phone number of the organization.
     */
    public Organization(String organizationName, String address, String phoneNumber) {
        super(phoneNumber);
        this.organizationName = organizationName;
        this.address = address;
    }

    /**
     * Sets the address of the organization and updates the modification timestamp.
     *
     * @param address the new address of the organization.
     */
    public void setAddress(String address) {
        this.address = address;
        updateModificationDateTime();
    }

    /**
     * Returns a string representation of the organization, including its name, address,
     * phone number, creation time, and last modification time.
     *
     * @return a formatted string with the organization's details.
     */
    @Override
    public String toString() {
        return String.format("""
                        Organization name: %s
                        Address: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s""",
                organizationName, address, phoneNumber, creationDateTime, modificationDateTime
        );
    }

    /**
     * Edits the organization's attributes by prompting the user for input.
     *
     * <p>Users can modify the address or phone number. Invalid fields result in an error message.
     */
    @Override
    public void edit() {
        System.out.println("Select a field (address, number):");
        String field = InputUtils.getLowerCasedInput();
        switch (field) {
            case "address":
                System.out.println("Enter address:");
                setAddress(InputUtils.getInput());
                break;
            case "number":
                System.out.println("Enter number:");
                setPhoneNumber(InputUtils.getInput());
                break;
            default:
                System.out.println("Invalid field.");
        }
    }

    /**
     * Retrieves the name of the organization, used for listing purposes.
     *
     * @return the organization's name.
     */
    @Override
    public String getListName() {
        return organizationName;
    }

    /**
     * Retrieves the searchable fields of the organization, which include the name and phone number.
     *
     * @return a list of strings representing the searchable fields.
     */
    @Override
    public List<String> getSearchableFields() {
        return List.of(organizationName, phoneNumber);
    }
}
