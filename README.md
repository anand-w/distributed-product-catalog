# Distributed Product Catalog System

A scalable microservices-based product catalog platform built using Java, Spring Boot, PostgreSQL, Redis, Kafka, Docker, and Kubernetes.

This project is designed to simulate real-world backend engineering patterns used in large-scale e-commerce systems like Amazon, Flipkart, and Walmart.

---

# Tech Stack

## Backend
- Java 21
- Spring Boot
- Spring Cloud
- Spring Data JPA
- Hibernate
- Spring Security
- JWT Authentication

## Databases & Storage
- PostgreSQL
- Redis
- Elasticsearch (planned)

## Messaging & Async Processing
- Apache Kafka

## DevOps & Infrastructure
- Docker
- Docker Compose
- Kubernetes (planned)
- GitHub Actions (planned)

## Monitoring & Observability
- Spring Boot Actuator
- Prometheus (planned)
- Grafana (planned)
- Distributed Tracing (planned)

---

# System Architecture

The system follows a microservices architecture where each service owns its domain and database responsibilities.

## Planned Services

| Service | Responsibility |
|---|---|
| API Gateway | Central entry point for all requests |
| Auth Service | Authentication & authorization |
| Product Service | Product catalog management |
| Inventory Service | Stock management |
| Search Service | Full-text product search |
| Notification Service | Async notifications & events |

---

# Project Structure

```text
distributed-product-catalog/
│
├── services/
│   ├── api-gateway/
│   ├── auth-service/
│   ├── product-service/
│   ├── inventory-service/
│   ├── search-service/
│   └── notification-service/
│
├── shared/
│   ├── common-lib/
│   ├── logging-lib/
│   └── security-lib/
│
├── infra/
│   ├── docker/
│   ├── k8s/
│   ├── monitoring/
│   └── scripts/
│
├── docs/
│   ├── architecture/
│   ├── diagrams/
│   └── api-specs/
│
├── .github/
│   └── workflows/
│
├── docker-compose.yml
├── README.md
└── .gitignore
```

---

# Current Status

## Phase 1 — Core Backend
- [ ] Product CRUD APIs
- [ ] PostgreSQL integration
- [ ] Validation & exception handling
- [ ] Dockerized local setup
- [ ] Swagger/OpenAPI documentation

## Phase 2 — Distributed Systems
- [ ] API Gateway
- [ ] Inter-service communication
- [ ] Redis caching
- [ ] JWT authentication
- [ ] Inventory microservice

## Phase 3 — Event-Driven Architecture
- [ ] Kafka integration
- [ ] Async event processing
- [ ] Notification service
- [ ] Distributed transactions
- [ ] Outbox pattern

## Phase 4 — Production Engineering
- [ ] Kubernetes deployment
- [ ] CI/CD pipelines
- [ ] Observability stack
- [ ] Distributed tracing
- [ ] Load testing

---

# Getting Started

## Prerequisites

Make sure the following are installed:

- Java 21
- Docker
- Docker Compose
- Git

---

# Local Development Setup

## Clone Repository

```bash
git clone <your-repo-url>
cd distributed-product-catalog
```

---

## Start Infrastructure

```bash
docker compose up -d
```

This will start:
- PostgreSQL
- Redis

---

## Run Product Service

```bash
cd services/product-service
./gradlew bootRun
```

---

# Docker Setup

## Start Services

```bash
docker compose up -d
```

## Stop Services

```bash
docker compose down
```

---

# Git Workflow

## Branching Strategy

```text
main
develop
feature/*
```

## Example Feature Branch

```bash
git checkout -b feature/product-crud
```

---

# Commit Convention

```text
feat: add product entity
fix: handle invalid price validation
refactor: extract mapper logic
docs: update architecture diagram
```

---

# API Design Principles

- RESTful APIs
- DTO-based communication
- Centralized exception handling
- Validation-first design
- Idempotent operations
- Clean layered architecture

---

# Engineering Goals

This project is focused on learning and implementing:

- Microservices architecture
- Event-driven systems
- Distributed system fundamentals
- Backend scalability patterns
- Production-grade DevOps
- Clean code & maintainability
- Observability & monitoring
- System design concepts

---

# Planned Advanced Features

- Rate limiting
- Circuit breakers
- Service discovery
- Distributed tracing
- Search indexing
- CQRS patterns
- Saga orchestration
- API versioning
- Role-based access control

---

# Learning Objectives

By building this project from scratch, the goal is to gain hands-on experience with:

- Enterprise Java development
- Spring ecosystem
- Distributed systems
- Database design
- Docker & Kubernetes
- Event-driven architecture
- Backend scalability
- Production engineering practices

---

# Author

Anand Patel

---

# License

MIT License
