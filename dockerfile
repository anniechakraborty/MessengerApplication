FROM openjdk:17-jdk-slim

# Installing Gradle
RUN apt-get update && apt upgrade -y
RUN apt-get install -y curl
RUN apt install bash -y
RUN apt-get install unzip
RUN apt-get install zip
RUN zip --version
RUN curl -s https://get.sdkman.io | bash
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install gradle"
RUN echo 'source $HOME/.sdkman/bin/sdkman-init.sh' >> ~/.bashrc \
    && bash -c 'source $HOME/.bashrc'
# RUN sdk version

WORKDIR /app

COPY build/libs/*.jar /app/app.jar
COPY . /app

RUN chmod +x /app/gradlew

# Running tests with Gradle
RUN ./gradlew test

EXPOSE 8080

# Setting the command to run the JAR file
CMD ["java", "-jar", "/app/app.jar"]