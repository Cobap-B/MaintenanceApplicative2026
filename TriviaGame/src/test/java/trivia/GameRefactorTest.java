package trivia;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameRefactorTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void shouldAddPlayersAndScoreAfterCorrectAnswer() {
        IGame game = new Game();

        assertTrue(game.add("Alice"));
        assertTrue(game.add("Bob"));

        game.roll(1); // Alice moves and gets question
        boolean stillPlaying = game.handleCorrectAnswer();

        assertTrue(stillPlaying, "Game should continue until 6 coins");

        String log = outputStream.toString();
        assertTrue(log.contains("Alice is the current player"));
        assertTrue(log.contains("Answer was corrent!!!!"));
        assertTrue(log.contains("Alice now has 1 Gold Coins."));
    }

    @Test
    void shouldSendPlayerToPenaltyBoxAndNotAwardCoinOnWrongAnswerThenCorrect() {
        IGame game = new Game();

        assertTrue(game.add("Carol"));
        assertTrue(game.add("Dave"));

        game.roll(2); // Carol's turn
        game.wrongAnswer(); // Carol into penalty box, Dave next

        game.roll(2); // Dave plays
        game.handleCorrectAnswer();

        game.roll(2); // Back to Carol, still in penalty box since roll=2 even
        game.handleCorrectAnswer();

        String log = outputStream.toString();
        assertTrue(log.contains("Carol was sent to the penalty box"));
        assertTrue(log.contains("Carol is not getting out of the penalty box"));
        assertTrue(log.contains("Dave now has 1 Gold Coins."));
    }

    @Test
    void shouldRotatePlayersRoundRobin() {
        IGame game = new Game();

        assertTrue(game.add("Eve"));
        assertTrue(game.add("Frank"));

        game.roll(1); // Eve
        game.handleCorrectAnswer();

        game.roll(1); // Frank
        game.handleCorrectAnswer();

        String log = outputStream.toString();
        assertTrue(log.contains("Eve is the current player"));
        assertTrue(log.contains("Frank is the current player"));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
