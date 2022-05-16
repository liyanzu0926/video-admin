FROM openjdk:8-jre
ENV APP_PATH=/apps
WORKDIR $APP_PATH
COPY video-videos-1.0-SNAPSHOT.jar $APP_PATH/app.jar
EXPOSE 9004
ENTRYPOINT ["java","-jar"]
CMD ["app.jar"]