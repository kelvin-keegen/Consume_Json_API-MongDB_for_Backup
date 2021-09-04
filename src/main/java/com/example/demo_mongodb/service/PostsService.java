package com.example.demo_mongodb.service;

import com.example.demo_mongodb.entity.Posts;
import com.example.demo_mongodb.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    public List<Posts> GetAllDatabaseData() {

        return postsRepository.findAll();
    }
}
