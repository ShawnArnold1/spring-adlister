package com.codeup.adlister.models;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post
{
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 150)
    private String body;

    @OneToOne
    private User owner;

    public Post(String title, String body)
    {
        this.title = title;
        this.body = body;
    }


    public Post()
    {
    }

    public Post(Long id, String title, String body)
    {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getId()
    {
        return id;
    }

    public String getBody()
    {
        return body;
    }



    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public void setId(long id)
    {
        this.id = id;
    }


}
