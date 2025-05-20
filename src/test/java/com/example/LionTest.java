package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @Test
    void testGetKittens() throws Exception {
        // Создаем мок Predator
        Predator predatorMock = Mockito.mock(Predator.class);
        Mockito.when(predatorMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(3, lion.getKittens());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testDoesHaveMane(String sex) throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, predatorMock);
        assertEquals(sex.equals("Самец"), lion.doesHaveMane());
    }

    @Test
    void testInvalidSex() {
        Predator predatorMock = Mockito.mock(Predator.class);
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестно", predatorMock)
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetFood() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Mockito.when(predatorMock.eatMeat()).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", predatorMock);
        assertEquals(List.of("Мясо"), lion.getFood());
    }
}