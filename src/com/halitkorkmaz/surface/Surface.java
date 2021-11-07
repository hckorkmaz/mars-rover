package com.halitkorkmaz.surface;

import com.halitkorkmaz.rover.Rover;

import java.util.ArrayList;
import java.util.List;

public abstract class Surface {

    protected int width;

    protected int height;

    protected List<Rover> roverList;

    protected Rover activeRover;

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public List<Rover> getRoverList() {
        return roverList;
    }

    public void addVehicle(Rover rover) {
        if (this.roverList == null || this.roverList.isEmpty()) {
            this.roverList = new ArrayList<>();
        }

        if (!canLand(rover)) {
            return;
        }

        this.roverList.add(rover);
        this.activeRover = rover;
    }

    public Rover getActiveRover() {
        return this.activeRover;
    }

    private boolean canLand(Rover rover) {
        if (rover.getX() < 0 || rover.getX() >= this.width) {
            System.err.printf("Cannot land to %s, %s since out of surface boundary.%n", rover.getX(), rover.getY());
            return false;
        } else if (rover.getY() < 0 || rover.getY() >= this.height) {
            System.err.printf("Cannot land to %s, %s since out of surface boundary.%n", rover.getX(), rover.getY());
            return false;
        }

        boolean isRoverExistAtDestination = this.roverList.stream()
                .anyMatch(x -> x.getX() == rover.getX() && x.getY() == rover.getY());

        if (isRoverExistAtDestination) {
            System.err.println("Cannot land since selected area is occupied.");
            return false;
        }

        return true;
    }

}
