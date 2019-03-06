package com.codeup.adlister.controllers;

import com.codeup.adlister.models.PostRepository;
import com.codeup.adlister.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.adlister.services.EmailService;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController
{

    private final EmailService emailservice;
    private final PostRepository postDao;



    public PostController(PostRepository postDao, EmailService emailService)
    {
        this.postDao = postDao;
        this.emailservice = emailService;
    }



    @GetMapping("/posts")
    public String posts(Model model)
    {
//        List<Post> posts = new ArrayList<>();
//        posts.add(new Post(2, "KillShot", "BOOGABOOGABOOGA"));
//        posts.add(new Post(3, "Yeff", "My name is yeff"));
//        model.addAttribute("posts", posts);
//        return "posts/index";

        Iterable<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";

    }

    @GetMapping("/posts/{id}")
    public String postID(@PathVariable long id, Model model)
    {
       Post post = postDao.findOne(id);
       model.addAttribute("post", post);
       return "posts/show";

    }

    @GetMapping("/posts/create")
    public String postCreate(Model model)
    {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postsCreate(@ModelAttribute Post post)
    {

        postDao.save(post);
        emailservice.prepareAndSend("email@email.com", "New Post", "Lets try this out");
        return "redirect:/posts";
    }

//    @GetMapping
//    public String edit(@PathVariable long id, Model model)
//    {
//
//    }

    @PostMapping("/posts/edit/{id}")
    public String editPost
            (
                    @PathVariable long id,
                    @RequestParam(name = "title") String title,
                    @RequestParam(name = "body") String body
            )
    {
        Post post = postDao.findOne(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";

    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model)
    {
        Post post = postDao.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";

    }

//    @GetMapping("/posts/edit/{id}")
//    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body)
//    {
//
//
//    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id)
    {
        Post post = postDao.findOne(id);
        postDao.delete(post);
        return "redirect:/posts";
    }




}
