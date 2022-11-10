FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD /target/DevOpsProject.jar DevOpsProject.jar
ENTRYPOINT ["java", "-jar", "/DevOpsProject.jar"]