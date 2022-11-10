FROM openjdk:11
EXPOSE 8089
ADD /target/operateur.jar operateur.jar
ENTRYPOINT ["java", "-jar", "/operateur.jar"]