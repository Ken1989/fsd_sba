# Start with a base image containing Java runtime
#FROM openjdk:8-jdk-alpine
FROM registry.cn-hongkong.aliyuncs.com/dingke/jdk8

# Add Maintainer Info
MAINTAINER Ding <dingkebuaa@163.com>

# Set Env
ENV TZ Asia/hongkong

# The application's jar file
ARG JAR_FILE=target/sba_system-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]