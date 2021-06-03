package Views;

import Database.UserDB;
import Models.GameApplication;
import Models.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class EndGamePanel extends JPanel {
    public String NAME ="endGamePanel";
    private JLabel firstLable;
    private JLabel secondLabel;
    private JLabel thirdLabel;
    private JLabel fourthLabel;
    private JLabel fifthLabel;
    private JLabel sixLabel;
    private JLabel infoLabel;
    private JButton continueButton;
    private JButton enterQuestion;

    public EndGamePanel(GameApplication game, ActionListener listener) {
        //construct components
        UserDB userDB = new UserDB();
        userDB.updateUserScore(game.getGameUser());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        if (game.getGameRounds() >= Level.LEVEL15.getPrizeLevel()){
            firstLable = new JLabel("Congratulations "+game.getGameUser().getUserName()+"!");
            secondLabel = new JLabel ("You Have Won \"Who Wants to be a Kiwionaire?\"!");
            thirdLabel = new JLabel ("You have won $" +decimalFormat.format(game.getGameUser().getScore())+ "!");
            fourthLabel = new JLabel("If you'd like to input your own question click the enter a question button.");
            fifthLabel = new JLabel("Otherwise click the continue button to return to the main menu.");
            enterQuestion = new JButton("Submit New Question");
            continueButton = new JButton ("Continue");

            firstLable.setBounds(220, 40, 595, 40);
            secondLabel.setBounds (165, 80, 565, 35);
            thirdLabel.setBounds (230, 110, 485, 45);
            fourthLabel.setBounds(100, 150, 505, 30);
            fifthLabel.setBounds (140, 170, 405, 30);

            firstLable.setForeground(Color.WHITE);
            add(firstLable);
            add(enterQuestion);
            add(firstLable);
            enterQuestion.addActionListener(listener);
            enterQuestion.setBounds(125, 260, 175, 35);
            continueButton.setBounds(355, 260, 175, 35);

        }
        else {
            firstLable = new JLabel ("Thanks for playing \"Who Wants to be a Kiwionaire?\"");
            secondLabel = new JLabel ("Your final score was $" +game.getGameUser().getScore() +", " +
                    "and your game ended on question "+game.getGameRounds()+".");
            thirdLabel = new JLabel ("We will automatically save your last game score and username for you.");
            fourthLabel = new JLabel ("Make sure to play again soon to improve your score and maybe even WIN!");
            continueButton = new JButton ("Continue");
            infoLabel = new JLabel ("Please press continue to return to the main menu.");
            infoLabel.setForeground(Color.WHITE);

            firstLable.setBounds (180, 30, 355, 70);
            secondLabel.setBounds (125, 60, 435, 90);
            thirdLabel.setBounds (110, 110, 465, 70);
            fourthLabel.setBounds (105, 140, 475, 90);
            infoLabel.setBounds (170, 240, 325, 30);

            firstLable.setForeground(Color.WHITE);
            add (firstLable);
            add (infoLabel);
            continueButton.setBounds (245, 290, 175, 35);

        }

        UserDB db = new UserDB();
        db.updateUser(game.getGameUser());

        secondLabel.setForeground(Color.WHITE);
        thirdLabel.setForeground(Color.WHITE);
        fourthLabel.setForeground(Color.WHITE);
        continueButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension(672, 454));
        setLayout (null);

        add (secondLabel);
        add (thirdLabel);
        add (fourthLabel);

        add (continueButton);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Kea.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
    }

    public JButton getEnterQuestion() {
        return enterQuestion;
    }
}
