# Use an official Java runtime as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/order-service-1.0-SNAPSHOT.jar /app

# Expose the port that the application will run on
EXPOSE 8081

# Run the JAR file
CMD ["java", "-jar", "order-service-1.0-SNAPSHOT.jar"]