package com.example.javaspring.Controller;

import com.example.javaspring.Student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @GetMapping(path = "/student")
    public Student student(){
        return new Student("11","1","1","1",1);
    }

    @PostMapping(path = "/student")
    public String poststudent(){
        return "hello";
    }

    @GetMapping(path = "/hello")
    public String sayhello(){
        return "Hello Word";
    }
}
