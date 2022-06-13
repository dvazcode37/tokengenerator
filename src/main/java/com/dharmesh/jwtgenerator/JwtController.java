package com.dharmesh.jwtgenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @GetMapping("/")
    public String index() {
        return "Yo! from Spring Boot!";
    }

    @GetMapping("/getjwt")
}
