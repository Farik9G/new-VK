package ru.meeral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.meeral.friends.FriendService;
import ru.meeral.friends.FriendServiceImpl;
import ru.meeral.users.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FriendServiceTest {
    private FriendService friendService;
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp() {
        friendService = new FriendServiceImpl();
        user1 = new User("1", "Александр");
        user2 = new User("2", "Олег");
        user3 = new User("3", "Павел");
    }

    @Test
    public void testAddFriend() {
        friendService.addFriend(user1, user2);
        List<User> friendsOfUser1 = friendService.getFriends(user1);
        List<User> friendsOfUser2 = friendService.getFriends(user2);

        assertTrue(friendsOfUser1.contains(user2), "User1 должен иметь в друзьях User2.");
        assertTrue(friendsOfUser2.contains(user1), "User2 должен иметь в друзьях User1.");
    }

    @Test
    public void testGetFriendsListFromUserWithoutFriends() {
        List<User> friends = friendService.getFriends(user3);
        assertTrue(friends.isEmpty(), "Пользователь без друзей должен получить пустой список.");
    }

}
