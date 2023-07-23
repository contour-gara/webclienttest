package com.example.webclienttest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostClientTest {

    @Autowired
    PostClient postClient;

    @Test
    void respnseok() {
        postClient.post("gara");
    }

    @Test
    void respnseng() {
        postClient.post("gr");
    }
}
