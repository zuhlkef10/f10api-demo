FROM anapsix/alpine-java
MAINTAINER zuhlke
EXPOSE 9092
VOLUME /tmp
COPY /target/transaction-1.0.jar /tmp/transaction-1.0.jar
CMD ["java","-jar","/tmp/transaction-1.0.jar"]

