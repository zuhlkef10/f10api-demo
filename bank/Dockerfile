FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9090
VOLUME /tmp
COPY /target/bank-1.0.jar /tmp/bank-1.0.jar
CMD ["java","-jar","/tmp/bank-1.0.jar"]


