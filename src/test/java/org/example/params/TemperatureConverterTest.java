package org.example.params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

/*
    Slabiciune: enum source foloseste ca date de test, OBIECTELE ENUMERATIEI, si nu
    valori hardcodate
 */

class TemperatureConverterTest {

    @ParameterizedTest
    @EnumSource(
            value = TemperatureConverter.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = {"KELVIN_CELSIUS"}
    )
    void test_tempShouldBePositive(TemperatureConverter input) {
        assertThat(input.convertTemp(10))
                .isPositive();
    }

}