package contacts.contact;

/**
 * The {@code ContactFactory} interface defines a contract for creating {@link Contact} instances.
 *
 * <p>Implementing classes are responsible for providing the logic to create specific types of contacts,
 * such as persons or organizations.
 */
public interface ContactFactory {
    /**
     * Creates a new {@link Contact} instance.
     *
     * @return a newly created {@link Contact} object.
     */
    Contact createContact();
}
