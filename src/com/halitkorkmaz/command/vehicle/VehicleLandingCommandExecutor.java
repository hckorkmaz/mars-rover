package com.halitkorkmaz.command.vehicle;

import com.halitkorkmaz.command.CommandManager;
import com.halitkorkmaz.command.ICommandExecutor;
import com.halitkorkmaz.rover.Rover;
import com.halitkorkmaz.vehicle.Heading;

public class VehicleLandingCommandExecutor implements ICommandExecutor {

    @Override
    public void executeCommand(String input) {
        String[] vehicleLandingInfo = input.split(" ");
        int x = Integer.parseInt(vehicleLandingInfo[0]);
        int y = Integer.parseInt(vehicleLandingInfo[1]);
        Heading heading = Heading.valueOf(vehicleLandingInfo[2]);

        CommandManager.surface.addVehicle(new Rover(x, y, heading, CommandManager.surface));
    }
}
