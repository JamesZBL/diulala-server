FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8085
ARG JAR_FILE=web/target/diulala-web.jar
ARG JAR_DEST=/app/app.jar
WORKDIR /app
COPY ${JAR_FILE} ${JAR_DEST}
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod,diulala", "--server.port=8085", "--spring.datasource.url=jdbc:mysql://mysql:3306/diulala?characterEncoding=utf-8&useUnicode=true", "--spring.datasource.username=root", "--spring.datasource.password=root", "--spring.redis.host=redis"]
