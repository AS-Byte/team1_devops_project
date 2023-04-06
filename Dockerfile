FROM openjdk:11
COPY target/spring-boot-docker.jar spring-boot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]