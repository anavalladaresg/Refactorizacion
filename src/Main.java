public class Main {
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
     * Method to name the scores
     */
    private static String namingScores(int tempScore, String score) {
        switch (tempScore) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
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

    /**
     * Method to get scores
     */
    private static String getScores(int scorePlayer1) {
        String score;
        switch (scorePlayer1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}