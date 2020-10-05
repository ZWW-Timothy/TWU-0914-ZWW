package com.twu.refactoring;

import java.util.function.Predicate;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    private int countExtend(Predicate<Integer> predicate) {
        int count = 0;
        for (int num : numbers) {
            if (predicate.test(num)) {
                count++;
            }
        }
        return count;
    }

    public int countEven() {
        return countExtend((number) -> number % 2 == 0);
    }

    public int countOdd() {
        return countExtend((number) -> number % 2 == 1);
    }

    public int countPositive() {
        return countExtend((number) -> number >= 0);
    }

    public int countNegative() {
        return countExtend((number) -> number < 0);
    }

}
