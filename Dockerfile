FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/api_med_voll-0.0.1-SNAPSHOT.jar /app/api_med_voll-0.0.1.jar
EXPOSE 8080
CMD ["java", "-jar", "api_zap-0.0.1.jar"]
