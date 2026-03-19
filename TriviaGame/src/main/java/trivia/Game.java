package trivia;

import java.util.Objects;

public class Game extends AbstractGame {

    public Game() {
        super();
    }

    // Aucun code spécifique : le comportement est géré par AbstractGame.
    // Cette classe est conservée pour répondre à l'interface et aux tests existants.

    @Override
    public String toString() {
        return "Game{" +
               "players=" + players +
               ", currentPlayer=" + currentPlayer +
               ", isGettingOutOfPenaltyBox=" + isGettingOutOfPenaltyBox +
               '}';
    }
}
