FROM openjdk:11-jdk-slim
RUN groupadd -g 999 docker \
    && usermod -aG docker jenkins
COPY target/*.jar /
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
