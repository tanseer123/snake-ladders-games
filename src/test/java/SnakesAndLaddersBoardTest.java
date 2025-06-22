import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import com.snakeladders.SnakesAndLaddersBoard;

import java.util.Map;

/**
 * Unit tests for SnakesAndLaddersBoard class.
 */
@DisplayName("Snakes and Ladders Board Tests")
class SnakesAndLaddersBoardTest {

    private SnakesAndLaddersBoard board;

    @BeforeEach
    void setUp() {
        board = new SnakesAndLaddersBoard();
    }

    @Test
    @DisplayName("Board should initialize with correct constants")
    void testBoardInitialization() {
        assertEquals(100, SnakesAndLaddersBoard.BOARD_SIZE);
        assertEquals(0, SnakesAndLaddersBoard.START_POSITION);
    }

    @Test
    @DisplayName("Board should have correct number of ladders and snakes")
    void testBoardConfiguration() {
        assertEquals(4, board.getLadders().size());
        assertEquals(4, board.getSnakes().size());
    }

    @Test
    @DisplayName("Ladders should be configured correctly")
    void testLadderPositions() {
        Map<Integer, Integer> ladders = board.getLadders();

        assertEquals(33, ladders.get(7));
        assertEquals(85, ladders.get(37));
        assertEquals(72, ladders.get(51));
        assertEquals(91, ladders.get(71));
    }

    @Test
    @DisplayName("Snakes should be configured correctly")
    void testSnakePositions() {
        Map<Integer, Integer> snakes = board.getSnakes();

        assertEquals(19, snakes.get(36));
        assertEquals(35, snakes.get(65));
        assertEquals(32, snakes.get(87));
        assertEquals(12, snakes.get(98));
    }

    @Test
    @DisplayName("Should correctly identify ladder positions")
    void testHasLadder() {
        assertTrue(board.hasLadder(7));
        assertTrue(board.hasLadder(37));
        assertTrue(board.hasLadder(51));
        assertTrue(board.hasLadder(71));

        assertFalse(board.hasLadder(10));
        assertFalse(board.hasLadder(36));
        assertFalse(board.hasLadder(87));
    }

    @Test
    @DisplayName("Should correctly identify snake positions")
    void testHasSnake() {
        assertTrue(board.hasSnake(36));
        assertTrue(board.hasSnake(65));
        assertTrue(board.hasSnake(87));
        assertTrue(board.hasSnake(98));

        assertFalse(board.hasSnake(10));
        assertFalse(board.hasSnake(7));
        assertFalse(board.hasSnake(37));
    }

    @Test
    @DisplayName("Should return correct final position for ladders")
    void testGetFinalPositionWithLadder() {
        assertEquals(33, board.getFinalPosition(7));
        assertEquals(85, board.getFinalPosition(37));
        assertEquals(72, board.getFinalPosition(51));
        assertEquals(91, board.getFinalPosition(71));
    }

    @Test
    @DisplayName("Should return correct final position for snakes")
    void testGetFinalPositionWithSnake() {
        assertEquals(19, board.getFinalPosition(36));
        assertEquals(35, board.getFinalPosition(65));
        assertEquals(32, board.getFinalPosition(87));
        assertEquals(12, board.getFinalPosition(98));
    }

    @Test
    @DisplayName("Should return same position for normal cells")
    void testGetFinalPositionNormalCell() {
        assertEquals(10, board.getFinalPosition(10));
        assertEquals(25, board.getFinalPosition(25));
        assertEquals(50, board.getFinalPosition(50));
        assertEquals(75, board.getFinalPosition(75));
    }

    @Test
    @DisplayName("Should validate positions correctly")
    void testIsValidPosition() {
        assertTrue(board.isValidPosition(0));
        assertTrue(board.isValidPosition(50));
        assertTrue(board.isValidPosition(100));

        assertFalse(board.isValidPosition(-1));
        assertFalse(board.isValidPosition(101));
        assertFalse(board.isValidPosition(-10));
        assertFalse(board.isValidPosition(200));
    }

    @Test
    @DisplayName("Should return defensive copies of snake and ladder maps")
    void testDefensiveCopies() {
        Map<Integer, Integer> ladders = board.getLadders();
        Map<Integer, Integer> snakes = board.getSnakes();

        // Try modifying the returned maps
        ladders.put(10, 90);
        snakes.put(20, 5);

        // Original board maps should not be affected
        assertFalse(board.getLadders().containsKey(10));
        assertFalse(board.getSnakes().containsKey(20));
    }
}
