# Distributed Catalog

A production-oriented backend project focused on building a scalable and extensible distributed product catalog system using Java and Spring Boot.

The goal of this project is to learn and implement real-world backend engineering concepts such as:
- REST APIs
- modular service architecture
- database design
- bulk data ingestion
- containerized development
- event-driven systems
- observability
- distributed systems fundamentals

This project intentionally starts with a minimal architecture and evolves incrementally into a more distributed system over time.


---

# Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Infrastructure
- Docker
- Docker Compose

## Future Additions
- Kafka
- Redis
- Elasticsearch / OpenSearch
- Kubernetes
- Prometheus + Grafana

---

# Project Structure

```text
distributed-product-catalog/
│
├── catalog-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
│
├── infra/
│   ├── docker-compose.yml
│   └── mysql/
│
├── docs/
│
├── .gitignore
├── README.md
└── pom.xml
```

---

# Current Scope (Phase 1)

The initial phase focuses on building a strong backend foundation with:
- product management APIs
- MySQL integration
- Dockerized local setup
- clean service structure
- bulk product ingestion support
- structured logging
- health check endpoints

The architecture is intentionally simple to prioritize:
- maintainability
- iterative development
- clean fundamentals
- production-style organization

---

# Planned Evolution

## Phase 2
- search indexing service - DONE
- Redis caching - DONE
- performance optimization
  
## Phase 3
- Kafka integration
- asynchronous ingestion pipeline
- event-driven communication

## Phase 4
- observability stack
- metrics and tracing
- Kubernetes deployment

---

# Getting Started

## Clone Repository

```bash
git clone <repository-url>
cd distributed-product-catalog
```

---

# Start Infrastructure

```bash
docker compose -f infra/docker-compose.yml up -d
```

This starts:
- MySQL
- supporting local infrastructure

---

# Run Catalog Service

```bash
cd catalog-service
mvn spring-boot:run
```

---

# API Base URL

```text
http://localhost:8080
```

---

# Development Goals

This project is designed to simulate engineering patterns commonly used in large-scale commerce and marketplace systems.

Key learning areas include:
- scalable backend design
- modular architecture
- schema design
- asynchronous processing
- service decomposition
- infrastructure management
- production readiness

---

# Status

🚧 Currently in active development — Phase 1 foundation setup.
