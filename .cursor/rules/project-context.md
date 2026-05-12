# Distributed Catalog System — Cursor Project Context

## Project Overview

This project is a production-oriented backend system designed to simulate how large-scale e-commerce and marketplace platforms manage product catalogs internally.

The goal is not just to build CRUD APIs, but to gradually evolve the system into a scalable distributed architecture while learning real-world backend engineering concepts.

The system starts as a minimal Spring Boot application and will incrementally evolve into a distributed platform with asynchronous processing, search indexing, caching, observability, and infrastructure tooling.

---

# Current Phase

## Phase 1 Goals

Current focus:
- clean backend fundamentals
- maintainable architecture
- production-grade conventions
- iterative development

Currently building:
- `catalog-service`
- PostgreSQL-backed REST APIs
- Dockerized local setup
- DTO validation
- global exception handling
- Swagger/OpenAPI
- structured logging
- health monitoring

Avoid introducing unnecessary complexity in this phase.

---

# Engineering Philosophy

Follow these principles consistently:

- Keep architecture minimal and intuitive
- Prefer maintainability over clever abstractions
- Avoid overengineering
- Build incrementally
- Prefer production-grade patterns over tutorial-style code
- Keep code extensible and easy to refactor
- Focus on backend engineering fundamentals
- Optimize for readability and long-term scalability

The project should feel like a real internal engineering platform rather than a beginner CRUD application.

---

# Architecture Guidelines

Current architecture style:
- layered architecture
- modular service organization
- clean package separation

Preferred package structure:

```text
controller/
service/
repository/
model/
dto/
mapper/
exception/
```

Guidelines:
- Use DTOs instead of exposing entities directly
- Prefer constructor injection
- Keep controllers thin
- Keep business logic inside services
- Keep repositories focused only on persistence
- Use explicit exception handling
- Prefer meaningful naming
- Avoid unnecessary interfaces initially
- Avoid premature abstractions

---

# Database Guidelines

Use:
- PostgreSQL
- Hibernate-managed schema during early development
- Flyway will be introduced in later phases

Rules:
- During Phase 1, Hibernate schema auto-update is acceptable for rapid iteration
- Flyway migrations will be introduced once the schema stabilizes
- Prefer explicit migrations
- Design schema with scalability in mind
- Add audit timestamps where relevant

---

# API Guidelines

- REST-first design
- Use validation annotations
- Return structured API responses
- Implement global exception handling
- Keep endpoints predictable and clean
- Use proper HTTP status codes

---

# Logging & Monitoring

Use:
- structured logging
- actuator health endpoints

Guidelines:
- Add meaningful logs around important operations
- Avoid excessive logging
- Log operationally useful information

---

# Infrastructure Guidelines

Infrastructure should remain isolated under:

```text
infra/
```

This includes:
- docker-compose
- database setup
- future Kafka setup
- future monitoring setup
- deployment configs

---

# Tech Stack

Current stack:
- Java 17
- Spring Boot
- Maven
- PostgreSQL
- Docker

Planned future additions:
- Kafka
- Redis
- Elasticsearch/OpenSearch
- Kubernetes
- Prometheus/Grafana
- OpenTelemetry

---

# Important Constraints

Avoid introducing:
- reactive programming
- CQRS
- event sourcing
- unnecessary microservices
- excessive generics
- complex abstractions
- premature optimization

Before introducing a new framework or architectural pattern:
- evaluate whether it is justified for the current phase
- prefer simplicity when possible

---

# Expected Future Evolution

## Phase 2
- asynchronous ingestion pipeline
- Kafka integration
- event-driven communication

## Phase 3
- Redis caching
- search indexing
- query optimization

## Phase 4
- observability stack
- tracing
- Kubernetes deployment
- CI/CD pipelines

---

# Expectations From AI Assistance

While generating code or suggestions:

- prioritize clean architecture
- prefer production-grade conventions
- explain important tradeoffs when relevant
- avoid unnecessary complexity
- keep implementations realistic
- favor maintainability
- generate code that is interview-quality and production-oriented
- preserve minimal and intuitive project structure