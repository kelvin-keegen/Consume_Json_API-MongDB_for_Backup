package com.example.demo_mongodb.config;

import com.example.demo_mongodb.entity.Posts;
import com.example.demo_mongodb.repository.PostsRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.HttpComponentsClientHttpConnector;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Configuration
@AllArgsConstructor
public class PostsReturn {

    private final PostsRepository postsRepository;
    private static final String Link = "https://jsonplaceholder.typicode.com/posts";

    @Bean
    public void DataConfig() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(Link))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Running");

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Posts>> reference = new TypeReference<List<Posts>>() {};

        List<Posts> postsList = objectMapper.readValue(response.body(),reference);

        long datalength = postsRepository.count();

        System.out.println("sum of data entries in database " + datalength);

        if (datalength > 0) {
            System.out.println("There is data already in the database");
        } else {
            postsRepository.saveAll(postsList);
        }

    }

}
