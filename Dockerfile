

# Use a base image with Java 17
FROM openjdk:17



# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} exam-portal-0.0.1-SNAPSHOT.jar 

# Expose the application port
EXPOSE 8090

# Run the App
ENTRYPOINT ["java", "-jar"]