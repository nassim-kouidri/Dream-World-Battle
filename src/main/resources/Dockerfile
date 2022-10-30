FROM docker.io/openjdk/17-slim
LABEL maintainer="team@company.com"
WORKDIR /opt/
EXPOSE 8080
ENTRYPOINT ["java"]
CMD ["-jar", "server.jar]
COPY ./target/dwb-0.0.1-SNAPSHOT-jar-with-dependencies.jar