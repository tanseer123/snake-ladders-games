package com.snakeladders;


import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Snakes & Ladders game board with snakes and ladders.
 * Manages board configuration and position transformations.
 */
public class SnakesAndLaddersBoard {

    public static final int BOARD_SIZE = 100;
    public static final int START_POSITION = 0;

    private final Map<Integer, Integer> ladders;
    private final Map<Integer, Integer> snakes;

    /**
     * Initialize the board with predefined snakes and ladders.
     */
    public SnakesAndLaddersBoard() {
        this.ladders = new HashMap<>();
        this.snakes = new HashMap<>();
        initializeLadders();
        initializeSnakes();
    }

    /**
     * Initialize ladder positions on the board.
     * Each ladder is defined as foot position -> top position.
     */
    private void initializeLadders() {
        ladders.put(7, 33);
        ladders.put(37, 85);
        ladders.put(51, 72);
        ladders.put(71, 91);
    }

    /**
     * Initialize snake positions on the board.
     * Each snake is defined as head position -> tail position.
     */
    private void initializeSnakes() {
        snakes.put(36, 19);
        snakes.put(65, 35);
        snakes.put(87, 32);
        snakes.put(98, 12);
    }

    /**
     * Get the final position after considering snakes and ladders.
     *
     * @param position The current position on the board
     * @return The final position after snake/ladder effects
     */
    public int getFinalPosition(int position) {
        if (ladders.containsKey(position)) {
            return ladders.get(position);
        } else if (snakes.containsKey(position)) {
            return snakes.get(position);
        }
        return position;
    }

    /**
     * Check if a position is valid on the board.
     *
     * @param position Position to validate
     * @return true if position is valid, false otherwise
     */
    public boolean isValidPosition(int position) {
        return position >= 0 && position <= BOARD_SIZE;
    }

    /**
     * Check if there's a ladder at the given position.
     *
     * @param position Position to check
     * @return true if there's a ladder, false otherwise
     */
    public boolean hasLadder(int position) {
        return ladders.containsKey(position);
    }

    /**
     * Check if there's a snake at the given position.
     *
     * @param position Position to check
     * @return true if there's a snake, false otherwise
     */
    public boolean hasSnake(int position) {
        return snakes.containsKey(position);
    }

    /**
     * Get all ladder positions.
     *
     * @return Map of ladder foot -> ladder top positions
     */
    public Map<Integer, Integer> getLadders() {
        return new HashMap<>(ladders);
    }

    /**
     * Get all snake positions.
     *
     * @return Map of snake head -> snake tail positions
     */
    public Map<Integer, Integer> getSnakes() {
        return new HashMap<>(snakes);
    }
}
