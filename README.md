# Spring Boot
This Repo contains detailed instructions about how to start a spring boot application.

1. Spring Boot follows layered architecture:
<img width="1318" alt="Screenshot 2024-12-26 at 10 30 36 AM" src="https://github.com/user-attachments/assets/1f0173d6-924a-4c04-bf13-18fa04663302" />

## Controller Layer:
This layer contains all the end points.</br>
such as /payment , /payment/mode etc. </br>
It contains annotations such as @RestController,@Controller</br>

## Service Layer:
It contains annotations such as @Service</br>
This is where we right our business logic</br>

## Repository Layer:
It contains annotation such as @Repository</br>
This layer is responsible to connect with database

## Additional Packages:
### 1. DTO(Data Tranfer object):
<p>This package is responsible to bind the data that application recieves from the client. ex: it is responsible in transforming the JSON request into object</p>
The entire mapping is done at controller layer.</br>
There are two types of DTO:
<li>
Request DTO: It is responsible to map the request to the class object. JSON to Object
</li>
<li>
Response DTO: It is responsible to map the object data to response. Object to JSON
</li>

### 2. Utility:
<p>Contains all the helper classes and methods.</p>

### 3. Entity:
<p>It represents the database. example: for student table we have student class which is a direct representation of the data</p>

### 4. Configuration:
<p>It stores all the configuration/properties data. Generally stored in applications.properties file</p>