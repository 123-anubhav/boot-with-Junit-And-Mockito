# boot-with-Junit-And-Mockito
spring boot with Junit And Mockito example

# Mockito Testing Explanation and README

This document provides an explanation of the provided Spring Boot code using JUnit and Mockito for testing, followed by a README.md template for your project.

---

## **Spring Boot Code Explanation**

### **1. RestController Class**
This class is a Spring REST controller that handles HTTP requests.

```java
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private MessageService msgService;

    @GetMapping("/greet")
    public ResponseEntity greetMessage() {
        String response = msgService.getMessage();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
```

- **@RestController**: Marks the class as a REST controller to handle web requests.
- **@Autowired**: Injects the `MessageService` dependency.
- **@GetMapping("/greet")**: Maps HTTP GET requests to the `greetMessage()` method.
- **ResponseEntity**: Represents the HTTP response, including status code and body.

### **2. MessageService Class**
This service class contains business logic.

```java
@Service
public class MessageService {
    public String getMessage() {
        return "Welcome anubhav srivastava ..!!";
    }
}
```

- **@Service**: Marks the class as a Spring service.
- **getMessage()**: Returns a greeting message.

---

## **JUnit and Mockito Testing Explanation**

```java
@WebMvcTest(value = RestController.class)
public class RestControllerTest {

    @MockBean
    private MessageService msgService;

    private MockMvc mockMvc;

    public void greetMessageTest() throws Exception {
        when(msgService.getMessage()).thenReturn("good morning anubhav");
        MockHttpServletRequestBuilder mvcBuilder = MockMvcRequestBuilders.get("/greet");
        MvcResult mvcResult = mockMvc.perform(mvcBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int actualMockResponseStatus = response.getStatus();
        assertEquals(200, actualMockResponseStatus);
    }
}
```

- **@WebMvcTest**: Focuses only on the `RestController` layer.
- **@MockBean**: Creates a mock instance of `MessageService`.
- **MockMvc**: Simulates HTTP requests.
- **when()**: Defines behavior of the mock object.
- **MockHttpServletRequestBuilder**: Builds the HTTP GET request.
- **mockMvc.perform()**: Executes the request.
- **MvcResult**: Stores the result of the request.
- **MockHttpServletResponse**: Represents the HTTP response.
- **assertEquals()**: Compares expected and actual values.

---

## **README.md Template**

```md
# Spring Boot REST API with JUnit and Mockito Testing

This project demonstrates a Spring Boot REST API with JUnit and Mockito for unit testing.

## **Project Structure**
- `in.anubhav.rest.RestController` - Handles HTTP requests.
- `in.anubhav.service.MessageService` - Contains business logic.
- `in.anubhav.rest.RestControllerTest` - Contains unit tests using JUnit and Mockito.

## **Technologies Used**
- Java
- Spring Boot
- JUnit 5
- Mockito

## **Setup Instructions**
1. Clone the repository.
2. Import the project into your IDE.
3. Run the tests using `mvn test`.

## **Testing Details**
- **@WebMvcTest**: Tests only the web layer.
- **@MockBean**: Mocks the service layer.
- **MockMvc**: Mocks HTTP requests and responses.

## **Example Test**
```java
when(msgService.getMessage()).thenReturn("good morning anubhav");
MockMvcRequestBuilders.get("/greet");
assertEquals(200, response.getStatus());
```

## **Contributing**
Pull requests are welcome!

## **License**
This project is open-source under the MIT license.
```

