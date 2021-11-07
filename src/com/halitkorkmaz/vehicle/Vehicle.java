package com.halitkorkmaz.vehicle;

import com.halitkorkmaz.surface.Surface;

public abstract class Vehicle {

    protected int x;
    protected int y;
    protected Surface surface;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
