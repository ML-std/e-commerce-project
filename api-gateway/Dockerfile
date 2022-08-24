FROM openjdk:17-alpine
# copy the packaged jar file into our docker image
COPY build/libs/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-0.0.1-SNAPSHOT.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "api-gateway-0.0.1-SNAPSHOT.jar"]