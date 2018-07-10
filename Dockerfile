FROM anapsix/alpine-java
COPY /target/f10api-demo-1.0.jar /home/f10api-demo-1.0.jar
CMD ["java","-jar","/home/f10api-demo-1.0.jar"]

