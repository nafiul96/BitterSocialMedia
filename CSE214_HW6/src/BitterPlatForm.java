
/**
 * MD NAFIUL AZIM
 * ID#: 110548047
 */
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BitterPlatForm {

    private static Scanner input;

    private static Bitter bitter;

    private static File file = new File("bitter.ser");

    /**
     * The main Method
     *
     * @param args - command line purpose
     */
    public static void main(String[] args) {
        try {
            input = new Scanner(System.in);
            createBitter();
            BitterRunner();
            saveFile();
        } catch (IOException | ClassNotFoundException e) {

            System.out.println(e);
        }

    }

    /**
     * Runs the Bitter Social Media
     */
    public static void BitterRunner() {

        topLevelMenu();
        System.out.println("Please Select an option: ");
        String in = input.next().toLowerCase();
        input.nextLine();
        switch (in) {
            case "l":
                logIn();
                break;
            case "s":
                signUp();
                break;
            case "q":
                System.out.println("Bye! See ya soon!");
                return;
            default:
                System.out.println("This is not even an option!");
        }

        BitterRunner();

    }

    /**
     * Prints the Top Level Menu
     */
    public static void topLevelMenu() {

        System.out.println("L) Login");
        System.out.println("S) SignUp");
        System.out.println("Q) Quit");
    }

    /**
     * Prints the inner level menu
     */
    public static void userMenu() {

        System.out.println("F) Follow Someone");
        System.out.println("U) Unfollow Someone");
        System.out.println("V) View Follower");
        System.out.println("S) See who you Follow");
        System.out.println("A) List all users");
        System.out.println("L) Logout");
        System.out.println("C) Close Your Account");
    }

    /**
     * This method is used to sign up a new user
     */
    private static void signUp() {

        try {
            System.out.print("Your email: ");
            String email = input.nextLine();
            System.out.println("Your Name: ");
            String name = input.nextLine();
            System.out.println("Enter your password: ");
            String pass = input.nextLine();
            int count = 0;
            while (!Password.passwordCheck(pass)) {
                ++count;
                if (count == 10) {

                    System.out.println("Try signing up again later!");
                    return;
                }
                System.out.println("Your password must contain at least \n"
                        + "One uppercase letter, one lowercase leet, one digit, and one special character such as $@! \n");
                System.out.println("Please reenter your password: ");
                pass = input.nextLine();
            }
            Password passkey = new Password(pass);
            User user = new User(name);
            Account account = new Account(name, passkey);
            bitter.addUser(email, user, account);
            System.out.println("Account has been created successfully. Try logging in!");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    /**
     * It processes logIn aciton
     */
    private static void logIn() {

        try {
            System.out.print("Please enter the email: ");
            String key = input.nextLine();
            if (!bitter.contains(key)) {

                System.out.println("No such account exist");
                return;
            }
            System.out.println("Please enter your password: ");
            String pass = input.nextLine();
            if (!Password.passwordCheck(pass)) {

                return;
            }

            Password p = new Password(pass);
            Account acc = bitter.getAccounts().getAccountInformation(key);

            if (!acc.getPassword().equals(p)) {

                return;
            }
            User usr = bitter.getUsers().getUser(key);
            loggedInActions(acc, usr, key);
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    /**
     * It processes actions of the user once the user is logged in
     *
     * @param acc -account of the person
     * @param usr - the user
     * @param key - the associated email key
     */
    private static void loggedInActions(Account acc, User usr, String key) {

        userMenu();
        System.out.println("Select an option: ");
        String in = input.next().toLowerCase();
        input.nextLine();
        switch (in) {

            case "f":
                toFollow(acc, key);
                break;
            case "u":
                unFollow(acc, key, usr);
                break;
            case "v":
                acc.printFollowers();
                break;
            case "s":
                acc.printFollowing();
                break;
            case "a":
                bitter.printAll();
                break;
            case "l":
                System.out.println("you have been logged out!");
                return;
            case "c":

                bitter.removeUser(key);
                System.out.println("Your account has been removed successfully.");
                return;
            default:
                System.out.println("Not an option! Try agian!");
        }

        loggedInActions(acc, usr, key);

    }

    /**
     * Performs the action of following a user
     *
     * @param acc - account of the follower
     * @param key - email key
     */
    public static void toFollow(Account acc, String key) {

        System.out.println("Please enter the email of the person to follow: ");
        String email = input.nextLine();
        System.out.println(email);
        if (!bitter.contains(email)) {

            System.out.println("This user does not exist");
            return;
        }
        acc.addFollowing(bitter.getUsers().getUser(email));
        bitter.getAccounts().getAccountInformation(email).addFollower(bitter.getUsers().getUser(key));
        acc.getFollowingKey().add(email);
        bitter.getAccounts().getAccountInformation(email).getFollowerKey().add(key);
        System.out.println(email + " has been Followed Successfully. ");

    }

    /**
     * Performs the unfollowing acition
     *
     * @param acc - account assiccaited
     * @param key - key asssociated
     * @param usr - the users
     */
    public static void unFollow(Account acc, String key, User usr) {

        System.out.println("Please enter the email of the person to unfollow: ");
        String email = input.nextLine();
        if (!bitter.contains(email)) {

            System.out.println("This user does not exist");
            return;
        }
        acc.getFollowing().remove(bitter.getUsers().get(email));
        bitter.getAccounts().getAccountInformation(email).getFollowers().remove(bitter.getUsers().getUser(key));
        acc.getFollowingKey().remove(email);

        System.out.println(email + " has been Unfollowed Successfully.");
    }

    /**
     * Creates Bitter Object from a serializable file or creates the object by
     * default if the file does not exist
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void createBitter() throws IOException, ClassNotFoundException {

        FileInputStream inStream;
        ObjectInputStream objInStream;
        if (!file.exists()) {
            bitter = new Bitter();
            file.createNewFile();
        } else {
            try {
                inStream = new FileInputStream(file.getPath());
                objInStream = new ObjectInputStream(inStream);
                bitter = (Bitter) objInStream.readObject();
                objInStream.close();
            } catch (EOFException e) {

                bitter = new Bitter();
            }

        }
    }

    /**
     * Saves the file data to a serializable file when the application is about
     * to close
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveFile() throws FileNotFoundException, IOException {

        FileOutputStream outStream = new FileOutputStream(file.getPath());
        ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
        objOutStream.writeObject(bitter);
        objOutStream.close();
        outStream.close();
    }

}
