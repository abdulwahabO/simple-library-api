FROM openjdk:11-jdk-slim
COPY target/library-api-0.0.1-SNAPSHOT.jar library-api.jar
ENTRYPOINT ["java","-jar","/library-api.jar"]
