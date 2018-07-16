FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9091
VOLUME /tmp
COPY /target/insurance-1.0.jar /tmp/insurance-1.0.jar
CMD ["java","-jar","/tmp/core-bank-1.0.jar"]