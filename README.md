# Project 4WT - Adv programming topics of microservices with Spring Boot

#### Team members: Michal Davidse & Kevin Segers

This repository contains the project of Advanced programming topics of coding microservices using Spring Boot.

The example architecture is as follows:

![alt text](https://github.com/KevinSegers/project-ar-backend/blob/experimental/SchemaProject.png?raw=true)

One _Edge service_ `brank-edge-service` will connect to two lower services `book-service` and `page-service` to request information which it will then process and combine into a single response to the user. The user is only supposed to communicate with the `brank-edge-service`.


### Set up the Docker container with the MySQL database:

`docker run --name books-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=abc123 -d mysql `

### Set up the Docker container with the MongoDB database:

`docker run --name pages-mongodb -p 27017-27019:27017-27019 -d mongo`
