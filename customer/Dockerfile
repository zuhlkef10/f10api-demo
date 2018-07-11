FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9093
VOLUME /tmp
COPY /target/customer-1.0.jar /tmp/customer-1.0.jar
CMD ["java","-jar","/tmp/customer-1.0.jar"]

