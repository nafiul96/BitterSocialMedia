
/**
 * MD NAFIUL AZIM
 * HOMEWORK 6
 * ID#: 110548047
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Account implements Serializable {

    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> followingKey;
    private ArrayList<String> followerKey;
    private String name;
    private Password password;

    /**
     * The constructor for the Account Object
     *
     * @param name - user's real name
     * @param password - the password for this account
     */
    public Account(String name, Password password) {
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.followingKey = new ArrayList<>();
        this.followerKey = new ArrayList<>();
        this.name = name;
        this.password = password;
    }

    /**
     * Getter for the follower keys
     *
     * @return arrayList of Strings representing emails of the followers
     */
    public ArrayList<String> getFollowerKey() {
        return followerKey;
    }

    /**
     * Getter for the following key
     *
     * @return arraylist representation of the emails of people who you follow
     */
    public ArrayList<String> getFollowingKey() {
        return followingKey;
    }

    /**
     * Adds user to the follower list
     *
     * @param toFollow - the user to be followed
     */
    public void addFollowing(User toFollow) {

        this.following.add(toFollow);
    }

    /**
     * Adds user who has just followed you
     *
     * @param follow - the user who followed you just now
     */
    public void addFollower(User follow) {

        this.followers.add(follow);
    }

    /**
     * Removes the follower from the follower list
     *
     * @param usr
     */
    public void removeFollower(User usr) {

        this.followers.remove(usr);
    }

    /**
     * Getter for the follower list
     *
     * @return - ArrayList of users representing all the users who follows you
     */
    public ArrayList<User> getFollowers() {
        return followers;
    }

    /**
     * Getter for the list of people you follow
     *
     * @return - ArrayList of users representing users who you follow
     */
    public ArrayList<User> getFollowing() {
        return following;
    }

    /**
     * Getter for your name
     *
     * @return - the actual name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the password field
     *
     * @return - Password representation of the Password Object
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Prints all the followers of you
     */
    public void printFollowers() {

        System.out.printf("%-18s%-18s\n", "Name", "Email");
        System.out.println("---------------------------------------------------------");
        if (followers.isEmpty()) {

            System.out.println("Empty");
        } else {

            for (int i = 0; i < this.followers.size(); i++) {

                System.out.printf("%-18s%-18s\n", followers.get(i).toString(), followerKey.get(i));
            }
        }
    }

    /**
     * Prints all the users you follow
     */
    public void printFollowing() {
        System.out.printf("%-18s%-18s\n", "Name", "Email");
        System.out.println("---------------------------------------------------------");
        if (following.isEmpty()) {

            System.out.println("Empty");
        } else {

            for (int i = 0; i < this.following.size(); i++) {

                System.out.printf("%-18s%-18s", following.get(i), followingKey.get(i));
                System.out.println(following.get(i));
            }
        }
    }

    /**
     * Equals Method to compare to objects of Account type for equality
     *
     * @param obj - the other object to be compared
     * @return - It returns true if two objects are equal in all the field
     * variables, classes, types, otherwise returns false
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.followers, other.followers)) {
            return false;
        }
        if (!Objects.equals(this.following, other.following)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

}
