FROM amazoncorretto:17
ADD target/HealthionApp-0.0.1-SNAPSHOT.jar HealthionApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "HealthionApp-0.0.1-SNAPSHOT.jar" ]
