FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/webapp-exercise.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
