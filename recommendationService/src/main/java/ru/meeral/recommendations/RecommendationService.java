package ru.meeral.recommendations;

import ru.meeral.users.User;

import java.util.List;

public interface RecommendationService {
    List<User> getFriendRecommendations(User user);
}
