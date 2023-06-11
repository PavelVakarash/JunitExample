package de.ait;

public class MathOperations {
    // 7, 11, 31, 43
    // 169 -> 13
    public boolean isPrime(int number) {
        if (number == 0 || number == 1 || number < 0) {
            throw new IllegalArgumentException();
        }

        if (number == 2 || number == 3) {
            return true;
        }
        // 121 -> 2, 3, 4, 5, ..., 11
        // 31 -> 2, 3, 4, 5, 6, 7, ..., 30
        // i <= sqrt(number) -> i * i < number 9 sqrt(9) * sqrt(9) = 3 * 3 = 9
        // 31 -> 2,3,4,5
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int sum(int a, int b) {
        return a + b;
    }

}
