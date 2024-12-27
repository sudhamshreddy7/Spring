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


# getting_started_with_spring follows the above layered archtecture
to test the application just run athe application and hit this link http://localhost:8080/payments/100

# Maven
<b>What is Maven?</b>

1. It is project management tool. Which developers is:</br>
<b>Build generation</br>
Dependency resolution</br>
Documentation</br></b>
2. Maven uses POM(Project Object Model) to achieve the above
3. Every POM contains parent POM. If there is no parent POM then by default inherits Super POM(which is like Object class in Java).

## Maven Build cycle:

<img width="1346" alt="image" src="https://github.com/user-attachments/assets/750d1b3f-c751-44b7-b516-3003d0b06e3b" />


# Controller

![image](https://github.com/user-attachments/assets/66ad0b38-3530-4d08-a9bc-7f1e49105d07)

@RestController and @Controller does the same thing.</br>
@RestController eleminates a lot of boiler code such as @ResponseBody</br> 
@RestController = @Controller + @ResponseBody</br>
<b>@ResponseBody 
### 1. @Controller:
<p>
It handles incoming HTTP requests.
</p>

### 2. RequestParam:
<img width="1193" alt="Screenshot 2024-12-26 at 1 58 27 PM" src="https://github.com/user-attachments/assets/a422c8ac-2511-4b91-9f1b-12d55fbd5517" />

<p> It is used to tag the parameters to the variables.
By default required is set to true.</p>
To test run the application and the below url</br>

http://localhost:8080/payments/100?client=sudhamsh

<p>By Default Spring typecast the parameters into data types such as int, float, boolean ,String ,etc but to convert the parameter into custom data(date) you need to use propertyEditor.  </p>
<p>to do such preprocessing we use intiBinder to preprocess the input data </p>

### 3. PathVariable:
<p>Pathvariables are similar to Parameters  </p>
<ul>
    <li>Example of path parameter is /api?id=123. Here id is Path parameter and 123 is its value.</li>
    <li>example of path variable is /api/fetchData/123. Here 123 is path variable </li>
</ul>
<img width="899" alt="Screenshot 2024-12-26 at 2 54 38 PM" src="https://github.com/user-attachments/assets/8543a088-c029-4ed8-b53c-8e60dd29bf51" />


# Bean
<p>A bean is nothing but a java object whose life cycle is maintained by Spring Container(IOC inversion of Controller)</p>
There are two different ways to create a bean.
<ol>
<li>
<b>@Component:</b>
<p>Annotations such as @Controller, @Service uses @Component to create Beans</p>
Other Annotations which uses @Component are @Repository,@RequestMapping,@PutMapping,@GetMapping etc.  

</li>
<b>@Bean:</b>
<p>@Bean is similar to @Component but with @bean you can configure the object. such as creating user defined constructor and you can also declare its life cycle(singleton,session,etc).</p>
</ol>
