FROM openjdk:11
EXPOSE 8082
ADD target/team1.jar team1.jar
ENTRYPOINT ["java","-jar","/team1.jar"]