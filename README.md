# Contacts Application

The **Contacts Application** is a Java-based console program that allows users to manage a list of personal and business contacts. The application was developed as part of the Hyperskill course in track Java Developer. The project demonstrates core Java principles, including object-oriented programming, serialization, and design patterns.

## Features

- **Add Contacts**: Create and save new personal or organizational contacts.
- **Edit Contacts**: Modify existing contact details.
- **Delete Contacts**: Remove a contact from the list.
- **Search Contacts**: Perform a quick search using keywords.
- **List Contacts**: Display all contacts in an organized format.
- **Count Contacts**: View the total number of saved contacts.
- **Serialization**: Save and load contacts to/from a file.
- **Flexible Menu System**: Navigate between menus with ease.

## Class Structure

### Main Components

1. **ContactsApp**
   - The entry point of the application.
   - Initializes the `MainMenuManager` and manages the application's main workflow.

2. **MenuManager**
   - Abstract base class for managing menus.
   - Handles user interactions and delegates actions to commands.

3. **Command**
   - Interface representing an executable action.
   - Includes implementations such as `AddCommand`, `EditCommand`, `RemoveCommand`, etc.

4. **Contact**
   - Abstract base class for all contact types.
   - Extended by `Person` and `Organization` classes to define specific contact behaviors.

5. **SearchStrategy**
   - Interface for implementing search functionality.
   - Includes the `SimpleSearchStrategy` implementation.

6. **Utilities**
   - `InputUtils`: Utility for reading user input.
   - `ContactUtils`: Helper methods for displaying and managing contacts.
   - `Serialization`: Handles saving and loading contacts to/from files.

---


## Design Highlights

### MenuManager Pattern
- **MainMenuManager**: Handles the main menu logic.
- **ListMenuManager**: Manages listing and interacting with specific contacts.
- **RecordMenuManager**: Provides options to edit or delete a specific contact.
- **SearchMenuManager**: Handles search results and subsequent actions.

### Command Pattern
- Encapsulates individual actions into separate classes.
- Promotes flexibility by allowing new commands to be added without modifying existing menus.
  
  ---


## Acknowledgments

This project was created as part of the Hyperskill course in track Java Developer. Special thanks to the Hyperskill team for providing the resources and guidance for this project.
