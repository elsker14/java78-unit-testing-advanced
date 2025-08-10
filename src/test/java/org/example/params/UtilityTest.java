package org.example.params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

// assertThat(actual).<verify>(expected),
// verify = orice clauza de validare (equals, true, false, empty etc)

class UtilityTest {

    @ParameterizedTest  // -> needs test data source
    @ValueSource(ints = {1, 3, 5, 7, 9, -33, -21, 6})
    void test_IsOdd_happy_path(int number) {
        assertThat(Utility.isOdd(number))
                .withFailMessage("Numarul trebuie sa fie impar!")
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.3, 2.5, 2.0, -2.3, -22.12})
    void test_roundDouble(Double input) {
        double expected = Math.round(input);    // rotujeste la integer -> 2, 3, 2, -2, -22
        assertThat(Utility.roundDouble(input))
                .isEqualTo(expected);
    }

    // todo: modify to check String vs String
    @ParameterizedTest
    @ValueSource(strings = {"121", "madam", "apa", "Ana", "hello"})
    void test_isPalindrome(String input) {
        String expected = new StringBuilder(input).reverse().toString();
        assertThat(Utility.isPalindrome(input))
                .isEqualTo(expected.equalsIgnoreCase(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"   test  ;TEST", "tEST;TEST", "  Java;JAVA"}, delimiter = ';')
    void test_Uppercase(String input, String expected) {
        assertThat(Utility.toUpperCase(input))
                .isEqualTo(expected);
    }
}