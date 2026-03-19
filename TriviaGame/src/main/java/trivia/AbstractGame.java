package trivia;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame implements IGame {

    protected final List<Player> players = new ArrayList<>();
    protected final QuestionBank questions = new QuestionBank();

    protected int currentPlayer = 0;
    protected boolean isGettingOutOfPenaltyBox;

    public boolean add(String playerName) {
        Player player = new Player(playerName);
        players.add(player);
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public boolean isPlayable() {
        return howManyPlayers() >= 2;
    }

    public void roll(int roll) {
        Player current = players.get(currentPlayer);
        System.out.println(current.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (current.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;
                System.out.println(current.getName() + " is getting out of the penalty box");
                movePlayer(current, roll);
                logCurrentPosition(current);
                askQuestion();
            } else {
                System.out.println(current.getName() + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            movePlayer(current, roll);
            logCurrentPosition(current);
            askQuestion();
        }
    }

    private void movePlayer(Player player, int roll) {
        int nextPosition = player.getPosition() + roll;
        if (nextPosition > 12) {
            nextPosition -= 12;
        }
        player.setPosition(nextPosition);
    }

    private void logCurrentPosition(Player player) {
        System.out.println(player.getName() + "'s new location is " + player.getPosition());
        System.out.println("The category is " + currentCategory().toString());
    }

    private void askQuestion() {
        System.out.println(questions.take(currentCategory()));
    }

    private QuestionCategory currentCategory() {
        int index = players.get(currentPlayer).getPosition() - 1;
        switch (index % 4) {
            case 0:
                return QuestionCategory.POP;
            case 1:
                return QuestionCategory.SCIENCE;
            case 2:
                return QuestionCategory.SPORTS;
            default:
                return QuestionCategory.ROCK;
        }
    }

    public boolean handleCorrectAnswer() {
        Player current = players.get(currentPlayer);

        if (current.isInPenaltyBox() && !isGettingOutOfPenaltyBox) {
            moveToNextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        current.addCoin();
        System.out.println(current.getName() + " now has " + current.getCoins() + " Gold Coins.");

        boolean notAWinner = didPlayerWin(current);
        moveToNextPlayer();
        return notAWinner;
    }

    public boolean wrongAnswer() {
        Player current = players.get(currentPlayer);
        System.out.println("Question was incorrectly answered");
        System.out.println(current.getName() + " was sent to the penalty box");
        current.setInPenaltyBox(true);

        moveToNextPlayer();
        return true;
    }

    private void moveToNextPlayer() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    private boolean didPlayerWin(Player current) {
        return current.getCoins() != 6;
    }
}
