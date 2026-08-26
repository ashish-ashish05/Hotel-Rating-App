# 🏨 Hotel Rating App — Microservices

A **Spring Boot Microservices-based Hotel Rating Application** designed to demonstrate scalable, modular, and resilient distributed-system architecture.

The application is divided into independent services for **Users, Hotels, and Ratings**, with centralized configuration, service discovery, API Gateway routing, inter-service communication, and fault-tolerance mechanisms.

## 🚀 Key Features

* 🧩 **Microservices Architecture**

  * Independent User, Hotel, and Rating services
  * Modular and independently deployable services

* 🔍 **Service Discovery**

  * Implemented service registration and discovery using **Netflix Eureka**
  * Enables dynamic resolution of microservice instances

* 🌐 **API Gateway**

  * Central entry point for client requests
  * Routes requests to appropriate backend services
  * Supports load balancing across service instances

* 🔄 **Inter-Service Communication**

  * Communication between services using:

    * `RestTemplate`
    * `Feign Client`

* ⚙️ **Centralized Configuration**

  * Externalized configuration using **Spring Cloud Config Server**
  * Configuration maintained through a GitHub-backed configuration repository

* 🛡️ **Fault Tolerance**

  * Circuit Breaker
  * Retry mechanism
  * Rate Limiting
  * Implemented using **Resilience4j**

* 🏨 **Hotel Management**

  * Create and manage hotel information
  * Retrieve hotel details
  * Associate ratings with hotels

* ⭐ **Rating Management**

  * Create and retrieve hotel ratings
  * Connect ratings with users and hotels

* 👤 **User Management**

  * Manage user information
  * Retrieve user details and associated ratings

---

## 🏗️ Architecture

```text
                         ┌─────────────────────┐
                         │       Client        │
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │     API Gateway     │
                         │  Spring Cloud GW    │
                         └──────────┬──────────┘
                                    │
                  ┌─────────────────┼─────────────────┐
                  │                 │                 │
                  ▼                 ▼                 ▼
        ┌─────────────────┐ ┌───────────────┐ ┌─────────────────┐
        │  User Service   │ │ Hotel Service │ │ Rating Service  │
        └────────┬────────┘ └───────┬───────┘ └────────┬────────┘
                 │                  │                  │
                 └──────────────────┼──────────────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │   Service Registry  │
                         │       Eureka        │
                         └─────────────────────┘

                         ┌─────────────────────┐
                         │   Config Server     │
                         │ Spring Cloud Config│
                         └──────────┬──────────┘
                                    │
                                    ▼
                         ┌─────────────────────┐
                         │ GitHub Config Repo  │
                         └─────────────────────┘
```

## 📦 Microservices

The repository is organized into the following services:

```text
Hotel-Rating-App
│
├── HotelRatingApp-ApiGateway
│
├── HotelRatingApp-ConfigServer
│
├── HotelRatingApp-Hotel-Service
│
├── HotelRatingApp-Rating-Service
│
├── HotelRatingApp-Service-Registry
│
└── HotelRatingApp-User-Service
```

### 1. 👤 User Service

Responsible for user-related operations.

**Responsibilities:**

* User management
* Retrieve user information
* Manage user-related data
* Integration with Rating Service

---

### 2. 🏨 Hotel Service

Responsible for hotel-related operations.

**Responsibilities:**

* Hotel management
* Retrieve hotel information
* Maintain hotel details
* Retrieve associated ratings

---

### 3. ⭐ Rating Service

Responsible for managing hotel ratings.

**Responsibilities:**

* Create ratings
* Retrieve ratings
* Associate ratings with users
* Associate ratings with hotels

---

### 4. 🔎 Service Registry

The **Eureka Service Registry** acts as the service discovery component.

Instead of services relying on hard-coded hostnames and ports, services register themselves with Eureka and discover other services dynamically.

```text
User Service ───────┐
                    │
Hotel Service ──────┼──────► Eureka Server
                    │
Rating Service ─────┘
```

This improves flexibility when services are scaled or deployed across different instances.

---

### 5. 🌐 API Gateway

The API Gateway provides a **single entry point** for clients.

```text
Client
   │
   ▼
API Gateway
   │
   ├──► User Service
   │
   ├──► Hotel Service
   │
   └──► Rating Service
```

Responsibilities include:

* Request routing
* Service resolution
* Load balancing
* Centralized entry point for APIs

---

### 6. ⚙️ Config Server

The Config Server provides **centralized configuration management** for the microservices.

Configuration is externalized from individual services and maintained through a GitHub-backed configuration repository.

```text
                   ┌───────────────────┐
                   │   GitHub Config   │
                   │    Repository     │
                   └─────────┬─────────┘
                             │
                             ▼
                   ┌───────────────────┐
                   │   Config Server   │
                   └─────────┬─────────┘
                             │
                ┌────────────┼────────────┐
                ▼            ▼            ▼
             User          Hotel        Rating
            Service       Service       Service
```

---

## 🔄 Inter-Service Communication

The application demonstrates two approaches for communication between microservices.

### RestTemplate

`RestTemplate` is used to make HTTP calls between services.

```text
User Service
     │
     │ HTTP Request
     ▼
Rating Service
```

### Feign Client

Feign provides a declarative approach for calling other microservices.

Instead of manually constructing HTTP requests, a service can define an interface representing the remote API.

```text
Hotel Service
     │
     │ Feign Client
     ▼
Rating Service
```

Using both approaches demonstrates practical experience with synchronous communication patterns in Spring Cloud.

---

## 🛡️ Resilience & Fault Tolerance

Distributed systems can fail because of network issues, unavailable services, overloaded instances, or temporary infrastructure problems.

This project uses **Resilience4j** to improve system reliability.

### Circuit Breaker

Prevents repeated requests to a failing service.

```text
Normal:

Service A ─────► Service B
                    │
                    ▼
                 Response


Failure:

Service A ─────► Circuit Breaker ─────► Fallback
                         │
                         X
                    Service B
```

### Retry

Automatically retries failed requests when failures are temporary.

```text
Request
   │
   ▼
Service B
   │
 Failure
   │
   ▼
 Retry
   │
   ▼
Service B
```

### Rate Limiting

Controls the number of requests that can be processed within a specific period, helping protect services from excessive traffic.

---

## 🛠️ Technology Stack

| Technology               | Purpose                                   |
| ------------------------ | ----------------------------------------- |
| **Java**                 | Programming language                      |
| **Spring Boot**          | Microservice development                  |
| **Spring Cloud**         | Distributed-system infrastructure         |
| **Spring Cloud Gateway** | API Gateway                               |
| **Netflix Eureka**       | Service discovery                         |
| **Spring Cloud Config**  | Centralized configuration                 |
| **OpenFeign**            | Declarative inter-service communication   |
| **RestTemplate**         | HTTP-based service communication          |
| **Resilience4j**         | Fault tolerance                           |
| **Maven**                | Dependency management                     |
| **GitHub**               | Source code and centralized configuration |

---

## 🔁 Request Flow

A typical request can flow through the system as follows:

```text
Client
  │
  ▼
API Gateway
  │
  ▼
Service Discovery
  │
  ▼
Target Microservice
  │
  ├──────────────► Another Microservice
  │                     │
  │                     ▼
  │               Resilience4j
  │
  ▼
Response
  │
  ▼
API Gateway
  │
  ▼
Client
```

---

## ⚙️ Getting Started

### Prerequisites

Install the following before running the application:

* Java JDK
* Maven
* Git
* An IDE such as IntelliJ IDEA or Eclipse
* Required databases/configuration used by the individual services

### Clone the Repository

```bash
git clone https://github.com/ashish-ashish05/Hotel-Rating-App.git

cd Hotel-Rating-App
```

### Build the Services

Each service is an independent Spring Boot application.

Navigate into each service and build it using Maven:

```bash
mvn clean install
```

### Start the Services

A typical startup sequence is:

```text
1. Config Server
       ↓
2. Eureka Service Registry
       ↓
3. User Service
       ↓
4. Hotel Service
       ↓
5. Rating Service
       ↓
6. API Gateway
```

Starting the infrastructure services first allows the application services to obtain their centralized configuration and register with the service registry.

> Use the port numbers configured in the project/configuration repository rather than assuming default ports.

---

## 🧪 Testing

The microservices can be tested using tools such as:

* Postman
* cURL
* Browser for GET endpoints
* Any REST API client

A typical testing flow is:

```text
Start Config Server
        ↓
Start Eureka Server
        ↓
Start User / Hotel / Rating Services
        ↓
Verify services are registered with Eureka
        ↓
Start API Gateway
        ↓
Send requests through Gateway
        ↓
Verify inter-service communication
        ↓
Test failure scenarios
        ↓
Verify Resilience4j behavior
```

---

## 📊 Key Concepts Demonstrated

This project demonstrates practical knowledge of:

* Microservices architecture
* Spring Boot
* Spring Cloud
* Service discovery
* Netflix Eureka
* API Gateway
* Spring Cloud Gateway
* Client-side load balancing
* OpenFeign
* RestTemplate
* Centralized configuration
* Spring Cloud Config Server
* Git-based configuration
* Circuit Breaker
* Retry
* Rate Limiting
* Resilience4j
* Inter-service communication
* Distributed-system design

---

## 💡 Why Microservices?

The application separates business responsibilities into independently manageable services.

### Benefits

* **Independent deployment** — Services can be developed and deployed independently.
* **Scalability** — Individual services can be scaled based on demand.
* **Fault isolation** — Failure in one service does not necessarily bring down the entire system.
* **Technology flexibility** — Services can evolve independently.
* **Maintainability** — Smaller services are easier to understand and maintain.
* **Dynamic discovery** — Eureka removes the need for hard-coded service locations.

---
