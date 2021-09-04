package com.example.demo_mongodb.controller;

import com.example.demo_mongodb.entity.Posts;
import com.example.demo_mongodb.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping(path = "/get")
    public List<Posts> GetData() {

        return postsService.GetAllDatabaseData();
    }

}
