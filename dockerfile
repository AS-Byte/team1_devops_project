FROM openjdk:11-jdk-slim
COPY target/springboot-docker.jar springboot-docker.jar
RUN mkdir /app
WORKDIR /app
EXPOSE 8086
CMD ["java", "-jar", "/app/springboot-docker.jar"]
