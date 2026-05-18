# 🏋️‍♂️ FitPulse-Backend

[![Spring Boot](https://shields.io)](https://spring.io)
[![Spring Security](https://shields.io)](https://spring.io)
[![Docker](https://shields.io)](https://docker.com)
[![MySQL](https://shields.io)](https://mysql.com)

A production-ready, secure, and containerized REST API backend for a comprehensive **Fitness Tracker Application**. Built using modern enterprise design patterns, this system handles user activity metrics, tracks progress, generates AI-powered recommendations, and enforces strict security protocols.

---

## 🚀 Key Features

* **Secure Authentication**: Stateful-to-stateless migration using **JWT (JSON Web Tokens)**.
* **Granular Security**: Fine-grained **Role-Based Access Control (RBAC)** and method-level security via Spring Security.
* **Activity Engine**: Robust logging and monitoring of diverse user fitness routines.
* **AI Recommendations**: Algorithmic generation of personalized fitness suggestions based on historical user metrics.
* **Data Privacy**: Bulletproof password hashing using the **BCrypt encryption algorithm**.
* **Clean Code Architecture**: Implements **DTO Pattern**, **Builder Pattern**, and **Lombok** boilerplate reduction.
* **Production Ready**: Fully dockerized environment, validated using **Spring Bean Validation**, and fully documented with **Swagger/OpenAPI**.

---

## 🛠️ Tech Stack & Tools

* **Backend Framework:** Java & Spring Boot 4
* **Security Framework:** Spring Security, JWT (JSON Web Tokens)
* **Data Access Layer:** Spring Data JPA, Hibernate ORM
* **Database:** MySQL
* **Testing & Documentation:** Swagger UI, OpenAPI 3.0
* **DevOps & Deployment:** Docker, Docker Compose

---

## 📐 System Architecture

```text
 📱 Client (Frontend/Postman)
           │
           ▼ [HTTPS Request + JWT Bearer Token]
 🔒 Spring Security Filter Chain (JWT Validation & Auth)
           │
           ▼
 🎮 REST Controllers (Input Validation via @Valid)
           │
           ▼
 ⚙️ Service Layer (Business Logic & AI Recommendation Engine)
           │
           ▼
 🗄️ Data Access Layer (Spring Data JPA / Hibernate)
           │
           ▼
 💾 MySQL Database
```

---

## 📋 API Documentation Preview

Once the application is running, you can access the interactive API docs via Swagger UI:
* **Local Endpoint:** `http://localhost:8080/swagger-ui/index.html`

### Primary Endpoints Snapshot


| Method | Endpoint | Access Level | Description |
| :--- | :--- | :--- | :--- |
| **POST** | `/api/v1/auth/register` | Public | Register a new user profile |
| **POST** | `/api/v1/auth/login` | Public | Authenticate user and receive JWT |
| **POST** | `/api/v1/activities` | User / Admin | Log a new fitness activity |
| **GET** | `/api/v1/activities` | User / Admin | Retrieve authenticated user activities |
| **GET** | `/api/v1/recommendations` | User | Fetch personalized AI-driven suggestions |

---

## 🐳 Quick Start & Deployment

### Prerequisites
* Docker Desktop installed
* Git installed

### Run via Docker (Recommended)
1. Clone the repository:
   ```bash
   git clone https://github.com
   cd fitpulse-backend
   ```
2. Spin up the entire infrastructure (Application & MySQL Database container):
   ```bash
   docker-compose up --build
   ```
3. The server will start seamlessly on port `8080`.

---

## 👨‍💻 Author
* **Your Name** - [GitHub Profile](https://github.com)
* Project inspired and guided by the Java Backend curriculum of Faisal Memon (EmbarkX).
