package dashboard.model;

/**
 * Entity which describes the company
 *
 * @author Daniel Gini
 */
public class Company {

    private String name;
    private String address;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
