package com.codeup.adlister.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController
{
    @GetMapping("/posts")
    @ResponseBody
    public String posts()
    {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postID(@PathVariable int id)
    {
       return "User " + id + " view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreate()
    {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreate(@RequestParam(name = "post") String post)
    {
        return post;

    }
}
