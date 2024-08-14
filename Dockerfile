FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install maven -y
RUN mvn clean install -DskipTests
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/api_med_voll-0.0.1.jar /app/api_med_voll-0.0.1.jar
EXPOSE 8080
CMD ["java", "-jar", "api_med_voll-0.0.1.jar"]