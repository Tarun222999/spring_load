# Step 1: Use a Maven image to build the application
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire project to the working directory
COPY . .

# Package the application (skip tests if necessary)
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight JRE image to run the application
FROM eclipse-temurin:17-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar from the build stage
COPY --from=build /app/target/loadapi.jar app.jar

# Expose the application's port (change if needed)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
