FROM openjdk:16
ADD target/AssignmentThree-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]