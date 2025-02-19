package ru.meeral.friends;

import ru.meeral.users.User;
import java.util.*;

public class FriendServiceImpl implements FriendService {
    private final Map<User, List<User>> friends = new HashMap<>();

    @Override
    public void addFriend(User user, User friend) {
        friends.computeIfAbsent(user, k -> new ArrayList<>()).add(friend);
        friends.computeIfAbsent(friend, k -> new ArrayList<>()).add(user);
    }

    @Override
    public List<User> getFriends(User user) {
        return friends.getOrDefault(user, Collections.emptyList());
    }
}
