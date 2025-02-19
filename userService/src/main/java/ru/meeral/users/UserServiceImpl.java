package ru.meeral.users;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User getUserById(String id) {
        return users.get(id);
    }

    @Override
    public void createUser(User user) {
        users.put(user.getId(), user);
    }
}
