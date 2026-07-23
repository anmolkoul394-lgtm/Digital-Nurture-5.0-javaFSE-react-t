# Dockerfile
# A minimal example for a small Spring Boot jar - the kind of image you'd build,
# push to Amazon ECR, and reference in task-definition.json above.

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the already-built jar (produced by "mvn package") into the image
COPY target/demo-web-app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
