package com.snakeladders;


import java.util.Map;
import java.util.Scanner;

/**
 * Handles user interaction and game flow.
 * Provides both interactive and command-line interfaces.
 */
public class GameInterface {

    private final SnakesAndLaddersBoard board;
    private final GameEngine engine;
    private final Scanner scanner;

    /**
     * Initialize the game interface.
     */
    public GameInterface() {
        this.board = new SnakesAndLaddersBoard();
        this.engine = new GameEngine(board);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Display information about the board setup.
     */
    public void displayBoardInfo() {
        System.out.println("=== SNAKES & LADDERS GAME ===");
        System.out.println("Board size: " + SnakesAndLaddersBoard.BOARD_SIZE + " cells");
        System.out.println("Starting position: " + SnakesAndLaddersBoard.START_POSITION);

        System.out.println("\nLadders on the board:");
        Map<Integer, Integer> ladders = board.getLadders();
        ladders.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("  " + entry.getKey() + " -> " + entry.getValue()));

        System.out.println("\nSnakes on the board:");
        Map<Integer, Integer> snakes = board.getSnakes();
        snakes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("  " + entry.getKey() + " -> " + entry.getValue()));

        System.out.println("\n" + "=".repeat(50));
    }

    /**
     * Play a single move.
     *
     * @param diceRoll The dice roll value
     * @return true if game continues, false if game ends
     */
    public boolean playSingleMove(int diceRoll) {
        try {
            int previousPosition = engine.getCurrentPosition();
            GameMoveResult result = engine.movePlayer(diceRoll);

            System.out.println("Current position: " + previousPosition + ", Dice roll: " + diceRoll);
            System.out.println("New position: " + result.getNewPosition());
            System.out.println("Message: " + result.getMessage());
            System.out.println("-".repeat(30));

            return !engine.isGameWon();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }

    /**
     * Play the game interactively.
     */
    public void playInteractive() {
        displayBoardInfo();

        System.out.println("Enter dice rolls (1-6) or 'quit' to exit:");

        while (true) {
            try {
                System.out.print("Current position: " + engine.getCurrentPosition() + ", Enter dice roll: ");
                String input = scanner.nextLine().trim();

                if ("quit".equalsIgnoreCase(input)) {
                    System.out.println("Thanks for playing!");
                    break;
                }

                int diceRoll = Integer.parseInt(input);
                if (!playSingleMove(diceRoll)) {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and 6, or 'quit' to exit.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Play a single move from command line arguments.
     *
     * @param currentPosition The current position
     * @param diceRoll The dice roll value
     */
    public void playCommandLineMove(int currentPosition, int diceRoll) {
        try {
            engine.setCurrentPosition(currentPosition);
            GameMoveResult result = engine.movePlayer(diceRoll);

            System.out.println("Input - Current position: " + currentPosition + ", Dice outcome: " + diceRoll);
            System.out.println("Output - New position: " + result.getNewPosition());

            if (result.getMessage().toLowerCase().contains("won")) {
                System.out.println(result.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Close the scanner resource.
     */
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }

    /**
     * Get the game engine (for testing purposes).
     *
     * @return The game engine instance
     */
    public GameEngine getEngine() {
        return engine;
    }

    /**
     * Get the game board (for testing purposes).
     *
     * @return The game board instance
     */
    public SnakesAndLaddersBoard getBoard() {
        return board;
    }
}
