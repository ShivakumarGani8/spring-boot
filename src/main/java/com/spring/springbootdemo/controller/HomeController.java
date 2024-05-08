package com.spring.springbootdemo.controller;

import com.spring.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setId("1");
        user.setName("Shivakuamr");
        user.setEmail("shivakumar@gmail.com");

        return user;
    }

    @GetMapping("{id}/{name}")
    public String pathVariables(@PathVariable String id, @PathVariable String name){
        return "The path variable id is : "+ id +" Name is : "+ name;
    }

    @GetMapping("/")
    public String requestParameters(@RequestParam String id, @RequestParam(required=false,defaultValue = "") String email){
        return "The request parameter variable id is : "+id+ " Email : "+email;
    }
}
