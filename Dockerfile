FROM openjdk:11-jdk-slim

WORKDIR /home/fares/Desktop/SpringBoot_Jenkins_test

COPY target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]