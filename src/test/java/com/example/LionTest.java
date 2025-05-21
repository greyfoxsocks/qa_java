package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LionTest {

    @Test
    void testGetKittens() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void testInvalidSex() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестно", Mockito.mock(Feline.class))
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}