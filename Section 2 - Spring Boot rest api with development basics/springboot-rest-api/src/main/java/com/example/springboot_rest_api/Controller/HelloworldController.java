package com.example.springboot_rest_api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Writing a rest api
//@RestController = @Controller+@ResponseBody--Supported from spring 4
//@Controller- Saying it is Controller for Spring MVC
//@ResponseBody- Response Body return as JSON will be converted to HTTP Response Body and passed to client
@RestController
public class HelloworldController {

    //return String to the Client
    //http:localhost:8080/helloWorld
    @GetMapping("helloWorld")
    public String getHellowWorld(){
        return "HelloWorld";
    }
}
