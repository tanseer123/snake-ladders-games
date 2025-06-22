package com.snakeladders;


/**
 * Main application class for Snakes & Ladders game.
 * Handles program entry point and argument parsing.
 */
public class SnakesAndLaddersApplication {

    /**
     * Main entry point of the application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        GameInterface gameInterface = new GameInterface();

        try {
            if (args.length == 2) {
                // Command line mode: current_position dice_roll
                handleCommandLineMode(args, gameInterface);
            } else if (args.length == 0) {
                // Interactive mode
                gameInterface.playInteractive();
            } else {
                printUsage();
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            gameInterface.close();
        }
    }

    /**
     * Handle command line mode execution.
     *
     * @param args Command line arguments
     * @param gameInterface The game interface instance
     */
    private static void handleCommandLineMode(String[] args, GameInterface gameInterface) {
        try {
            int currentPosition = Integer.parseInt(args[0]);
            int diceRoll = Integer.parseInt(args[1]);

            gameInterface.playCommandLineMove(currentPosition, diceRoll);

        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in arguments.");
            System.err.println("Current position and dice roll must be integers.");
            printUsage();
        }
    }

    /**
     * Print usage instructions.
     */
    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  Interactive mode: java SnakesAndLaddersApplication");
        System.out.println("  Command line mode: java SnakesAndLaddersApplication <current_position> <dice_roll>");
        System.out.println();
        System.out.println("Examples:");
        System.out.println("  java SnakesAndLaddersApplication 4 5");
        System.out.println("  java SnakesAndLaddersApplication 34 3");
        System.out.println("  java SnakesAndLaddersApplication 99 1");
    }
}