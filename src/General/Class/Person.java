package General.Class;

import General.Enum.Gender;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String gmaill;
    private String password;
    private Gender gender;

    public Person(int id, String firstName, String lastName, String gmaill, String password, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gmaill = gmaill;
        this.password = password;
        this.gender = gender;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGmaill() {
        return gmaill;
    }

    public void setGmaill(String gmaill) {
        this.gmaill = gmaill;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Сlass.c.Person :" +
                "\nid :" + id +
                "\nfirstName :" + firstName +
                "\nlastName :" + lastName +
                "\ngmaill :" + gmaill +
                "\npassword :" + password +
                "\ngender :" + gender
                ;
    }
}
