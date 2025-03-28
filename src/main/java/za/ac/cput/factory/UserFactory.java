package za.ac.cput.factory;

/*
 * Library Management System.
 * Author: RELEBOHILE MOLEFE 222825790
 */

import za.ac.cput.domain.User;

public class UserFactory {
    public static User createUser(int userID, String firstName, String lastName, String email, String phoneNumber) {
        if (!User.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return new User.Builder()
                .setUserID(userID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();
    }

}
