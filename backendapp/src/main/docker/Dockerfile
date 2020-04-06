FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN echo '######################'
ADD backendapp-1.0.jar app.jar
RUN mkdir -p /data/log
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 8005
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]