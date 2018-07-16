FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9090
VOLUME /tmp
COPY /target/core-bank-1.0.jar /tmp/core-bank-1.0.jar
CMD ["java","-jar","/tmp/core-bank-1.0.jar"]