package za.ac.cput.repository;

/*
 * Library Management System.
 * Author: RELEBOHILE MOLEFE 222825790
 */

import za.ac.cput.domain.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static UserRepository userRepository = null;
    private List<User> userList;

    private UserRepository() {
        userList = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    public User create(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User read(long userID) {
        return userList.stream()
                .filter(user -> user.getUserID() == userID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public User update(User user) {
        User existingUser = read(user.getUserID());
        if (existingUser != null) {
            userList.remove(existingUser);
            userList.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(long userID) {
        User userToDelete = read(userID);
        if (userToDelete != null) {
            userList.remove(userToDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userList);
    }
}
