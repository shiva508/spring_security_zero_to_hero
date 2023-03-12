FROM openjdk:17-alpine
VOLUME /tmp
COPY target/student-pool-discovery-0.0.1-SNAPSHOT.jar student-pool-discovery.jar
ENTRYPOINT ["java","-jar","student-pool-discovery.jar"]