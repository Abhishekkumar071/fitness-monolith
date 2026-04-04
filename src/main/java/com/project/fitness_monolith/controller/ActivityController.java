package com.project.fitness_monolith.controller;
import com.project.fitness_monolith.dto.ActivityRequest;
import com.project.fitness_monolith.dto.ActivityResponse;
import com.project.fitness_monolith.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public  ResponseEntity<ActivityResponse>  trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public  ResponseEntity<List<ActivityResponse>>  getUserActivities(
            @RequestHeader(value = "X-User-ID") String userId
    ){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
