FROM amazoncorretto:17.0.15

ADD ./target/wrtask-1.0-SNAPSHOT.jar /home

WORKDIR /home

EXPOSE 8081

CMD ["java", "-jar", "wrtask-1.0-SNAPSHOT.jar"]
