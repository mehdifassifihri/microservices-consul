

FROM openjdk:17

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the outside world
EXPOSE 8761

# Add the application's jar file
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} sr.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sr.jar"]