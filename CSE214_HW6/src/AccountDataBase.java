
/**
 * MD NAFIUL AZIM
 * HOMEWORK 6
 * ID#: 110548047
 */
import java.io.Serializable;
import java.util.HashMap;

public class AccountDataBase extends HashMap<String, Account> implements Serializable {

    /**
     * Creates the DataBase for holding accounts, inheriting HashMap from Java
     * API
     */
    public AccountDataBase() {

        super();
    }

    /**
     * Adds the Account to the Database using email as key when the account is
     * created properly
     *
     * @param email - the email of the user
     * @param account- the account associated with the email
     * @throws IllegalArgumentException - assures that the account is created
     * properly and the email address does not preexist in the database
     */
    public void addAccount(String email, Account account) throws IllegalArgumentException {

        if (email.isEmpty() || this.containsKey(email) || account == null) {

            throw new IllegalArgumentException("Account cannot be created!");
        } else {

            this.put(email, account);
        }
    }

    /**
     * Provides the information you need to know about the account using email
     * as search key
     *
     * @param email - the email address associated with the account
     * @return - It returns the Account representation of account associated
     * with the email
     */
    public Account getAccountInformation(String email) {

        return (Account) this.get(email);
    }

    /**
     * It removes the account from the database when possible
     *
     * @param email - the email address associate with the account
     * @throws IllegalArgumentException - The exception is thrown when the email
     * field is empty or the the database does not contain the key
     */
    public void removeAccount(String email) throws IllegalArgumentException {

        if (email.isEmpty() || !this.containsKey(email)) {

            throw new IllegalArgumentException("Remove operation is unsuccessful");
        } else {

            this.remove(email);
            System.out.println("Removed successfully!");
        }
    }

}
