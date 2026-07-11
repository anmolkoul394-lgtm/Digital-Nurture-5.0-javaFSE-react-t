# Week 2 — Spring Core & Maven + Spring Data JPA with Spring Boot, Hibernate

DN5.0 Java FSE learning plan ke **Week 2** ke dono modules ka ek hi runnable
Spring Boot project mein complete, working implementation:

- **Module 5** — Spring Core and Maven
- **Module 6** — Spring Data JPA with Spring Boot, Hibernate

## Tech stack
Java 17 · Spring Boot 3.2.5 · Maven · Spring Data JPA (Hibernate) · Spring AOP · H2 (in-memory)

## Har subtopic kahan implement hai

| Key Topic | Sub-topic | File(s) |
|---|---|---|
| Intro to Spring | IoC / DI, Spring modules | Whole project, esp. `service/EmployeeService.java` |
| Maven setup | pom.xml, dependencies | `pom.xml` |
| Spring IoC Container | XML config, beans | `resources/spring/applicationContext.xml`, `config/AppConfig.java` |
| Spring Bean Configuration | `@Configuration`, `@Bean`, component scan, mixing XML+Java | `config/AppConfig.java` |
| Dependency Injection | Constructor injection, `@Qualifier`, `@Primary` | `service/EmployeeService.java`, `service/notification/*` |
| Spring AOP | `@Aspect`, `@Before/@After/@Around`, pointcuts | `aspect/LoggingAspect.java` |
| Spring MVC & ORM | Controller layer, validation, exception handling | `controller/*`, `exception/*` |
| Spring Boot Intro | `@SpringBootApplication`, auto-configuration | `Week2Application.java` |
| Spring Data JPA intro | Repository abstraction | `repository/*` |
| Project + DB setup | `application.properties` | `resources/application.properties` |
| Entity Mapping | `@Entity`, `@Table`, `@Id`, relationships | `entity/Employee.java`, `entity/Department.java` |
| Spring Data Repositories | `JpaRepository`, derived queries | `repository/EmployeeRepository.java` |
| CRUD Operations | Create/Read/Update/Delete | `service/EmployeeService.java`, `controller/EmployeeController.java` |
| Query Methods & Named Queries | Method-name queries, `@Query` (JPQL + native) | `repository/EmployeeRepository.java` |
| Pagination & Sorting | `Page`, `Pageable`, `Sort` | `EmployeeController#byDepartment` |
| Auditing | `@CreatedDate/@LastModifiedDate/@CreatedBy/@LastModifiedBy` | `entity/Employee.java`, `config/JpaAuditingConfig.java` |
| Projections | Interface-based projection | `projection/EmployeeSummary.java` |
| Spring Boot + JPA Integration | Auto-config, externalized properties | `application.properties` |
| Spring Data JPA + Hibernate | Dialect, batch processing | `application.properties` (hibernate.* props) |

## Run locally
```bash
mvn spring-boot:run
```
App: `http://localhost:8080` · H2 console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:week2db`)

## Sample endpoints
```
GET  /api/departments
POST /api/departments
GET  /api/employees
POST /api/employees?departmentId=1
GET  /api/employees/search/by-designation?designation=Software Engineer
GET  /api/employees/search/salary-range?min=40000&max=70000
GET  /api/employees/by-department?name=IT&page=0&size=5&sortBy=salary&direction=DESC
GET  /api/employees/by-department/summary?name=IT
```

## GitHub pe push karna
```bash
git init
git add .
git commit -m "Week 2: Spring Core & Maven + Spring Data JPA with Hibernate"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```

## Reference (source plan)
Har topic ke original learning links Week 2 sheet ke `Learning Reference Links`
column mein already hain — is project ko unke saath side-by-side padhein.
