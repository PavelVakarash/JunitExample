package de.ait;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class NotPrimeNumbersProvider implements ArgumentsProvider { // предоставляет числа, которые точно не простые

    private final static int NUMBERS_COUNT = 5;
    private final static int LOW = 2;
    private final static int HIGH = 100;

    private final static Random RANDOM = new Random();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        List<Arguments> arguments = new ArrayList<>();

        for (int i = 0; i < NUMBERS_COUNT; i++) {
            int first = LOW + RANDOM.nextInt(HIGH); // 2 ... 100
            int second = LOW + RANDOM.nextInt(HIGH); // 2 ... 100
            int notPrime = first * second;
            arguments.add(Arguments.of(notPrime));
        }
        return arguments.stream();
    }
}
