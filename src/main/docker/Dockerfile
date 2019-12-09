FROM docker.io/cemmersb/centos-jdk8:latest
MAINTAINER garyond
VOLUME /tmp
ADD hello-service:0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]