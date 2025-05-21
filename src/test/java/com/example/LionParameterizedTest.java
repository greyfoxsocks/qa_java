package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class LionParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testDoesHaveMane(String sex) throws Exception {
        Lion lion = new Lion(sex, Mockito.mock(Feline.class));
        assertEquals("Самец".equals(sex), lion.doesHaveMane());
    }
}