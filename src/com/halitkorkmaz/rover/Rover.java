package com.halitkorkmaz.rover;

import com.halitkorkmaz.surface.Surface;
import com.halitkorkmaz.vehicle.Heading;
import com.halitkorkmaz.vehicle.abilities.IMovable;
import com.halitkorkmaz.vehicle.abilities.IRotatable;
import com.halitkorkmaz.vehicle.Vehicle;

public class Rover extends Vehicle implements IMovable, IRotatable {

    private Heading heading;

    public Rover(int x, int y, Heading heading, Surface surface) {
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.surface = surface;
    }

    public void status() {
        System.out.printf("%s %s %s%n", x, y, heading);
    }

    @Override
    public void move(int step) {
        if (this.heading == Heading.N) {
            int destinationY = this.y + step;
            if (canMove(this.x, destinationY)) {
                this.y = destinationY;
            }
        } else if (this.heading == Heading.E) {
            int destinationX = this.x + step;
            if (canMove(destinationX, this.y)) {
                this.x = destinationX;
            }
        } else if (this.heading == Heading.S) {
            int destinationY = this.y - step;
            if (canMove(this.x, destinationY)) {
                this.y = destinationY;
            }
        } else if (this.heading == Heading.W) {
            int destinationX = this.x - step;
            if (canMove(destinationX, this.y)) {
                this.x = destinationX;
            }
        } else {
            System.err.println("Cannot move because heading is unknown.");
        }
    }

    @Override
    public void rotate(int rotationDegree) {
        int trueDegree = (this.heading.getDegree() + rotationDegree);

        if (trueDegree < 0) {
            trueDegree += 360;
        }

        if (trueDegree >= 360) {
            trueDegree -= 360;
        }

        this.heading = Heading.findByDegree(trueDegree);
    }

    @Override
    public boolean canMove(int destinationX, int destinationY) {
        if (destinationX < 0 || destinationX > this.surface.getWidth()) {
            return false;
        } else if (destinationY < 0 || destinationY > this.surface.getHeight()) {
            return false;
        }

        boolean isRoverExistAtDestination = surface.getRoverList().stream()
                .anyMatch(rover -> rover.getX() == destinationX && rover.getY() == destinationY);

        return !isRoverExistAtDestination;
    }
}
