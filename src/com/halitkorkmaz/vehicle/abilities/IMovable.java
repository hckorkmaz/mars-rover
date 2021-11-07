package com.halitkorkmaz.vehicle.abilities;

public interface IMovable {

    boolean canMove(int destinationX, int destinationY);

    void move(int step);

}
