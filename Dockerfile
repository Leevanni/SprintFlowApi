# Dockerfile
# setting up your image config

FROM openjdk:8-jre-alpine
# image:tag
# my-app:latest

# every port is close on the container is closed by default
# open the port that your app is running
EXPOSE 8080

# ADD your application to the container
# ADD path-to-jar name-to-be-on-container
ADD target/SprintFlow-Api.jar app.jar

# what command(s) to run inside the container when it starts
#ENTRYPOINT for application (what happens when it start)
ENTRYPOINT ["java","-jar","app.jar"]