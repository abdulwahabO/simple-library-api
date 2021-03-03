[![build](https://github.com/abdulwahabO/simple-library-api/actions/workflows/build.yml/badge.svg)](https://github.com/abdulwahabO/simple-library-api/actions/workflows/build.yml)

## Overview
A simple library Rest API that provides CRUD endpoints for managing books. This app is secured using 
Spring Security's OAuth2 resource server implementation. To access any of its endpoints, a JWT token obtained
from an authorization server has to be included in an `Authorization` header.

This is developed using:

* Spring (Boot, Data JPA, OAuth2 Resource Server)
* H2 Database
* Docker
* Maven

The API provides the following endpoints:

* GET `/library/search/author?q={NAME_OF_AUTHOR}`
* GET `/library/search/title?q={BOOK_TITLE}`
* POST `/library/add`
* DELETE `/library/delete/{ISBN_OF_BOOK}`
* PUT `/library/lend/{ISBN}/{EMAIL_OF_LENDEE}`

## Deploying

* Build the project using  `./mvnw clean package`
* Build a Docker image using `docker build -t <name> .`
* Run the docker image `docker run -p 8080:8080 <name>`

**Important** This project uses Spring Security 5 implicitly which means setting up an OAuth2 Authorization
Server as a Spring Boot app is not supported. Instead An external authorization server(Keycloak in this case) is used.
This app will not start if a configured Keycloak server is not running on localhost:8083.