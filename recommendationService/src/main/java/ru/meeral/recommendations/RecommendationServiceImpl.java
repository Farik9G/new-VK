package ru.meeral.recommendations;

import ru.meeral.friends.FriendService;
import ru.meeral.users.User;

import java.util.*;

public class RecommendationServiceImpl implements  RecommendationService{
    private final FriendService friendService;

    public RecommendationServiceImpl(FriendService friendService) {
        this.friendService = friendService;
    }

    @Override
    public List<User> getFriendRecommendations(User user) {
        List<User> friends = friendService.getFriends(user);
        Set<User> recommendations = new HashSet<>();

        for (User friend : friends) {
            recommendations.addAll(friendService.getFriends(friend));
        }

        recommendations.remove(user);
        friends.forEach(recommendations::remove);

        return new ArrayList<>(recommendations);
    }
}
