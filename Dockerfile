
FROM amazoncorretto:11-alpine-jdk
MAINTAINER CentroBoro
COPY target/tob-0.0.1-SNAPSHOT.jar  CentroBoro-app.jar
ENTRYPOINT ["java","-jar","/CentroBoro-app.jar"]