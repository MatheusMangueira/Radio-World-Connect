FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install -y openjdk-17-jdk -y

COPY . .

RUN apt-get install -y maven
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/RadioWorldConnect-4.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]