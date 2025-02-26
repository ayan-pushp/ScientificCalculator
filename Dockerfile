# Use OpenJDK as the base image
FROM openjdk:23

# Set the working directory inside the container
WORKDIR /app

# Copy the generated JAR file into the container
COPY target/scientific-calculator.jar app.jar

# Run the Java application
CMD ["java", "-jar", "app.jar"]
