# Week 4 — Module 8: Microservices with Spring Boot 3 and Spring Cloud

DN5.0 Java FSE **Week 4 / Module 8** ka complete multi-module microservices
project — 5 Maven modules jo saare key subtopics cover karte hain.

## Modules

| Module | Port | Purpose |
|---|---|---|
| `discovery-server` | 8761 | Eureka service registry — Service Discovery pattern |
| `config-server` | 8888 | Spring Cloud Config — externalized config (`config-repo/`) |
| `api-gateway` | 8080 | Spring Cloud Gateway — single entry point, routing, load balancing |
| `product-service` | 8081 | Owns Product data (Database per Service) |
| `order-service` | 8082 | Calls product-service via Feign, wrapped in a Resilience4j Circuit Breaker |

## Har subtopic kahan implement hai

| Key Topic | Sub-topic | File(s) |
|---|---|---|
| Intro / Principles / Challenges of Microservices | Whole multi-module split itself | Root `pom.xml`, all 5 modules |
| Microservices Architecture Overview | Service discovery, API Gateway, Load balancing | `discovery-server`, `api-gateway` |
| Design Patterns | Service Registry/Discovery, Circuit Breaker | `discovery-server`, `order-service/service/OrderService.java` |
| Inter-Service Communication | Sync REST via Feign, failure handling | `order-service/client/ProductClient.java` |
| Data Management | Database per Service | Each service has its own H2 datasource |
| Spring Cloud for Microservices | Eureka, Spring Cloud Config | `discovery-server`, `config-server` |
| Microservices Communication with Spring Cloud | Feign declarative client | `order-service/client/ProductClient.java` |
| API Gateway and Edge Services | Spring Cloud Gateway routing/filters | `api-gateway/src/main/resources/application.yml` |
| Fault Tolerance and Resilience | Circuit breaker + fallback | `order-service/service/OrderService.java` (`@CircuitBreaker`) |
| Spring Cloud Config | Externalized, per-service config | `config-repo/product-service.yml`, `config-repo/order-service.yml` |
| Monitoring and Metrics | Actuator + Prometheus-ready endpoints | `application.yml` in every service (`management.endpoints`) |
| Security | (see note below) | — |

> **Note on Security topics** (Spring Security for Microservices, Centralized
> Auth/OAuth2/JWT, SSO): Week 3's project already has a full JWT + Spring
> Security implementation (`AuthController`, `JwtUtil`, `SecurityConfig`).
> The same pattern applies per-service here; it's left out of this project
> to keep the microservices focus clean — wire it into `api-gateway` as a
> global filter if you want centralized auth at the edge.

## Run order (separate terminals)
```bash
cd discovery-server && mvn spring-boot:run    # 1. start first
cd config-server     && mvn spring-boot:run    # 2.
cd product-service   && mvn spring-boot:run    # 3.
cd order-service     && mvn spring-boot:run    # 4.
cd api-gateway        && mvn spring-boot:run    # 5. start last
```

- Eureka dashboard: `http://localhost:8761`
- Direct: `http://localhost:8081/api/products`, `http://localhost:8082/api/orders`
- Via Gateway: `http://localhost:8080/products`, `http://localhost:8080/orders`

## Try the Circuit Breaker
1. Start everything, hit `http://localhost:8082/api/orders/check-product/1` → real product data.
2. Stop `product-service`.
3. Hit the same URL again a few times → after the failure threshold, the
   circuit opens and you instantly get the fallback response instead of a
   timeout/hang.

## GitHub pe push karna
```bash
git init
git add .
git commit -m "Week 4: Module 8 - Microservices with Spring Boot 3 and Spring Cloud"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
