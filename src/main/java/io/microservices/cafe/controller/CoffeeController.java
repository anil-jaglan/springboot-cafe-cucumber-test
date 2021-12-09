package io.microservices.cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservices.cafe.domain.Coffee;
import io.microservices.cafe.kitchen.CoffeeMachine;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/coffees")
@Slf4j
public class CoffeeController {

    @Autowired
    private CoffeeMachine coffeeMachine;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addCoffee(@RequestBody Coffee coffee) {
        coffeeMachine.addBeverage(coffee);
        return "OK";
    }

    @GetMapping(value = "/{coffee}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee getCoffee(@PathVariable("coffee") String coffee) {
        log.info("Serving coffee: {}", coffee);
        // return "Here is your "+coffee;
        return coffeeMachine.dispenseBeverage(coffee);
    }

}
