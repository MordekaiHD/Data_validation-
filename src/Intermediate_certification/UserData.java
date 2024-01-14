package Intermediate_certification;

public class UserData {
    String lastName;
    String firstName;
    String middleName;
    String birthDate;
    long phoneNumber;
    char gender;

    public UserData(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return lastName + " " +  firstName + " " +  middleName + " " +  birthDate + " " + phoneNumber + " " +  gender;
    }

    public String getLastName() {
        return lastName;
    }
}
