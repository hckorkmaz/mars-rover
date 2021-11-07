package com.halitkorkmaz.command.vehicle;

import com.halitkorkmaz.command.CommandManager;
import com.halitkorkmaz.command.ICommandExecutor;
import com.halitkorkmaz.command.type.MovementCommandType;
import com.halitkorkmaz.command.type.RotationCommandType;
import com.halitkorkmaz.rover.Rover;


public class VehicleCommandExecutor implements ICommandExecutor {

    @Override
    public void executeCommand(String input) {
        Rover activeRover = CommandManager.surface.getActiveRover();

        char[] commandArray = input.toCharArray();
        for (char command : commandArray) {
            String commandAsString = Character.toString(command);

            MovementCommandType movementCommandType = MovementCommandType.findByName(commandAsString);
            if (movementCommandType != null) {
                activeRover.move(movementCommandType.getMovementStep());
                continue;
            }

            RotationCommandType rotationCommandType = RotationCommandType.findByName(commandAsString);
            if (rotationCommandType != null) {
                activeRover.rotate(rotationCommandType.getRotationDegree());
                continue;
            }

            System.err.println("Unknown command found in vehicle commands.");
        }

        activeRover.status();
    }
}
