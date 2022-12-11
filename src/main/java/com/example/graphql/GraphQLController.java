package com.example.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class GraphQLController {

    @Autowired
    WebClient.Builder webClientBuilder;

    @Value("${category.service.url}")
    String CATEGORY_SERVICE_URL;

    @QueryMapping
    Flux<Category> getCategories(){
        return webClientBuilder.baseUrl(CATEGORY_SERVICE_URL).build()
                .get()
                .uri("/category/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Category.class).log();


    }

    @QueryMapping
    Mono<Category> getCategory(@Argument int id){
        return webClientBuilder.baseUrl(CATEGORY_SERVICE_URL).build()
                .get()
                .uri("/category/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Category.class).log();
    }
}
