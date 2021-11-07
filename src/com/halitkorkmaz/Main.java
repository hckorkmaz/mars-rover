package com.halitkorkmaz;

import com.halitkorkmaz.command.CommandManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        CommandManager commandManager = new CommandManager();
        commandManager.executeCommand("5 5");
        commandManager.executeCommand("1 2 N");
        commandManager.executeCommand("LMLMLMLMM");
        commandManager.executeCommand("3 3 E");
        commandManager.executeCommand("MMRMMRMRRM");
        */

        Scanner scanner = new Scanner(System.in);
        try {
            CommandManager commandManager = new CommandManager();
            while (true) {
                String line = scanner.nextLine();
                commandManager.executeCommand(line);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.printf("System.in was closed, exiting %s%n", e.getMessage());
        }
    }
}
