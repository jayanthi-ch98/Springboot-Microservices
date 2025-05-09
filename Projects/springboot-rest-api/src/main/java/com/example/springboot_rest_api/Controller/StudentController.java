package com.example.springboot_rest_api.Controller;

import com.example.springboot_rest_api.Beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//@RestController = @Controller+@ResponseBody--Supported from spring 4
//@Controller- Saying it is Controller for Spring MVC
//@ResponseBody- Response Body return as JSON will be converted to HTTP Response Body and passed to client
@RestController
public class StudentController {

    //Returns Java Bean as JSON to client
    //http:localhost:8080/getStudentDetails
    //Spring Boot Rest API for HTTP Get request
    @GetMapping("getStudentDetails")
    public Student getStudentDetails(){
        Student s1=new Student(
                1,"Jayanthi","6th class"
        );
        return s1;
    }
//return studentList as json
    //http://localhost:8080/students
    //Spring Boot Rest API for HTTP Get request
    @GetMapping("students")
    public List<Student> getStudentList(){
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Ashok","10th class"));
        studentList.add(new Student(2,"jayanthi","6th class"));
        studentList.add(new Student(3,"Eswar","7th class"));
        return studentList;
    }

    //SpringBoot RestAPI with path Variable
    //{id},{name},{class}->URI template variables
    //http://localhost:8080/student/1/jayanthi/4th class
    @GetMapping("student/{id}/{name}/{class}")
    public Student getStudentPathVariable(@PathVariable int id, @PathVariable("name") String Name, @PathVariable("class") String className){
        return new Student(id,Name,className);
    }

    //Difference between @PathVariable and @RequestParam
    //@PathVariable---> To use the value URI template variables in the method
    //@RequestParam---> To fetch the values of Query parameters


    //SpringBoot RestAPI to handle multiple Query Params using @RequestParam
    //http://localhost:8080/student/query?id="value1"&name="value2"&className="value3"
    @GetMapping("student/query")
    public Student getStudentQueryParam(@RequestParam int id, @RequestParam String name, @RequestParam String className){
        return new Student(id,name,className);
    }

    //@RequestBody--> Take the HTTP request Body and convert into Java class or Bean
    //SpringBoot RestAPI to use POST mapping -- To create new resource
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.toString());
        return student;
    }

    //SpringBoot rest API using PUT request
    //Put is used to update the existing resource
    @PutMapping("students/update/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id){
        System.out.println(student.getStudentName());
        System.out.println(student.getRollno());
        System.out.println(student.getClass());
        return new Student(id,student.getStudentName(),student.getStudentClass());

    }
    //Spring boot rest api to delete the existing resource
    @DeleteMapping("students/delete/{id}")
    public String deleteUser(@PathVariable("id") int StudentId){
        return "Resource Deleted Successfully:"+StudentId;
    }
}
