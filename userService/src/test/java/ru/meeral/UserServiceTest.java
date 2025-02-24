package ru.meeral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ru.meeral.users.User;
import ru.meeral.users.UserService;
import ru.meeral.users.UserServiceImpl;


public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    public void testCreateAndGetUser() {
        User user = new User("1", "Александр");
        userService.createUser(user);

        User fetchedUser = userService.getUserById("1");
        assertNotNull(fetchedUser);
        assertEquals("Александр", fetchedUser.getName());
    }

    @Test
    public void testGetNonExistentUser() {
        User user = userService.getUserById("1234");
        assertNull(user);
    }
}
