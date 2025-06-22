package com.snakeladders;


/**
 * Represents the result of a game move.
 * Contains the new position and a descriptive message.
 */
public class GameMoveResult {

    private final int newPosition;
    private final String message;

    /**
     * Create a new game move result.
     *
     * @param newPosition The new position after the move
     * @param message Descriptive message about the move
     */
    public GameMoveResult(int newPosition, String message) {
        this.newPosition = newPosition;
        this.message = message;
    }

    /**
     * Get the new position.
     *
     * @return The new position
     */
    public int getNewPosition() {
        return newPosition;
    }

    /**
     * Get the move message.
     *
     * @return The descriptive message
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("GameMoveResult{newPosition=%d, message='%s'}", newPosition, message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        GameMoveResult that = (GameMoveResult) obj;
        return newPosition == that.newPosition &&
                (message != null ? message.equals(that.message) : that.message == null);
    }

    @Override
    public int hashCode() {
        int result = newPosition;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}