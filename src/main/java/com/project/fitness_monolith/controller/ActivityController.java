package com.project.fitness_monolith.controller;
import com.project.fitness_monolith.dto.ActivityRequest;
import com.project.fitness_monolith.dto.ActivityResponse;
import com.project.fitness_monolith.service.ActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public  ResponseEntity<ActivityResponse>  trackActivity(@Valid @RequestBody ActivityRequest request,
                                                            Authentication authentication){
        System.out.println("Here You Post Request: "+request);
        return ResponseEntity.ok(activityService.trackActivity(request, authentication.getName()));
    }

    @GetMapping
    public  ResponseEntity<List<ActivityResponse>>  getUserActivities(Authentication authentication){
        String userId = authentication.getName();
        System.out.println("Here Your Get Request: "+userId);
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
