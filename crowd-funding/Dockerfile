FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9095
VOLUME /tmp
COPY /target/crowd-funding-1.0.jar /tmp/crowd-funding-1.0.jar
CMD ["java","-jar","/tmp/crowd-funding-1.0.jar"]