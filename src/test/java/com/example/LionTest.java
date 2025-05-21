package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @Test
    void testGetKittens() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", Mockito.mock(Predator.class), feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testInvalidSex() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестно", Mockito.mock(Predator.class), Mockito.mock(Feline.class))
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetFood() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Mockito.when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", predatorMock, new Feline());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}