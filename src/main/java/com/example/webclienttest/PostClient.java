package com.example.webclienttest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Component
public class PostClient {
    private final WebClient webClient;

    public PostClient() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8765").build();
    }

    public void post(String name) {
//        webClient.post().uri("/test1/index").contentType(MediaType.APPLICATION_JSON).bodyValue(Map.of("name", name)).retrieve().bodyToMono(String.class).block();

        Mono<ResponseEntity<String>> responseEntityMono = webClient.post().uri("/test1/index").contentType(MediaType.APPLICATION_JSON).bodyValue(Map.of("name", name)).retrieve().toEntity(String.class);
        ResponseEntity<String> responseEntity = responseEntityMono.block();
//        System.out.println(responseEntityMono);
        log.info("status={}", responseEntity.getStatusCode());
    }
}
