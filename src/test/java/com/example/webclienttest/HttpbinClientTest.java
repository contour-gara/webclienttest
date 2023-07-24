package com.example.webclienttest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HttpbinClientTest {
    @Autowired
    HttpbinClient httpbinClient;

    @Test
    void response200() {
        httpbinClient.post("gara", "200");
    }

    @Test
    void response400() {
        httpbinClient.post("gara", "400");
    }

}
