package com.codeup.adlister.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController
{
    @GetMapping("/hello/{name}/{age}")
    @ResponseBody
    public String hello(@PathVariable String name, @PathVariable int age)
    {
        return "Hello from " + name + " age: " + age;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello()
    {
        return "Hello from Spring!";
    }


    @PostMapping("/hello")
    @ResponseBody
    public String getPassword(@RequestAttribute(name = "password") String pass)
    {
        return "123 " + pass + " asdfasdf";
    }


    @GetMapping("/test")
    @ResponseBody
    public List<String> getList()
    {
        List<String> names = new ArrayList<>();
        names.add("shawn");
        names.add("tristy");
        names.add("devin");
        names.add("Aziz");
        return names;
    }





}
