package org.example.params;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.ParameterDeclarations;

import java.util.stream.Stream;

public class PrimeNumbersArgsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ParameterDeclarations parameters, ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(13, true),
                Arguments.of(6, false),
                Arguments.of(-12, false),
                Arguments.of(-7, false)
        );
    }
}
