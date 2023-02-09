FROM amazoncorretto:11-alpine-jdk
MAINTAINER TOBIAS
COPY PracticaArgentinaPrograma/Proyectos/ProyectoParaAgrentinaPrograma_TG/Proyecto_TG/BackEnd/target/tob-0.0.1-SNAPSHOT tobgual-app.jar
ENTRYPOINT ["java","-jar","/tobgual-app.jar"]
