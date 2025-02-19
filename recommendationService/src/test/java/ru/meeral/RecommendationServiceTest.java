package ru.meeral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import ru.meeral.friends.FriendService;
import ru.meeral.recommendations.RecommendationService;
import ru.meeral.recommendations.RecommendationServiceImpl;
import ru.meeral.users.User;

import java.util.List;
public class RecommendationServiceTest {
    @Test
    void testGetFriendRecommendations() {
        FriendService friendService = mock(FriendService.class);
        RecommendationService recommendationService = new RecommendationServiceImpl(friendService);

        User user = new User("1", "Alice");
        User friend = new User("2", "Bob");
        User recommended = new User("3", "Charlie");

        when(friendService.getFriends(user)).thenReturn(List.of(friend));
        when(friendService.getFriends(friend)).thenReturn(List.of(user, recommended));

        List<User> recommendations = recommendationService.getFriendRecommendations(user);
        assertTrue(recommendations.contains(recommended));
    }
}
