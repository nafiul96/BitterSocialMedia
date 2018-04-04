
/**
 * MD NAFIUL AZIM
 * HOMEWORK 6
 * ID#: 110548047
 */
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String name;

    /**
     * Constructor for the user object which creates user with specific name
     *
     * @param name - name of the user
     * @throws IllegalArgumentException - assures that the user field is not
     * empty
     */
    public User(String name) throws IllegalArgumentException {

        if (name.isEmpty()) {

            throw new IllegalArgumentException("This field cannot be empty");
        } else {

            this.name = name;
        }
    }

    /**
     * Compares two objects to check for equality
     *
     * @param obj - the other object to be compared
     * @return - It returns true if two objects are equal in type, class, all
     * the field variables
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
        final User other = (User) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return this.name;
    }

}
