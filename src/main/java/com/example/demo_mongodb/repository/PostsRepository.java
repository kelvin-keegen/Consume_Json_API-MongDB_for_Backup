package com.example.demo_mongodb.repository;

import com.example.demo_mongodb.entity.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostsRepository extends MongoRepository<Posts,Long> {

    Optional<Posts> findById(Long id);

}
