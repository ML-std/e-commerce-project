FROM openjdk:17-alpine
# copy the packaged jar file into our docker image
COPY build/libs/product-service-0.0.1-SNAPSHOT.jar product-service-0.0.1-SNAPSHOT.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "product-service-0.0.1-SNAPSHOT.jar"]