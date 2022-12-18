FROM openjdk:19-jdk-alpine
VOLUME /tmp
MAINTAINER Ryan Derr
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar","/app.jar"]