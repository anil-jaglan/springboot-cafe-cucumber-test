package io.microservices.cafe.domain;

import static java.util.Objects.isNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Coffee implements Comparable<Coffee> {

    @EqualsAndHashCode.Include
    private String name;

    @EqualsAndHashCode.Exclude
    private float price;

    @Override
    public int compareTo(Coffee o) {
        if (isNull(o)) {
            return 1;
        }
        if (isNull(this.name)) {
            return -1;
        }
        return this.name.compareToIgnoreCase(o.getName());
    }

}
