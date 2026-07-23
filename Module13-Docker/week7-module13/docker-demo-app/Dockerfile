# Module 13 -> "Docker Images" subtopic: multi-stage build.
# Stage 1 (build) has the full Maven+JDK toolchain but is discarded after
# building - only the final JAR crosses into Stage 2, keeping the final
# image small.

# ---- Stage 1: build ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
# Download dependencies first so this layer is cached across code-only rebuilds
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B clean package -DskipTests

# ---- Stage 2: runtime ----
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Run as a non-root user (security best practice)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
