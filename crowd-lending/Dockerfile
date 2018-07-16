FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9097
VOLUME /tmp
COPY /target/crowd-lending-1.0.jar /tmp/crowd-lending-1.0.jar
CMD ["java","-jar","/tmp/crowd-lending-1.0.jar"]