package Views;

import Database.UserDB;
import Models.GameApplication;
import Models.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EndGamePanel extends JPanel {
    public String NAME ="endGamePanel";
    private JLabel firstLable;
    private JLabel secondLabel;
    private JLabel thirdLabel;
    private JLabel fourthLabel;
    private JLabel infoLabel;
    private JButton continueButton;
    private JButton enterQuestion;

    public EndGamePanel(GameApplication game, ActionListener listener) {
        //construct components

        if (game.getGameRounds() >= Level.LEVEL15.getPrizeLevel()){
            secondLabel = new JLabel("Congratulations "+game.getGameUser().getUserName()+"!");
            thirdLabel = new JLabel ("You Have Won \"Who Wants to be a Kiwionaire?\"!");
            fourthLabel = new JLabel ("You have won $" +game.getGameUser().getScore()+ "!");
            enterQuestion = new JButton("Submit New Question");

            secondLabel.setBounds(275, 80, 160, 30);
            thirdLabel.setBounds (185, 105, 360, 65);
            fourthLabel.setBounds (260, 135, 320, 95);
            enterQuestion.setBounds(180, 310,100,35);
            continueButton.setBounds (270, 310, 100, 35);

        }
        else {
            firstLable = new JLabel ("Thanks for playing \"Who Wants to be a Kiwionaire?\"");
            secondLabel = new JLabel ("Your final score was $" +game.getGameUser().getScore() +", " +
                    "and your game ended on question "+game.getGameRounds()+".");
            thirdLabel = new JLabel ("We will automatically save your last game score and username for you.");
            fourthLabel = new JLabel ("Make sure to play again soon to improve your score and maybe even WIN!");

            firstLable.setBounds (180, 30, 355, 70);
            secondLabel.setBounds (125, 60, 435, 90);
            thirdLabel.setBounds (110, 110, 465, 70);
            fourthLabel.setBounds (105, 140, 475, 90);

            firstLable.setForeground(Color.WHITE);
            add (firstLable);

            continueButton.setBounds (270, 310, 100, 25);

        }

        UserDB db = new UserDB();
        db.updateUser(game.getGameUser());

        secondLabel.setForeground(Color.WHITE);
        thirdLabel.setForeground(Color.WHITE);
        fourthLabel.setForeground(Color.WHITE);


        infoLabel = new JLabel ("Please press continue to return to the main menu.");
        infoLabel.setForeground(Color.WHITE);
        continueButton = new JButton ("Continue");

        continueButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension(672, 454));
        setLayout (null);

        //add components

        add (secondLabel);
        add (thirdLabel);
        add (fourthLabel);
        add (infoLabel);
        add (continueButton);

        //set component bounds (only needed by Absolute Positioning)

        infoLabel.setBounds (170, 270, 325, 30);
       // continueButton.setBounds (270, 310, 100, 25);

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
}
