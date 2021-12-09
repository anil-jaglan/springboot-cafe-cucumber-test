package io.microservices.cafe.kitchen;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import io.microservices.cafe.domain.Coffee;
import io.microservices.cafe.exceptions.NotFoundException;
import lombok.NonNull;

@Service
public class CoffeeMachine {

    private Map<String, Coffee> beverages = new ConcurrentHashMap<>();

    public void addBeverage(@NonNull final Coffee coffee) {
        beverages.put(coffee.getName(), coffee);
    }

    public Coffee dispenseBeverage(@NonNull final String name) {
        if (beverages.containsKey(name)) {
            return beverages.get(name);
        }   
        throw new NotFoundException(String.format("No such beverage [%s] to serve at the moment.", name));
    }

}
