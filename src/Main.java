public class Main {
    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String[] SCORE_NAMES_FOR_TIE = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
    private static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    private static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    private static final String WIN_FOR_PLAYER1 = "Win for player1";
    private static final String WIN_FOR_PLAYER2 = "Win for player2";

    /**
     * Method to return the tennis score
     */
    public static String getScore(int scorePlayer1, int scorePlayer2) {
        String score = "";
        int tempScore = 0;

        if (scorePlayer1 == scorePlayer2) {
            score = getScores(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            score = getScoresForWin(scorePlayer1, scorePlayer2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scorePlayer1;
                else {
                    score += "-";
                    tempScore = scorePlayer2;
                }
                score = namingScores(tempScore, score);
            }
        }
        return score;
    }

    /**
     * This method returns the tennis score name corresponding to the provided numeric value.
     *
     * @param tempScore The numeric score of the player.
     * @return The tennis score name corresponding to the numeric value.
     */
    private static String namingScores(int tempScore) {
        return SCORE_NAMES[tempScore];
    }

    /**
     * Method to get scores for win
     */
    private static String getScoresForWin(int scorePlayer1, int scorePlayer2) {
        String score;
        int scoreDifference = scorePlayer1 - scorePlayer2;
        if (scoreDifference == 1) score = "Advantage player1";
        else if (scoreDifference == -1) score = "Advantage player2";
        else if (scoreDifference >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}