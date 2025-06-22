package com.snakeladders;

/**
 * Handles the core game logic and player movement.
 * Manages game state and validates moves.
 */
public class GameEngine {

    private final SnakesAndLaddersBoard board;
    private int currentPosition;
    private boolean gameWon;

    /**
     * Initialize the game engine with a board.
     *
     * @param board The game board instance
     */
    public GameEngine(SnakesAndLaddersBoard board) {
        this.board = board;
        this.currentPosition = SnakesAndLaddersBoard.START_POSITION;
        this.gameWon = false;
    }

    /**
     * Move the player based on dice roll.
     *
     * @param diceRoll The dice roll value (1-6)
     * @return GameMoveResult containing new position and message
     * @throws IllegalArgumentException if dice roll is invalid
     */
    public GameMoveResult movePlayer(int diceRoll) {
        if (!isValidDiceRoll(diceRoll)) {
            throw new IllegalArgumentException("Invalid dice roll: " + diceRoll + ". Must be between 1 and 6.");
        }

        if (gameWon) {
            return new GameMoveResult(currentPosition, "Game already won!");
        }

        int newPosition = currentPosition + diceRoll;

        // Check if move exceeds board size
        if (newPosition > SnakesAndLaddersBoard.BOARD_SIZE) {
            String message = String.format("Cannot move to %d. Staying at %d.", newPosition, currentPosition);
            return new GameMoveResult(currentPosition, message);
        }

        // Check for exact win condition
        if (newPosition == SnakesAndLaddersBoard.BOARD_SIZE) {
            currentPosition = newPosition;
            gameWon = true;
            return new GameMoveResult(currentPosition, "Yay!! You won!!");
        }

        // Apply snake/ladder effects
        int finalPosition = board.getFinalPosition(newPosition);
        String message = generateMoveMessage(newPosition, finalPosition);

        currentPosition = finalPosition;
        return new GameMoveResult(currentPosition, message);
    }

    /**
     * Validate dice roll value.
     *
     * @param diceRoll The dice roll to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidDiceRoll(int diceRoll) {
        return diceRoll >= 1 && diceRoll <= 6;
    }

    /**
     * Generate appropriate message for the move.
     *
     * @param intermediatePosition Position after dice roll
     * @param finalPosition Final position after snake/ladder effects
     * @return Descriptive message for the move
     */
    private String generateMoveMessage(int intermediatePosition, int finalPosition) {
        if (board.hasLadder(intermediatePosition)) {
            return String.format("Climbed ladder from %d to %d!", intermediatePosition, finalPosition);
        } else if (board.hasSnake(intermediatePosition)) {
            return String.format("Bitten by snake at %d, moved down to %d!", intermediatePosition, finalPosition);
        } else {
            return String.format("Moved to position %d.", finalPosition);
        }
    }

    /**
     * Get the current position of the player.
     *
     * @return Current position
     */
    public int getCurrentPosition() {
        return currentPosition;
    }

    /**
     * Set the current position (for testing purposes).
     *
     * @param position New position
     */
    public void setCurrentPosition(int position) {
        if (board.isValidPosition(position)) {
            this.currentPosition = position;
        }
    }

    /**
     * Check if the game has been won.
     *
     * @return true if game is won, false otherwise
     */
    public boolean isGameWon() {
        return gameWon;
    }

    /**
     * Reset the game to initial state.
     */
    public void resetGame() {
        this.currentPosition = SnakesAndLaddersBoard.START_POSITION;
        this.gameWon = false;
    }

    /**
     * Get the game board.
     *
     * @return The game board instance
     */
    public SnakesAndLaddersBoard getBoard() {
        return board;
    }
}
