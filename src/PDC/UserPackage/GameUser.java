package PDC.UserPackage;

import PDC.Money;

public class GameUser extends AbUser {
    private String userName;
    private int score;

    public GameUser() {
        this.score = 0;
    }

    /*
     * method updates players Scores based on if they answered a question correctly or not.
     * A Enum class Money is used.
     *
     * @param gameRoundWon question to gather score to update player score
     */
    @Override
    public void upDateScore(int gameRoundWon) {
        Money[] money = Money.values();

        for (Money value : money) {
            if (gameRoundWon == value.getPrizeLevel()) {
                this.score = value.getPrizeMoney();
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
