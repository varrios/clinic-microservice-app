# Medical Clinic Administration System

A comprehensive microservices-based medical clinic administration system built with Spring Boot and modern web technologies. This project demonstrates a scalable microservices architecture for managing medical appointments, doctor information, and administrative tasks in a healthcare environment.

## 🏗️ Architecture Overview

This application follows a microservices architecture pattern with the following core components:

```
┌─────────────────┐    ┌─────────────────┐
│   Angular       │    │   API Gateway   │
│   Frontend      │◄──►│   (Port 8080)   │
│   (Port 4200)   │    │                 │
└─────────────────┘    └─────────────────┘
                              │
                              ▼
        ┌─────────────────────────────────────┐
        │            Service Mesh             │
        └─────────────────────────────────────┘
                              │
        ┌─────────────────────┴─────────────────────┐
        │                                           │
        ▼                                           ▼
┌─────────────────┐                    ┌─────────────────┐
│   Appointment   │                    │     Doctor      │
│   Service       │                    │    Service      │
│   (Port 8001)   │                    │   (Port 8002)   │
└─────────────────┘                    └─────────────────┘
        │                                           │
        ▼                                           ▼
┌─────────────────┐                    ┌─────────────────┐
│  H2 Database    │                    │  H2 Database    │
│  (In-Memory)    │                    │  (In-Memory)    │
└─────────────────┘                    └─────────────────┘
```

## 🚀 Technologies Used

### Backend Technologies
- **Spring Boot 3.3.4** - Core framework for microservices
- **Spring Cloud Gateway** - API Gateway for routing and load balancing
- **Spring Data JPA** - Data persistence layer
- **Spring Web** - RESTful web services
- **H2 Database** - In-memory database for development and testing
- **Lombok** - Reduces boilerplate code
- **Maven** - Build automation and dependency management
- **Docker** - Containerization platform

### Frontend Technologies
- **Angular 19.0.3** - Modern frontend framework
- **TypeScript** - Type-safe JavaScript superset
- **Angular CLI** - Command-line interface for Angular
- **Nginx** - Web server for production deployment

### Development
- **Maven Wrapper** - Ensures consistent Maven versions across environments
- **Docker Compose** - Multi-container Docker applications
- **IntelliJ IDEA** - Recommended IDE with .idea configuration

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

- **Java 17** or higher
- **Node.js 18+** and **npm**
- **Docker** and **Docker Compose**
- **Git**

## 📁 Project Structure

```
clinic-microservice-app/
├── appointment/                    # Appointment Management Microservice
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/lg/pg/aui/
│   │   │   │   ├── appointment/    # Appointment domain logic
│   │   │   │   ├── doctor/         # Doctor entities and DTOs
│   │   │   │   └── AuiAppointmentApplication.java
│   │   │   └── resources/
│   │   └── test/
│   ├── Dockerfile
│   ├── pom.xml
│   └── requests.http              # API testing requests
├── doctor/                        # Doctor Management Microservice
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/lg/pg/aui/
│   │   │   │   ├── doctor/
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   └── api/DoctorController.java
│   │   │   │   │   ├── dto/        # Data Transfer Objects
│   │   │   │   │   ├── entity/     # JPA Entities
│   │   │   │   │   ├── repository/ # Data Access Layer
│   │   │   │   │   ├── service/    # Business Logic Layer
│   │   │   │   │   └── event/      # Event handling
│   │   │   │   └── AuiDoctorApplication.java
│   │   │   └── resources/
│   │   └── test/
│   ├── Dockerfile
│   ├── pom.xml
│   └── requests.http
├── frontend/                      # Angular Frontend Application
│   ├── src/
│   │   ├── app/                   # Angular components and services
│   │   ├── assets/                # Static assets
│   │   └── environments/          # Environment configurations
│   ├── public/                    # Public assets
│   ├── docker/
│   │   └── nginx/                 # Nginx configuration for production
│   ├── Dockerfile
│   ├── angular.json               # Angular CLI configuration
│   ├── package.json               # Node.js dependencies
│   ├── tsconfig.json              # TypeScript configuration
│   └── README.md                  # Frontend-specific documentation
├── gateway/                       # API Gateway Service
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/              # Gateway routing configuration
│   │   │   └── resources/
│   │   └── test/
│   ├── web/
│   │   └── WEB-INF/              # Web application configuration
│   ├── Dockerfile
│   ├── pom.xml
│   └── requests.http
├── .idea/                         # IntelliJ IDEA configuration
├── docker-compose.yml             # Multi-container deployment
├── .gitignore
└── README.md
```

## 🛠️ Setup and Installation

### 1. Clone the Repository

```bash
git clone https://github.com/varrios/clinic-microservice-app.git
cd clinic-microservice-app
```

### 2. Backend Services Setup

Each microservice uses Maven Wrapper for consistent build environments:

#### Build All Services
```bash
# Build Appointment Service
cd appointment
./mvnw clean install
cd ..

# Build Doctor Service
cd doctor
./mvnw clean install
cd ..

# Build Gateway Service
cd gateway
./mvnw clean install
cd ..
```

#### Install Dependencies
The following dependencies are included in each service:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- H2 Database (runtime)
- Lombok (compile-time)
- Spring Boot Starter Test (test scope)

### 3. Frontend Setup

```bash
cd frontend
npm install
cd ..
```


## 🚀 Running the Application

### Option 1: Docker Compose (Recommended)

The easiest way to run the entire application stack:

```bash
# Build and start all services
docker-compose up --build

# Run in detached mode
docker-compose up -d --build

# View logs
docker-compose logs -f

# Stop all services
docker-compose down
```

### Option 2: Manual Service Startup

Start services in the following order:

#### 1. Start Backend Services

```bash
# Terminal 1 - Gateway Service
cd gateway
./mvnw spring-boot:run

# Terminal 2 - Doctor Service
cd doctor
./mvnw spring-boot:run

# Terminal 3 - Appointment Service
cd appointment
./mvnw spring-boot:run
```

#### 2. Start Frontend Service

```bash
# Terminal 4 - Frontend
cd frontend
ng serve
```

### Service Endpoints

Once all services are running:

- **Frontend Application**: http://localhost:4200
- **API Gateway**: http://localhost:8080
- **Doctor Service**: http://localhost:8001 (if running standalone)
- **Appointment Service**: http://localhost:8002 (if running standalone)

## 📚 API Documentation

### Gateway Routes

The API Gateway routes requests to appropriate microservices:

```
GET    /api/doctors/*         → Doctor Service
POST   /api/doctors/*         → Doctor Service
PUT    /api/doctors/*         → Doctor Service
DELETE /api/doctors/*         → Doctor Service

GET    /api/appointments/*    → Appointment Service
POST   /api/appointments/*    → Appointment Service
PUT    /api/appointments/*    → Appointment Service
DELETE /api/appointments/*    → Appointment Service
```


### Code Structure

Each microservice follows a layered architecture:

```
src/main/java/lg/pg/aui/{service}/
├── controller/
│   ├── api/                 # REST Controllers
│   └── impl/               # Controller implementations
├── dto/                    # Data Transfer Objects
├── entity/                 # JPA Entities
├── repository/             # Data Access Layer
├── service/                # Business Logic Layer
├── event/                  # Event handling (if applicable)
└── {Service}Application.java  # Main Spring Boot class
```




