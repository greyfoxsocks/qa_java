
package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class LionParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testLionSex(String sex) throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, predatorMock);
        assertEquals(sex.equals("Самец"), lion.doesHaveMane());
    }
}