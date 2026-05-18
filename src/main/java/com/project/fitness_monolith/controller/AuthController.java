package com.project.fitness_monolith.controller;
import com.project.fitness_monolith.dto.LoginRequest;
import com.project.fitness_monolith.dto.LoginResponse;
import com.project.fitness_monolith.dto.RegisterRequest;
import com.project.fitness_monolith.dto.UserResponse;
import com.project.fitness_monolith.model.User;
import com.project.fitness_monolith.repository.UserRepository;
import com.project.fitness_monolith.security.JwtUtils;
import com.project.fitness_monolith.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//End point here  -> Rest-API
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }

    //end point to generate token
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        System.out.println("Here your login request: "+loginRequest);
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if(user==null) return ResponseEntity.status(401).build();

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            return ResponseEntity.status(401).build();
        }

        String token = jwtUtils.generateToken(user.getId(), user.getRole().name());

        return ResponseEntity.ok(new LoginResponse(token, userService.mapToResponse(user)));
    }
}
