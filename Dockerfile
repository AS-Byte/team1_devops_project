FROM openjdk:11-jdk-slim
COPY target/springboot-docker.jar springboot-docker.jar
WORKDIR /app
EXPOSE 8086
CMD ["java", "-jar", "/app/springboot-docker.jar"]