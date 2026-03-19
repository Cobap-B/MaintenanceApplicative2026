package trivia;

public enum QuestionCategory {
    POP,
    SCIENCE,
    SPORTS,
    ROCK;

    @Override
    public String toString() {
        switch (this) {
            case POP:
                return "Pop";
            case SCIENCE:
                return "Science";
            case SPORTS:
                return "Sports";
            case ROCK:
                return "Rock";
            default:
                return null;
        }
    }
}
