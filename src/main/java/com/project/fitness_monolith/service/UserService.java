package com.project.fitness_monolith.service;

import com.project.fitness_monolith.dto.LoginRequest;
import com.project.fitness_monolith.dto.RegisterRequest;
import com.project.fitness_monolith.dto.UserResponse;
import com.project.fitness_monolith.model.User;
import com.project.fitness_monolith.model.UserRole;
import com.project.fitness_monolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.USER)
                .build();

//        User user = new User(
//                null, //Taking dummy Id
//                request.getEmail(),
//                request.getPassword(),
//                request.getFirstName(),
//                request.getLastName(),
                  // you can pass null for created at
//                Instant.parse("2007-12-03T10:15:30+01:00")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2007-12-03T10:15:30+01:00")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                List.of(),
//                List.of()
//
//        );
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    public UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }
    public User authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user == null)
            throw new RuntimeException("Invalid Credentials");

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Credentials");
        }

        return user;
    }
}
