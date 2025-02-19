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
        user1 = new User("1", "���������");
        user2 = new User("2", "����");
        user3 = new User("3", "�����");
    }

    @Test
    public void testAddFriend() {
        friendService.addFriend(user1, user2);
        List<User> friendsOfUser1 = friendService.getFriends(user1);
        List<User> friendsOfUser2 = friendService.getFriends(user2);

        assertTrue(friendsOfUser1.contains(user2), "User1 ������ ����� � ������� User2.");
        assertTrue(friendsOfUser2.contains(user1), "User2 ������ ����� � ������� User1.");
    }

    @Test
    public void testGetFriendsListFromUserWithoutFriends() {
        List<User> friends = friendService.getFriends(user3);
        assertTrue(friends.isEmpty(), "������������ ��� ������ ������ �������� ������ ������.");
    }

}
