FROM eclipse-temurin:17
WORKDIR workspace
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} reactive-microservice-docker-demo.jar
ENTRYPOINT ["java","-jar","reactive-microservice-docker-demo.jar"]