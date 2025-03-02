package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, my name is " + this.name);
    }
}

