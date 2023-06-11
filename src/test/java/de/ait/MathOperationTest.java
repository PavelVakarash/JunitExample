package de.ait;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MathOperation is working")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MathOperationTest {
    private MathOperations mathOperations;

    @BeforeEach
    public void setUp() {
        this.mathOperations = new MathOperations();
    }

    @DisplayName("isPrime() is working")
    @Nested
    class IsPrime {
        @ParameterizedTest(name = "return <true> on {0}")
        @ValueSource(ints = {2, 3, 17, 31, 41, 13})
        public void on_primes_number(int primeNumber) {
            assertTrue(mathOperations.isPrime(primeNumber));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ValueSource(ints = {121, 169})
        public void on_sqr_number(int sqrNumber) {
            assertFalse(mathOperations.isPrime(sqrNumber));
        }

        @ParameterizedTest(name = "throws exceptions on {0}")
        @ValueSource(ints = {-1, 0, 1})
        public void on_problems_numbers(int problemNumber) {
            assertThrows(IllegalArgumentException.class,
                    () -> mathOperations.isPrime(problemNumber));
        }

        @ParameterizedTest(name = "return <false> on {0}")
        @ArgumentsSource(value = NotPrimeNumbersProvider.class)
        public void on_not_prime_numbers(int notPrimeNumber) {
            assertFalse(mathOperations.isPrime(notPrimeNumber));
        }
    }

    @DisplayName("sum() is working")
    @Nested
    class Sum {
        @ParameterizedTest(name = "correct: {0} + {1} = {2}")
        @CsvSource(value = {"3, 5, 8",
                "4, 2, 6",
                "7, 2, 9"})
        public void on_sum(int a, int b, int result) {
            assertEquals(result, mathOperations.sum(a, b));
        }

        @ParameterizedTest(name = "correct: {0} + {1} = {2}")
        @CsvFileSource(resources = "/sum.csv")
        public void on_sum_from_files(int a, int b, int result) {
            assertEquals(result, mathOperations.sum(a, b));
        }
    }

}