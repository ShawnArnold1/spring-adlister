package com.codeup.adlister.controllers;

import com.codeup.adlister.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Portfolio
{
    private final PostRepository postDao;


    public Portfolio(PostRepository postDao)
    {
        this.postDao = postDao;
    }


    @GetMapping("/portfolio")
    public String showPortfolio()
    {
        return "portfolio/index";
    }



}
