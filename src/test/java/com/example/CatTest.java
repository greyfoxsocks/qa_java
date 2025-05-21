package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void testGetSound() {
        Cat cat = new Cat(Mockito.mock(Feline.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(felineMock);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
