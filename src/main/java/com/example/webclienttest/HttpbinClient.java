package com.example.webclienttest;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponse;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Component
public class HttpbinClient {
    private final WebClient webClient;

    public HttpbinClient() {
        this.webClient = WebClient.builder().baseUrl("http://httpbin.org").build();
    }

    public void post(String name, String status) {
//        Mono<ResponseEntity<String>> responseEntityMono = webClient.post().uri("/status/" + status).contentType(MediaType.APPLICATION_JSON).bodyValue(Map.of("name", name)).retrieve().toEntity(String.class);
//        ResponseEntity<String> responseEntity = responseEntityMono.block();
//        log.info("status={}", responseEntity.getStatusCode());
        webClient.post().uri("/status/" + status).contentType(MediaType.APPLICATION_JSON).bodyValue(Map.of("name", name)).retrieve().onStatus(s -> s.equals(HttpStatus.BAD_REQUEST), (e) -> e.bodyToMono(ErrorResponse.class).handle((body, handler) -> {
            LoggerFactory.getLogger(getClass()).warn("HTTP 400 returned: {}", body);
            handler.error(new BusinessLogicException());
        })).toBodilessEntity().block();
    }

    private static class BusinessLogicException extends Exception {
    }

    private record ErrorResponse(String type, String title, long status, String detail) {
    }

}
