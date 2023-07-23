package com.example.webclienttest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class MainController {

    @PostMapping("/index")
    @ResponseBody
    public Syain output1(
            @RequestBody @Validated Syain syain) {
//        System.out.println(syain.getBangou());
        System.out.println(syain.getName());
        return syain;
    }
}