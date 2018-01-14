package productions.darthplagueis.testingsqlite.model;

/**
 * Created by oleg on 1/14/18.
 */

public class Fellow {

    private String lastName;
    private String firstName;
    private String company;

    public Fellow(String lastName, String firstName, String company) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.company = company;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
