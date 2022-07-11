FROM openjdk:8-alpine

ADD ./target/spring-boot-demo.jar .

CMD ["java","-jar","spring-boot-demo.jar"]