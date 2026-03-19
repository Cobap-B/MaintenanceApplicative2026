package trivia;

public class Player {
    private final String name;
    private int position;
    private int coins;
    private boolean inPenaltyBox;

    public Player(String name) {
        this.name = name;
        this.position = 1;
        this.coins = 0;
        this.inPenaltyBox = false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoin() {
        this.coins++;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    @Override
    public String toString() {
        return "Player{" +
               "name='" + name + '\'' +
               ", position=" + position +
               ", coins=" + coins +
               ", inPenaltyBox=" + inPenaltyBox +
               '}';
    }
}
