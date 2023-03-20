FROM openjdk:11-jdk-slim

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /home/fares/Desktop/SpringBoot_Jenkins_test/app.jar
ENTRYPOINT ["java","-jar","/home/fares/Desktop/SpringBoot_Jenkins_test/app.jar"]
EXPOSE 8099

