FROM openjdk:11-jdk-slim

WORKDIR /home/fares/Desktop/SpringBoot_Jenkins_test

COPY target/SpringBoot_Jenkins_test.jar app.jar

EXPOSE 8099

CMD ["java", "-jar", "/target/SprinbBoot_Jenkins_test.jar"]