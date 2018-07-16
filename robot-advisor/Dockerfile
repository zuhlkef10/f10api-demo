FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9096
VOLUME /tmp
COPY /target/robot-advisor-1.0.jar /tmp/robot-advisor-1.0.jar
CMD ["java","-jar","/tmp/robot-advisor-1.0.jar"]