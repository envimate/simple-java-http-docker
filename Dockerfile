FROM openjdk:12

ADD target/simple-java-rest-docker-0.0.1-jar-with-dependencies.jar /opt/application.jar

EXPOSE 1337

ENTRYPOINT exec java -jar /opt/application.jar
