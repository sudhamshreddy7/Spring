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
The entire mapping is done at controller layer.<br>
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
To test run the application and the below url<br>

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
@Component:<br>
</li>
<p>Annotations such as @Controller, @Service uses @Component to create Beans</p>
Other Annotations which uses @Component are @Repository,@RequestMapping,@PutMapping,@GetMapping etc.<br>
To assign or bind a bean to a variable we use @Autowired<br>
<img width="284" alt="Screenshot 2024-12-27 at 5 56 36 PM" src="https://github.com/user-attachments/assets/c00488d0-229f-42de-b56a-3397a28fabc7" />



<li>
@Bean:<br>
</li>
<p>@Bean is similar to @Component but with @bean you can configure the object. such as creating user defined constructor and you can also declare its life cycle(singleton,session,etc).</p>
To create a Bean we use @Configuration and @Bean and we use @Autowired to bind the bean.<br>
<img width="335" alt="Screenshot 2024-12-27 at 6 02 34 PM" src="https://github.com/user-attachments/assets/7761691f-2cba-498a-9c81-1678d6746b0f" />
</ol>

The Spring finds Beans using @ComponentScan which is inherited by @SpringBootApplication which is starting point of the application and the other way is @Configuration.<br>
## LifeCycle of a Bean:
1. Application Start: It invokes the IOC(Inversion of Controller) which is responsible in maintaining the Bean.
2. IOC Container Started: It checks for all the @Bean and @Component annotations and scope is declared in @ComponentScan.
3. Construct the Bean: Before creating the bean the spring framework checks for the dependencies and creates the bean.
4. Dependency injection into constructed Bean: after creating the bean if there are any dependency beans it creates them and injects them into the bean.
5. @PostConstruct: This annotation is used to run post construction method after creating the bean. example initializing a map or making a connection to DB etc. for syntax open User class 
6. Use the bean: created beans are used.
7. @PreDestroy: This annotation is used to run at the time of destroying the bean. Beans are destroyed when you close the IOC. example inserting data into logs, closing db connection etc.
8. Bean destroy: the bean is Destroyed.<br>
<img width="360" alt="Screenshot 2024-12-27 at 7 16 42 PM" src="https://github.com/user-attachments/assets/ece72b27-02fc-453a-ac2a-02941b15953d" />

## Dependency Injection:
<p>It helps to make application loosely coupled and helps to avoid Dependency inversion. for example see class User</p><br>
<i>Disadvantage of dependency injection are:</i><br>=

1. You cannot make variables immutable. i.e, you cannot use final keyword along with @Autowired
2. May create null pointer exception. example: When user tries to create object of a component it doesn't do dependency injection which may lead to null pointer exception.<br>
## types of dependency injection:
1. field injection (dependency injection is done at the field level)
2. Setter injection (dependency injection is done at method level we pass the parameter)
3. Constructor injection (dependency injection is done at constructor level. you can create immutable objects.)

## Disadvantages of dependency injection:
1. Circular dependency may occur.

# Scope of a Bean:
1. SingleTon
2. Prototype
3. Request
4. Session
5. Application

## SingleTon:
1. it is the default scope.
2. Only 1 instance per IOC
3. Eagerly initialized by the IOC
## Prototype:
1. it is created when it is required(lazy initialization).
2. to declare a component/bean as prototype we use @Scope("prototype") or @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) both are the same
## Request:
1. New object is created for each HTTP request(lazy initialized).
2. to declare a component/bean as Request we use @Scope("Request")
3. When a singleton bean depends on request bean it throws an error. to avoid this we use @Scope(value="request" , proxyMode = ScopedProxyMode.TARGET_CLASS) this will create a proxy object for thw mean while.
## Session:
1. New object is created for each HTTP session. similar to request. 

# @ConditionalOnProperty:
1. Beans are created based on a condition. Similar to conditional statement.
2. Example:<br>
   <img width="623" alt="Screenshot 2024-12-30 at 3 44 59 PM" src="https://github.com/user-attachments/assets/ae749210-e83c-485d-a7b0-010586a08e22" /><br>
   <img width="686" alt="Screenshot 2024-12-30 at 3 45 13 PM" src="https://github.com/user-attachments/assets/81e499cd-0a84-40b5-b3fb-0fec2a93d75d" /><br>
   <img width="877" alt="Screenshot 2024-12-30 at 3 45 22 PM" src="https://github.com/user-attachments/assets/f76e4ce6-e433-44ae-9713-0ab76310e859" /><br>
   <img width="821" alt="Screenshot 2024-12-30 at 3 45 29 PM" src="https://github.com/user-attachments/assets/733e1a54-8bca-4a28-82cd-1f98e30752c1" /><br>
3. Output:<br>
   <img width="336" alt="Screenshot 2024-12-30 at 3 49 10 PM" src="https://github.com/user-attachments/assets/dd691115-8515-4cb0-9fda-c39dfb51f077" /><br>
4. As you can see the new_york object is created not the florida.
5. Advantage: avoiding unwanted generation, unable toggling feature, Saves memory, Faster start time.
6. Disadvantages: Misconfiguration may happen, May increase the complexity

# Profile:
1. It is used to maintain multiple profile properties such as QA, Dev and prod.
2. Using spring.profile.active property you can use different properties for different profiles.
3. We can declare the profile at the time of run dynamically using mvn spring:boot -Dspring-boot.run.profile-prod or you can declare in application.property file
4. Or you can choose in POM.xml file.(this is preferred)
5. @Profile("env") annotation is used to create a bean in a particular environment.
6. You use multiple profiles at any given time but the last selected profile is selected.

# Aspect Oriented Programming(AOP):
1. It helps to perform some tasks before and after the method call
2. Helps in logging, Transaction Management, Security.
3. Helps in avoiding the boiler code and increases the reusability of the code.
4. To use AOP you need to have below dependency in you pom.xml
```bash
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
5. To use AOP we use @Aspect(at the class level) and that class contains @Before/After("@execution{path to method/class/package}") and use can use wild cards to.
6. You can use @within in-place of @execution to run the method within project level such as it can run across all method in @Service/@Component etc
7. You can also @annotation it matches every method which has a particular annotation.
8. @Before("args(String,int)") it run whenever a methods arguments matches the mentioned arguments.
9. @Before("@args(org.Springframework.stereotype.Service)") it run whenever a method has arguments and the argument has an matching annotation.
10. @Before("target({class/interface_path})") the method gets invoked whenever you use the class/interface object.
11. You add use multiple pointers such as @execution/@within, using && , || keywords similar to any boolean operation.
12. @Pointcut("{pointer}({path})") is used to give custom name to a annotation which you to reduce the boiler code by eleminating the long pointer and path. 