FROM openjdk:12-jdk-alpine
EXPOSE 8081
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]