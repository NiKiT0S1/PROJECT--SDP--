/**
 * Represents a user with an ID, name, and email.
 */
public class User {
    private int id;
    private String name;
    private String email;

    /**
     * Constructor for creating a User.
     * @param id The unique identifier of the user.
     * @param name The name of the user.
     * @param email The email address of the user.
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
