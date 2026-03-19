package trivia;

import java.util.LinkedList;
import java.util.Objects;

public class QuestionBank {
    private static final int INITIAL_QUESTIONS = 50;

    private final LinkedList<String> popQuestions = new LinkedList<>();
    private final LinkedList<String> scienceQuestions = new LinkedList<>();
    private final LinkedList<String> sportsQuestions = new LinkedList<>();
    private final LinkedList<String> rockQuestions = new LinkedList<>();

    public QuestionBank() {
        for (int i = 0; i < INITIAL_QUESTIONS; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("Rock Question " + i);
        }
    }

    public String take(QuestionCategory category) {
        Objects.requireNonNull(category, "question category cannot be null");
        switch (category) {
            case POP:
                return popQuestions.removeFirst();
            case SCIENCE:
                return scienceQuestions.removeFirst();
            case SPORTS:
                return sportsQuestions.removeFirst();
            case ROCK:
                return rockQuestions.removeFirst();
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
