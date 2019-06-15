FROM mysql:8

COPY micro-user.sql /docker-entrypoint-initdb.d

FROM openjdk:8

RUN mkdir /usr/src/microuser

COPY micro-user.jar /usr/src/microuser

WORKDIR /usr/src/microuser

CMD ["java", "-jar", "micro-user.jar"]