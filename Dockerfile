FROM tomcat:8.5.50-jdk8-openjdk

MAINTAINER Rikesh Puri "rikeshpuri@gmail.com"

COPY ./target/fibonacci.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]