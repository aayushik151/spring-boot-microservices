# Use an official Java runtime as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/spring-boot-microservices-1.0-SNAPSHOT.jar /app

# Expose the port that the application will run on
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "spring-boot-microservices-1.0-SNAPSHOT.jar"]