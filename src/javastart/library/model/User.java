package src.javastart.library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable , CsvConvertible{
    private  String firstName;
    private  String lstName;
    private  String pesel;

    public User(String firstName, String lstName, String pesel) {
        this.firstName = firstName;
        this.lstName = lstName;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLstName() {
        return lstName;
    }

    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lstName, user.lstName) &&
                Objects.equals(pesel, user.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lstName, pesel);
    }

    @Override
    public String toString() {
        return firstName +" " + lstName +" " + pesel;
    }
}
