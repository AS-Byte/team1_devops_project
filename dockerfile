FROM openjdk:11-jdk-slim
RUN mkdir -p /app
COPY target/team1.jar /app
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "/app/team1.jar"]
