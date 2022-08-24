FROM openjdk:17-alpine
# copy the packaged jar file into our docker image
COPY build/libs/eureka-server-0.0.1-SNAPSHOT.jar eureka-server-0.0.1-SNAPSHOT.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "eureka-server-0.0.1-SNAPSHOT.jar"]