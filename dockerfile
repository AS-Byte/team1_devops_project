RUN groupadd -g 999 docker \
    && usermod -aG docker jenkinsFROM openjdk:11-jdk-slim
COPY target/*.jar /
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]