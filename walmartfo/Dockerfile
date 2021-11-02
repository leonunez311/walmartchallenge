FROM maven:3.6.3-jdk-11-slim@sha256:68ce1cd457891f48d1e137c7d6a4493f60843e84c9e2634e3df1d3d5b381d36c AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM openjdk:8-jdk-alpine as prod
RUN mkdir /app
COPY --from=build /project/target/frontoffice-0.0.1-SNAPSHOT.war /app/java-application.war
WORKDIR /app
CMD "java" "-Dspring.profiles.active=docker" "-jar" "java-application.war"

FROM maven:3.6.3-jdk-11-slim@sha256:68ce1cd457891f48d1e137c7d6a4493f60843e84c9e2634e3df1d3d5b381d36c AS testbuild
RUN mkdir /project
COPY . /project
WORKDIR /project

FROM testbuild AS test
CMD mvn test