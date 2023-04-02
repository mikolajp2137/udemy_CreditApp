package core.model;

public enum MaritalStatus {
    SINGLE(0), MARRIED(100), DIVORCED(0), SEPARATED(100), WIDOWED(0);

    public int getScoringPoints() {
        return scoringPoints;
    }

    private final int scoringPoints;

    MaritalStatus(int scoringPoints) {
        this.scoringPoints = scoringPoints;
    }
}
