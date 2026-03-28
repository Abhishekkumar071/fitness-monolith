package com.project.fitness_monolith.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedTime;
}
