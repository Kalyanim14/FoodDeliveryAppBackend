# Food Delivery Application - Backend

A robust backend service for a full-stack food delivery platform built with Spring Boot. The application provides secure authentication, role-based authorization, restaurant and menu management, cart functionality, and order processing through RESTful APIs.

## Features

* User Registration and Login
* JWT-Based Authentication
* Role-Based Access Control (Admin/User)
* Restaurant Management
* Food Item Management
* Shopping Cart Functionality
* Order Placement and Management
* RESTful API Architecture
* MySQL Database Integration

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* Maven

### Database

* MySQL

## API Modules

### Authentication

* User Registration
* User Login
* JWT Token Generation
* Authorization

### User Management

* User Profile Management
* Role-Based Access Control

### Restaurant Management

* Create Restaurant
* Update Restaurant
* Delete Restaurant
* View Restaurants

### Food Item Management

* Create Food Items
* Update Food Items
* Delete Food Items
* View Food Items

### Cart Management

* Add Items to Cart
* Update Cart Items
* Remove Cart Items
* View Cart

### Order Management

* Place Orders
* View Order History
* Manage Orders

## Database Schema

### Core Entities

* Users
* Restaurants
* Food Items
* Cart
* Orders
* Order Items

## API Documentation

### Authentication Endpoints

```http
POST /api/auth/register
POST /api/auth/login
```

### Restaurant Endpoints

```http
GET    /api/restaurants
POST   /api/restaurants
PUT    /api/restaurants/{id}
DELETE /api/restaurants/{id}
```

### Food Item Endpoints

```http
GET    /api/foods
POST   /api/foods
PUT    /api/foods/{id}
DELETE /api/foods/{id}
```

### Order Endpoints

```http
GET  /api/orders
POST /api/orders
```

## Project Structure

```text
src/main/java
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── config/
├── security/
└── FoodDeliveryApplication.java
```

## Getting Started

### Prerequisites

* Java 17+
* Maven
* MySQL

### Clone Repository

```bash
git clone (https://github.com/Kalyanim14/FoodDeliveryAppBackend.git)
```

### Configure Database

Update the database configuration in:

```properties
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/food_delivery
spring.datasource.username=root
spring.datasource.password=your_password
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

The backend server will start on:

```text
http://localhost:8080
```

## Future Enhancements

* Payment Gateway Integration
* Order Status Tracking
* Email Notifications
* Restaurant Ratings and Reviews
* Docker Deployment
* Cloud Deployment

## Author

**Kalyani Mantramurthi**
