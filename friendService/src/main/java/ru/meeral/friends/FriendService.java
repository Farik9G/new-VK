package ru.meeral.friends;

import ru.meeral.users.User;

import java.util.List;

public interface FriendService {
    void addFriend(User user, User friend);
    List<User> getFriends(User user);
}
