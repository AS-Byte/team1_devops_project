FROM openjdk:11-jdk-slim
RUN mkdir /app
COPY target/*.jar /app
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "/app/*.jar"]
