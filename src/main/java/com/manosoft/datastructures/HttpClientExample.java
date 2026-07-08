package com.manosoft.datastructures;


import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class HttpClientExample {

    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/posts")).build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            List<Post> postList = Arrays.asList(objectMapper.readValue(response.body(), Post[].class));
//                    objectMapper.readValue(response.body(), objectMapper.getTypeFactory().constructCollectionType(List.class, Post.class));
            System.out.println(response.body());
            System.out.println(postList.get(0).title);

        } catch ( URISyntaxException | IOException | InterruptedException ex){
            System.out.println(ex);
        }
    }
}
class Post {
    long userId;
    long id;
    String title;
    String body;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}