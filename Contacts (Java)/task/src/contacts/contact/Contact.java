package contacts.contact;

import contacts.validation.ContactValidator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The {@code Contact} class serves as an abstract base class for representing a contact in the phone book.
 *
 * <p>Each contact has a phone number, creation date, and modification date. This class provides
 * shared functionality such as phone number validation, modification tracking, and a mechanism to
 * search through contact fields.
 *
 * <p>Subclasses are expected to provide concrete implementations for editable fields, the contact's
 * display name in lists, and searchable fields.
 */
public abstract class Contact {
    protected String phoneNumber;
    protected LocalDateTime creationDateTime;
    protected LocalDateTime modificationDateTime;

    protected Contact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.creationDateTime = LocalDateTime.now();
        this.modificationDateTime = LocalDateTime.now();
    }

    /**
     * Updates the phone number of the contact.
     *
     * <p>If the phone number is invalid, it is set to "[no number]". The modification date is updated
     * to reflect the change.
     *
     * @param phoneNumber the new phone number of the contact.
     */
    public void setPhoneNumber(String phoneNumber) {
        if (ContactValidator.isValidPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "[no number]";
        }
        updateModificationDateTime();
    }

    /**
     * Updates the modification date and time to the current moment.
     */
    protected void updateModificationDateTime() {
        this.modificationDateTime = LocalDateTime.now();
    }

    /**
     * Edits the contact's details.
     *
     * <p>This method is abstract and must be implemented by subclasses to define specific
     * editing behavior for different types of contacts.
     */
    public abstract void edit();

    /**
     * Retrieves the name to be displayed in contact lists.
     *
     * <p>This method is abstract and must be implemented by subclasses to provide a unique name
     * or identifier for the contact.
     *
     * @return the display name of the contact.
     */
    public abstract String getListName();

    /**
     * Retrieves the fields of the contact that can be searched.
     *
     * <p>This method is abstract and must be implemented by subclasses to define which fields
     * of the contact should be considered during a search operation.
     *
     * @return a list of strings representing searchable fields.
     */
    public abstract List<String> getSearchableFields();

    /**
     * Determines whether the contact matches the specified search query.
     *
     * <p>The query is matched against the concatenated searchable fields of the contact, using
     * case-insensitive regular expression matching.
     *
     * @param query the search query.
     * @return {@code true} if the contact matches the query; {@code false} otherwise.
     */
    public boolean matches(String query) {
        String combinedFields = String.join("", getSearchableFields());

        return Pattern.compile(query, Pattern.CASE_INSENSITIVE).matcher(combinedFields).find();
    }
}
