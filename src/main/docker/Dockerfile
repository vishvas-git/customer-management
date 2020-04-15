FROM openjdk:8
MAINTAINER Vishvas <vishvass@hcl.com>
ADD maven/cmdemo-0.0.1-SNAPSHOT.jar cmdemo.jar
RUN sh -c 'touch /cmdemo.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/cmdemo.jar"]
EXPOSE 8081