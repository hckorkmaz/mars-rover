package com.halitkorkmaz.command;

import com.halitkorkmaz.command.surface.SurfaceCommandExecutor;
import com.halitkorkmaz.command.vehicle.VehicleCommandExecutor;
import com.halitkorkmaz.command.vehicle.VehicleLandingCommandExecutor;
import com.halitkorkmaz.surface.Surface;

import java.util.regex.Pattern;

public class CommandManager {

    public static Surface surface;

    private final ICommandExecutor surfaceCommandExecutor = new SurfaceCommandExecutor();

    private final ICommandExecutor vehicleCommandExecutor = new VehicleCommandExecutor();

    private final ICommandExecutor vehicleLandingCommandExecutor = new VehicleLandingCommandExecutor();

    public void executeCommand(String input) {
        boolean isSurfaceCommand = Pattern.matches("^-?\\d+ -?\\d+$", input);
        if (isSurfaceCommand) {
            surfaceCommandExecutor.executeCommand(input);
            return;
        }

        boolean isVehicleLandingCommand = Pattern.matches("^\\d+ \\d+ [NSWE]$", input);
        if (isVehicleLandingCommand) {
            if (CommandManager.surface == null) {
                System.err.println("Surface is not defined.");
                return;
            }

            vehicleLandingCommandExecutor.executeCommand(input);
            return;
        }

        boolean isVehicleCommand = Pattern.matches("^[LMR]+$", input);
        if (isVehicleCommand) {
            if (CommandManager.surface == null) {
                System.err.println("Surface is not defined.");
                return;
            }

            if (CommandManager.surface.getActiveRover() == null) {
                System.err.println("There is no active vehicle on defined surface.");
                return;
            }

            vehicleCommandExecutor.executeCommand(input);
            return;
        }

        System.err.println("Unknown command");
    }
}
