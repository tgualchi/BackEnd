
FROM amazoncorretto:11-alpine-jdk
MAINTAINER TOB
COPY target/tob-0.0.1-SNAPSHOT.jar  tob-app.jar
ENTRYPOINT ["java","-jar","/tob-app.jar"]