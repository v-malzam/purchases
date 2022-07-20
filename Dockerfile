# syntax=docker/dockerfile:latest
FROM bellsoft/liberica-openjdk-alpine:11
COPY target/*.jar purchases.jar
ENTRYPOINT ["java","-jar","/purchases.jar"]