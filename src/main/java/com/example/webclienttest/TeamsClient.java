package com.example.webclienttest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class TeamsClient {
    private final WebClient webClient;

    public TeamsClient() {
        this.webClient = WebClient.builder().baseUrl("https://imhds.webhook.office.com").build();
    }

    public void post(String message) {
        webClient.post().uri("/webhookb2/330c37c3-49d8-45f7-b368-2ed125deb105@2a2132f5-86e3-409b-8f41-795be9d4365c/IncomingWebhook/93c074c8698549f798951140f73d617e/cb022238-d2a7-4a71-8fda-142469917c4e").contentType(MediaType.APPLICATION_JSON).bodyValue(Map.of("text1", message)).retrieve().bodyToMono(String.class).block();
    }
}