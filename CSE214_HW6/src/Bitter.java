
/**
 * MD NAFIUL AZIM
 * HOMEWORK 6
 * ID#: 110548047
 */
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Bitter implements Serializable {

    private int serialVersionUID;
    private final UserDataBase users;
    private final AccountDataBase accounts;

    /**
     * Constructor of the Bitter object which initiates accounts and user
     * database
     */
    public Bitter() {
        this.users = new UserDataBase();
        this.accounts = new AccountDataBase();
    }

    /**
     * Add the user to the respective database
     *
     * @param email - the email as String key
     * @param user - the user as User
     * @param account - the account
     */
    public void addUser(String email, User user, Account account) {

        users.addUser(email, user);
        accounts.addAccount(email, account);
    }

    /**
     * It removes user from the databases
     *
     * @param email - email of the user
     */
    public void removeUser(String email) {

        Account acc = accounts.getAccountInformation(email);
        User usr = users.get(email);
        Account temp1;
        for (int i = 0; i < acc.getFollowingKey().size(); i++) {

            temp1 = accounts.getAccountInformation(acc.getFollowingKey().get(i));
            temp1.getFollowers().remove(usr);
        }
        users.removeUser(email);
        accounts.removeAccount(email);
        System.out.println("Your Account has been successfully removed.");
    }

    /**
     * It checks whether the user email is in the databases
     *
     * @param email - the email of the user
     * @return true if it exist false otherwise
     */
    public boolean contains(String email) {

        return users.containsKey(email) && accounts.containsKey(email);
    }

    /**
     * Getter for user databases
     *
     * @return the user database
     */
    public UserDataBase getUsers() {
        return users;
    }

    /**
     * Getter for the Accounts database
     *
     * @return - the account database
     */
    public AccountDataBase getAccounts() {
        return accounts;
    }

    /**
     * Prints all the users of the account the key associated with it
     */
    public void printAll() {

        System.out.printf("%-18s%-18s\n", "Name", "Email");
        System.out.println("---------------------------------------------------------");
        if (this.accounts.isEmpty()) {

            System.out.println("Empty");
        } else {
            Set<String> keys = users.keySet();
            Iterator keyIt = keys.iterator();
            for (String key : users.keySet()) {

                System.out.printf("%-18s%-18s\n", users.get(key), key);
            }
        }
    }

    /**
     * Compares two objects for equality
     *
     * @param obj -the other object to be compared
     * @return - returns true if two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bitter other = (Bitter) obj;
        if (this.serialVersionUID != other.serialVersionUID) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        if (!Objects.equals(this.accounts, other.accounts)) {
            return false;
        }
        return true;
    }

}
