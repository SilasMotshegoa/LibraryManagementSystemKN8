package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser_ValidEmail_Success() {
        User user = UserFactory.createUser(1, "John", "Doe", "peli@gmail.com", "0697828912");
        assertNotNull(user);
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    void createUser_InvalidEmail_ShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.createUser(2, "Jane", "Smith", "invalid-email", "0987654321");
        });

        assertEquals("Invalid email format", exception.getMessage());
    }
}
