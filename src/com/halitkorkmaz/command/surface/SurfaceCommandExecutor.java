package com.halitkorkmaz.command.surface;

import com.halitkorkmaz.command.CommandManager;
import com.halitkorkmaz.command.ICommandExecutor;
import com.halitkorkmaz.surface.Plateau;

public class SurfaceCommandExecutor implements ICommandExecutor {
    @Override
    public void executeCommand(String input) {
        String[] surfaceWidthHeight = input.split(" ");
        CommandManager.surface = new Plateau(Integer.parseInt(surfaceWidthHeight[0]), Integer.parseInt(surfaceWidthHeight[1]));
    }
}
