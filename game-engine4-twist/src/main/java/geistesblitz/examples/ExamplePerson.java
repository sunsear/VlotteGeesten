package geistesblitz.examples;

public class ExamplePerson {
    private String firstname;
    private String lastname;

    public ExamplePerson(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
