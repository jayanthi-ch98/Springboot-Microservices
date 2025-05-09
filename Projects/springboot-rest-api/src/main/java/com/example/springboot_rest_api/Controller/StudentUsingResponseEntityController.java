package com.example.springboot_rest_api.Controller;

import com.example.springboot_rest_api.Beans.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//Base URL for all the Rest APIs
@RequestMapping("/studentResponseEntity")
public class StudentUsingResponseEntityController {


    //Returns Java Bean as JSON to client
    //http:localhost:8080/getStudentDetails
    //Spring Boot Rest API for HTTP Get request using ResponseEntity
    @GetMapping("studentResponseEntity/student")
    public ResponseEntity<Student> getStudentDetails(){
        Student s1=new Student(
                1,"Jayanthi","6th class"
        );
        return ResponseEntity.ok().header("customheader","jayanthi").header("customheader2","jayanthi2").body(s1);

    }
    //return studentList as json
    //http://localhost:8080/students
    //Spring Boot Rest API for HTTP Get request
    @GetMapping("studentResponseEntity/students")
    public ResponseEntity<List<Student>> getStudentList(){
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Ashok","10th class"));
        studentList.add(new Student(2,"jayanthi","6th class"));
        studentList.add(new Student(3,"Eswar","7th class"));
        HttpHeaders headers = new HttpHeaders();
        headers.set("customheader1","jayanthi1");
        headers.set("customheader2","jayanthi2");
        return new ResponseEntity<>(studentList,headers,HttpStatus.OK);
    }

    //SpringBoot RestAPI with path Variable
    //{id},{name},{class}->URI template variables
    //http://localhost:8080/student/1/jayanthi/4th class
    @GetMapping("studentResponseEntity/{id}/{name}/{class}")
    public ResponseEntity<Student> getStudentPathVariable(@PathVariable int id, @PathVariable("name") String Name, @PathVariable("class") String className){
        Student s1= new Student(id,Name,className);
        return ResponseEntity.ok(s1);
    }

    //Difference between @PathVariable and @RequestParam
    //@PathVariable---> To use the value URI template variables in the method
    //@RequestParam---> To fetch the values of Query parameters


    //SpringBoot RestAPI to handle multiple Query Params using @RequestParam
    //http://localhost:8080/student/query?id="value1"&name="value2"&className="value3"
    @GetMapping("studentResponseEntity/query")
    public ResponseEntity<Student> getStudentQueryParam(@RequestParam int id, @RequestParam String name, @RequestParam String className){
        Student s1= new Student(id,name,className);
        return ResponseEntity.ok(s1);
    }

    //@RequestBody--> Take the HTTP request Body and convert into Java class or Bean
    //SpringBoot RestAPI to use POST mapping -- To create new resource
    @PostMapping("studentResponseEntity/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        HttpHeaders headers = new HttpHeaders();
        headers.set("customheader1","jayanthi1");
        headers.set("customheader2","jayanthi2");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(student);
    }

    //SpringBoot rest API using PUT request
    //Put is used to update the existing resource
    @PutMapping("studentResponseEntity/update/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id){
        System.out.println(student.getStudentName());
        System.out.println(student.getRollno());
        System.out.println(student.getClass());
        return new Student(id,student.getStudentName(),student.getStudentClass());

    }
    //Spring boot rest api to delete the existing resource
    @DeleteMapping("studentResponseEntity/delete/{id}")
    public String deleteUser(@PathVariable("id") int StudentId){
        return "Resource Deleted Successfully:"+StudentId;
    }
}
