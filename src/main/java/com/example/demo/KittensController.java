package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class KittensController {

    @GetMapping("/kittens")
    public List<Kitten> getKittens(@RequestParam("age") Optional<Integer> age) {
        List<Kitten> kittens = Arrays.asList(new Kitten("Chocobo", 5),
                new Kitten("Paprika", 1));
        return kittens.stream()
                .filter(kitten -> !age.isPresent() || age.get() == kitten.getAge())
                .collect(Collectors.toList());
    }
}
