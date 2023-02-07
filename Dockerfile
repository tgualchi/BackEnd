FROM amazoncorretto:11-alpine-jdk
MAINTAINER TOBIAS
COPY target/tob-0.0.1-SNAPSHOT tobgual-app.jar
ENTRYPOINT ["java","-jar","/tobgual-app.jar"]
