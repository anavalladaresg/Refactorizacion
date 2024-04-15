package com.tennis;

public class Main {
    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String[] SCORE_NAMES_FOR_TIE = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
    private static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    private static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    private static final String WIN_FOR_PLAYER1 = "Win for player1";
    private static final String WIN_FOR_PLAYER2 = "Win for player2";

    /**
     * This method calculates and returns the tennis score based on the numeric scores of two players.
     * It handles three scenarios:
     * 1. When the scores are tied.
     * 2. When either player has a score of 4 or more.
     * 3. All other cases when the scores are not tied.
     *
     * @param scorePlayer1 The numeric score of player 1.
     * @param scorePlayer2 The numeric score of player 2.
     * @return The tennis score as a string.
     */
    public static String getScore(int scorePlayer1, int scorePlayer2) {
        String score = "";

        if (scorePlayer1 == scorePlayer2) {
            score = getScoresForTie(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            score = getScoresForWin(scorePlayer1, scorePlayer2);
        } else {
            score = getScoresForNonTie(scorePlayer1, scorePlayer2);
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
     * This method returns the tennis score name when the scores of both players are tied.
     *
     * @param scorePlayer1 The numeric score of the player.
     * @return The tennis score name corresponding to the numeric value.
     */
    private static String getScoresForTie(int scorePlayer1) {
        return SCORE_NAMES_FOR_TIE[scorePlayer1];
    }

    /**
     * This method determines the winning score based on the numeric scores of the two players.
     *
     * @param scorePlayer1 The numeric score of player 1.
     * @param scorePlayer2 The numeric score of player 2.
     * @return The winning score as a string. It can be "Advantage player1", "Advantage player2", "Win for player1", or "Win for player2".
     */
    private static String getScoresForWin(int scorePlayer1, int scorePlayer2) {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) return ADVANTAGE_PLAYER1;
        else if (minusResult == -1) return ADVANTAGE_PLAYER2;
        else if (minusResult >= 2) return WIN_FOR_PLAYER1;
        else return WIN_FOR_PLAYER2;
    }

    /**
     * This method returns the tennis score names for both players when their scores are not tied.
     *
     * @param scorePlayer1 The numeric score of player 1.
     * @param scorePlayer2 The numeric score of player 2.
     * @return The tennis score names for both players separated by a dash.
     */
    private static String getScoresForNonTie(int scorePlayer1, int scorePlayer2) {
        return namingScores(scorePlayer1) + "-" + namingScores(scorePlayer2);
    }
}