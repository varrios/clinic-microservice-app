FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy the application JAR file
COPY target/AUI-PROJECT-APPOINTMENT-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app will run on
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]