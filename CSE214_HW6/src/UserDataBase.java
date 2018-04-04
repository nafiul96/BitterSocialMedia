
/**
 * MD NAFIUL AZIM
 * HOMEWORK 6
 * ID#: 110548047
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class UserDataBase extends HashMap<String, User> implements Serializable {

    /**
     * Creates instance of the UserDataBase inheriting from HashMap of Java API
     */
    public UserDataBase() {
        super();
    }

    /**
     * Adds user to the User database
     *
     * @param email- email of the user
     * @param user - the user
     * @throws IllegalArgumentException - This exception is thrown if the email
     * is already exist or the email is empty
     */
    public void addUser(String email, User user) throws IllegalArgumentException {

        if (this.containsKey(email) || email.isEmpty()) {

            throw new IllegalArgumentException("hmm! It looks like this email address already exists.");
        } else {

            this.put(email, user);
        }

    }

    /**
     * Retrieves the user information from the user database by email
     *
     * @param email - the email associated with the user account
     * @return - the user object associated with the email or null if does not
     * exist
     */
    public User getUser(String email) {

        return (User) this.get(email);
    }

    /**
     * It removes the user from the database
     *
     * @param email -Associated email
     * @throws IllegalArgumentException - assures that the email input is not
     * empty or it is in the database
     */
    public void removeUser(String email) throws IllegalArgumentException {

        if (email.isEmpty() || !this.containsKey(email)) {

            throw new IllegalArgumentException("This user account does not exist");
        } else {

            this.remove(email);
            System.out.println("Removed Successfully");
        }

    }

}
