package com.example.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class KittenController {

    private final RestTemplate restTemplate;

    public KittenController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/kitten-names")
    public List<String> getNames() {
        return Arrays.stream(restTemplate.getForObject("http://localhost:8080/kittens", Kitten[].class))
                .map(Kitten::getName)
                .collect(toList());
    }
}
