package com.project.fitness_monolith.repository;

import com.project.fitness_monolith.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String > {
}


/*
🔹 Role of each part
1. JpaRepository<User, String>

This is the most important line.

User → your entity (table)
String → type of primary key (@Id in User class)

By extending this, you inherit ready-made database methods like:

save(user) → insert/update
findById(id) → fetch one user
findAll() → fetch all users
deleteById(id) → delete user

So instead of writing SQL like:

SELECT * FROM users WHERE id = ?

Spring does it for you automatically.

2. @Repository

This tells Spring:

👉 “This is a database layer component”

Spring will:

Detect it during startup
Create its object (bean)
Make it available for dependency injection
3. How it connects to your project

Typical flow:

Controller → Service → Repository → Database
 */