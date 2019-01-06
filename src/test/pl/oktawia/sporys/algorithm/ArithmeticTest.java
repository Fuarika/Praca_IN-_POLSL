package pl.oktawia.sporys.algorithm;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ArithmeticTest   {
    Arithmetic arithmetic;

    @BeforeEach
    void init(){
        arithmetic = new Arithmetic();
    }

    @Test
    void normalizeSolutionTest() {
        //given
        Double mantisa1 = 60.89;
        Integer exponant1 = 3;
        Double mantisa2 = 0.0012;
        Integer exponant2 = -2;

        //when
        String solution1 = arithmetic.normalizeSolution(mantisa1,exponant1);
        String solution2 = arithmetic.normalizeSolution(mantisa2,exponant2);

        //then
        assertTrue(solution1.equals("0.6089x10^5"));
        assertTrue(solution2.equals("0.12x10^-4"));
    }
}