package ru.meeral.users;

public interface UserService {
    User getUserById(String id);

    void createUser(User user);
}
