FROM openjdk:11.0.4-jre-slim
COPY build/libs/currency-*.jar currency.jar
EXPOSE 8080
CMD java -jar currency.jar