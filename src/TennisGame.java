public class TennisGame {

    public static final int SCORE_ZERO = 0;
    public static final int SCORE_FIFTEEN = 15;
    public static final int SCORE_THIRTY = 30;
    public static final int SCORE_FORTY = 40;
    public static final int ADVANTAGE_SCORE = 10;
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String ALL = "All";
    public static final String ADVANTAGE = "Advantage";
    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String SHOW_WIN_FOR = "Win for";

    public static String getScore(int player1Score, int player2Score) {
        String score = "";
        if (player1Score == player2Score) {
            score = getScoreAlike(player1Score);
        } else if (player1Score > SCORE_FORTY || player2Score > SCORE_FORTY) {
            score = getPlayerWinOrAdvantage(player1Score, player2Score);
        } else {
            score = getPlayer1AndPlayer2Score(player1Score, player2Score);
        }
        return score;
    }

    private static String getPlayer1AndPlayer2Score(int player1Score, int player2Score) {
        int tempScore;
        String score = "";
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case SCORE_ZERO:
                    score += LOVE;
                    break;
                case SCORE_FIFTEEN:
                    score += FIFTEEN;
                    break;
                case SCORE_THIRTY:
                    score += THIRTY;
                    break;
                case SCORE_FORTY:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    private static String getScoreAlike(int player1Score) {
        String score;
        switch (player1Score) {
            case SCORE_ZERO:
                score = LOVE + "- " + ALL;
                break;
            case SCORE_FIFTEEN:
                score = FIFTEEN + "-" + ALL;
                break;
            case SCORE_THIRTY:
                score = THIRTY + "-" + ALL;
                break;
            case SCORE_FORTY:
                score = FORTY + "-" + ALL;
                break;
            default:
                score = DEUCE;
                break;
        }
        return score;
    }

    private static String getPlayerWinOrAdvantage(int player1Score, int player2Score) {
        String score;
        int advantageScore = player1Score - player2Score;
        if (advantageScore == ADVANTAGE_SCORE) {
            score = ADVANTAGE + " " + PLAYER_1;
        } else if (advantageScore == -ADVANTAGE_SCORE) {
            score = ADVANTAGE + " " + PLAYER_2;
        } else if (advantageScore >= ADVANTAGE_SCORE) {
            score = SHOW_WIN_FOR + " " + PLAYER_1;
        } else {
            score = SHOW_WIN_FOR + " " + PLAYER_2;
        }
        return score;
    }
}
