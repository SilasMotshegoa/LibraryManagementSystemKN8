package za.ac.cput.domain;

/*
 * Library Management System.
 * Author: RELEBOHILE MOLEFE 222825790
 */


import org.apache.commons.validator.routines.EmailValidator;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private long userID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Integer> borrowedBooks;

    private User() {
    }

    private User(Builder builder) {
        this.userID = builder.userID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public long getUserID() {

        return userID;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmail() {

        return email;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void borrowBook(int bookID) {
    }

    public void returnBook(int bookID) {
    }

    public List<Book> viewBorrowedBooks() {

        return null;
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, firstName, lastName, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder {
        private long userID;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;

        public Builder setUserID(long userID) {
            this.userID = userID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            if (!User.isValidEmail(email)) {
                throw new IllegalArgumentException("Invalid email format");
            }
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User build() {

            return new User(this);
        }
    }
}
