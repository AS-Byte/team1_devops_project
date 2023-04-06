FROM openjdk:11-jdk-slim
# Create a 'jenkins' user and add it to the 'docker' group
RUN useradd -m -u 1000 jenkins \
    && groupadd docker \
    && usermod -aG docker jenkins \
    && yum install -y docker \
    && yum clean all
# Set the user to 'jenkins'
USER jenkins
COPY target/*.jar /
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
