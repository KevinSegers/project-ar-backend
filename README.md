# Project 4WT - Adv programming topics of microservices with Spring Boot

#### Team members: Michal Davidse & Kevin Segers

This repository contains the project of Advanced programming topics of coding microservices using Spring Boot.

The example architecture is as follows:

![alt text](https://github.com/KevinSegers/project-ar-backend/blob/a4f09e8ae42d5afcff88170969b037bb73b13eb7/SchemaProject.png)

One _Edge service_ `brank-edge-service` will connect to two lower services `book-service` and `item-service` to request information which it will then process and combine into a single response to the user. The user is only supposed to communicate with the `brank-edge-service`.
