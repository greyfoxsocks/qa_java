package com.example;

import java.util.List;

public class Lion {
    private final boolean hasMane;
    private final Predator predator;
    private final Feline feline;

    public Lion(String sex, Predator predator, Feline feline) throws Exception {
        this.predator = predator;
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens(); // Используем метод из Feline
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat(); // Используем метод из Predator
    }
}
