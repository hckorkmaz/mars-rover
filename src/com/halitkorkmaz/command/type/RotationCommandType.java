package com.halitkorkmaz.command.type;

import java.util.Arrays;

public enum RotationCommandType {
    L(-90), R(90);

    private final int rotationDegree;

    RotationCommandType(int rotationDegree) {
        this.rotationDegree = rotationDegree;
    }

    public int getRotationDegree() {
        return this.rotationDegree;
    }

    public static RotationCommandType findByName(String name) {
        return Arrays.stream(RotationCommandType.values())
                .filter(x -> x.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
