package za.ac.cput.repository;

/*
 * Library Management System.
 * Author: RELEBOHILE MOLEFE 222825790
 */

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserRepository {
    User create(User user);
    User read(long userID);
    User update(User user);
    boolean delete(long userID);
    List<User> getAll();
}
