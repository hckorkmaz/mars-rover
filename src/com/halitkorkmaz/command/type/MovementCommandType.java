package com.halitkorkmaz.command.type;

import java.util.Arrays;

public enum MovementCommandType {
    M(1);

    private final int step;

    MovementCommandType(int step) {
        this.step = step;
    }

    public int getMovementStep() {
        return this.step;
    }


    public static MovementCommandType findByName(String name) {
        return Arrays.stream(MovementCommandType.values())
                .filter(x -> x.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
