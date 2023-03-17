FROM openjdk:11-jdk-slim

WORKDIR /home/fares/Desktop/SpringBoot_Jenkins_test

COPY target/*.jar app.jar

EXPOSE 8099

CMD ["java", "-jar", "SpringBoot_Jenkins_test.jar"]