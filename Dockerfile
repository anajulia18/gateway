FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/fiap-0.0.1-SNAPSHOT.jar /app/fiap.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/fiap.jar"]
