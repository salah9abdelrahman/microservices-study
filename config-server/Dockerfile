#Why multistage? This will allow us to discard anything that isn’t essential to the execution of the application.
#for example, with Spring Boot, instead of copying the entire target directory to the
#Docker image, we only need to copy what’s necessary to run the Spring Boot application.

#stage 1
#Start with a base image containing Java runtime
#creates an image called build
FROM openjdk:11-slim as build

ARG JAR_FILE=config-server/target/*.jar
COPY ${JAR_FILE} app.jar

#unpackage jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)


#stage 2
#This new image contains the different layers of a Spring Boot app instead of the complete JAR file.
#Same Java runtime
FROM openjdk:11-slim

#Add volume pointing to /tmp
VOLUME /tmp

#Copy unpackaged application to new container
#Copies the different layers from the first image named build
# BOOT-INF/lib folder: contains all of the internal and external dependencies needed to run the application.
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

#execute the application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.configserver.ConfigServerApplication"]