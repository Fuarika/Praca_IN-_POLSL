package pl.oktawia.sporys.algorithm;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ArithmeticTest implements WithAssertions {
    Arithmetic arithmetic;

    @BeforeEach
    void init(){
        arithmetic = new Arithmetic();
    }

    @Test
    void getMantissaAndExponent() {
        //given
        String val1 = "60.89523";
        String val2 = "0.0000125";

        //when
        String solution1 = arithmetic.getMantissaAndExponent(val1);
        String solution2 = arithmetic.getMantissaAndExponent(val2);

        //then
        assertThat(solution1).isEqualTo("6.089523E1.0");
        assertThat(solution2).isEqualTo("1.25E-5.0");

        assertThat(solution1.split("E")[1]).isEqualTo("1.0"); //exponent 1
        assertThat(solution2.split("E")[1]).isEqualTo("-5.0"); //exponent 2

        assertThat(solution1.split("E")[0]).isEqualTo("6.089523"); //mantissa 1
        assertThat(solution2.split("E")[0]).isEqualTo("1.25"); //mantissa 2

    }

    @Test
    void test1() {
        double mantissa = 10.6342d;
        String string = Double.toString(mantissa);
        String[] stringVal = string.split("\\.");
        if (stringVal[0].length() > 1) {
            String[] decimal = stringVal[0].split("");
            String newDecimal = decimal[0];
            String rest = "";
            int exponant = 0;
            for (int i =1; i < decimal.length; i++) {
                rest += decimal[i];
                exponant = i;
            }
            String normalizedDown = newDecimal + "." + rest + stringVal[1] + " * 10 ^" + exponant;

            System.out.println(normalizedDown);
        }
    }
}