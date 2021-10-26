FROM ubuntu:latest

RUN apt-get -y update
RUN apt-get -y install apache2

RUN echo 'Hello World from Kyrylo' > /var/www/html/index.html

CMD ["/usr/sbin/apache2ctl", "-DFOREGROUND"]
EXPOSE 80
