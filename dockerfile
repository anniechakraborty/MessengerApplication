FROM openjdk:17-jdk-slim
WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

# Set the command to run the JAR file
CMD ["java", "-jar", "app.jar"]