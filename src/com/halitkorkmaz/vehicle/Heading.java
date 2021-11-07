package com.halitkorkmaz.vehicle;

import java.util.Arrays;

public enum Heading {
    N(0), E(90), S(180), W(270);

    private final int degree;

    Heading(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return this.degree;
    }

    public static Heading findByDegree(int degree) {
        return Arrays.stream(Heading.values())
                .filter(x -> x.getDegree() == degree)
                .findFirst()
                .orElse(null);
    }
}
