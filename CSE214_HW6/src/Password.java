
/**
 * MD NAFIUL AZIM
 * HOMEWORK 6
 * ID#: 110548047
 */
import java.io.Serializable;
import java.util.Objects;

public class Password implements Serializable {

    private String password;

    /**
     * Constructor for the password object which initiates the password field
     *
     * @param password - the password to be set to the field
     * @throws IllegalArgumentException - checks to see that whether password is
     * valid, in other words whether the password contains at least a number, a
     * caps, a lowercase a, and a special character
     */
    public Password(String password) throws IllegalArgumentException {
        if (!passwordCheck(password)) {

            throw new IllegalArgumentException("Invalid choice of password!");
        } else {

            this.password = password;
        }

    }

    /**
     * checks to see whether the string contains a uppercase character
     *
     * @param s - the string
     * @return true if it contains at least one uppercase
     */
    public static boolean upperCheck(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 65 && s.charAt(i) < 91) {

                return true;
            }
        }

        return false;

    }

    /**
     * checks to see whether the string contains a special character
     *
     * @param s - the string
     * @return true if it contains at least one special char
     */
    public static boolean specialCharCheck(String s) {

        for (int i = 0; i < s.length(); i++) {

            if ((s.charAt(i) >= 32 && s.charAt(i) < 48) || (s.charAt(i) >= 58 && s.charAt(i) < 65)) {

                return true;
            }
        }

        return false;
    }

    /**
     * checks to see whether the string contains a number
     *
     * @param s - the string
     * @return true if it contains at least a number or digit
     */
    public static boolean numCheck(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 48 && s.charAt(i) < 57) {

                return true;
            }
        }

        return false;
    }

    /**
     * checks to see whether the string contains a lowercase character
     *
     * @param s - the string
     * @return true if it contains at least one lowercase
     */
    public static boolean lowerCheck(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 32 && s.charAt(i) < 48) {

                return true;
            }
        }

        return false;
    }

    /**
     * checks to see whether the password contains a caps, a lower, a digit, a
     * special char using the methods defined above
     *
     * @param s - the password string
     * @return - true if it meets all the requirements, false otherwise
     */
    public static boolean passwordCheck(String s) {

        return upperCheck(s) && lowerCheck(s) && specialCharCheck(s) && numCheck(s);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Comapres two password object for equality
     *
     * @param obj - the other object with which this object is compared
     * @return it returns true if two object are equal in type, class, and all
     * the field variables, false otherwise
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
        final Password other = (Password) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

}
