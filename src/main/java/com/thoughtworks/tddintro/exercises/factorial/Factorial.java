package com.thoughtworks.tddintro.exercises.factorial;

public class Factorial {

    public Integer compute(int i) {
        int factorial;

        if(i < 0) {
            throw new IllegalArgumentException();
        }
        else if(i == 0) {
            return 1;
        }

        factorial = compute(i-1) * i;

        return factorial;
    }
}
