package com.project.fitness_monolith.service;

import com.project.fitness_monolith.dto.RecommendationRequest;
import com.project.fitness_monolith.model.Activity;
import com.project.fitness_monolith.model.Recommendation;
import com.project.fitness_monolith.model.User;
import com.project.fitness_monolith.repository.ActivityRepository;
import com.project.fitness_monolith.repository.RecommendationRepository;
import com.project.fitness_monolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public Recommendation genrateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()->new RuntimeException("User Not Found: "+request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(()->new RuntimeException("Activity Not Found: "+request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();
        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        return savedRecommendation;
    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
