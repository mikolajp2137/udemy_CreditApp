package core.model;

public enum Education {

    NONE(-200), PRIMARY(-100), MIDDLE(0), SECONDARY(0), POST_SECONDARY(0), TERTIARY(100);

    private final int scoringPoints;

    Education(int scoringPoints) {
        this.scoringPoints = scoringPoints;
    }

    public int getScoringPoints() {
        return scoringPoints;
    }
}
