package com.project.fitness_monolith.controller;


import com.project.fitness_monolith.dto.RecommendationRequest;
import com.project.fitness_monolith.model.Recommendation;
import com.project.fitness_monolith.service.RecommendationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;
    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(@Valid @RequestBody RecommendationRequest request,
                                                                 Authentication authentication){
        Recommendation recommendation = recommendationService.genrateRecommendation(request, authentication.getName());
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(Authentication authentication){
        String userId = authentication.getName();
        List<Recommendation> recommendationList = recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable String activityId){
        List<Recommendation> recommendationList = recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }
}
