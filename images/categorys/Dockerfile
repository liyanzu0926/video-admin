FROM openjdk:8-jre
ENV APP_PATH=/apps
WORKDIR $APP_PATH
COPY video-categorys-1.0-SNAPSHOT.jar $APP_PATH/app.jar
EXPOSE 9002
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]