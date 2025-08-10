package org.example.params;

import java.util.function.Function;

public enum TemperatureConverter {
    CELSIUS_KELVIN(it -> it + 273.15f),
    KELVIN_CELSIUS(it -> it - 273.15f),
    CELSIUS_FAHRENHEIT(it -> it * 9 / 5f + 32);

    private Function<Float, Float> converter;

    TemperatureConverter(Function<Float, Float> converter) {
        this.converter = converter;
    }

    public float convertTemp(float temp) {
        return this.converter.apply(temp);
    }
}
