package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import Models.*;

public class LeaderBoardPanel extends JPanel {
    private JLabel nameOne;
    private JLabel positionOne;
    private JLabel nameTwo;
    private JLabel positionTwo;
    private JLabel positionThree;
    private JLabel nameThree;
    private JLabel nameFour;
    private JLabel positionFour;
    private JLabel nameFive;
    private JLabel positionFive;
    private JLabel positionSix;
    private JLabel nameSix;
    private JLabel leaderboardTitle;
    public String NAME = "leaderBoard";
    private JButton backButton;


    public LeaderBoardPanel(ActionListener listener){
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.getUsersFromDataBase(leaderboard);

        leaderboardTitle = new JLabel ("Leaderboard");
        Font font1 = new Font("Serif", Font.BOLD, 24);
        Font font = new Font("Serif", Font.BOLD, 18);
        leaderboardTitle.setFont(font1);
        leaderboardTitle.setForeground(Color.WHITE);

        //construct components
        nameOne = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL1.getPrizeLevel()-1));
        nameOne.setFont(font);
        nameOne.setForeground(Color.WHITE);
        positionOne = new JLabel (Level.LEVEL1.getPrizeLevel()+".");
        positionOne.setFont(font);
        positionOne.setForeground(Color.WHITE);

        nameTwo = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL2.getPrizeLevel()-1));
        nameTwo.setFont(font);
        nameTwo.setForeground(Color.WHITE);
        positionTwo = new JLabel (Level.LEVEL2.getPrizeLevel()+".");
        positionTwo.setFont(font);
        positionTwo.setForeground(Color.WHITE);

        nameThree = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL3.getPrizeLevel()-1));
        nameThree.setFont(font);
        nameThree.setForeground(Color.WHITE);
        positionThree = new JLabel(Level.LEVEL3.getPrizeLevel()+".");
        positionThree.setFont(font);
        positionThree.setForeground(Color.WHITE);

        nameFour = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL4.getPrizeLevel()-1));
        nameFour.setFont(font);
        nameFour.setForeground(Color.WHITE);
        positionFour= new JLabel (Level.LEVEL4.getPrizeLevel()+".");
        positionFour.setFont(font);
        positionFour.setForeground(Color.WHITE);

        nameFive = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL5.getPrizeLevel()-1));
        nameFive.setFont(font);
        nameFive.setForeground(Color.WHITE);
        positionFive = new JLabel (Level.LEVEL5.getPrizeLevel()+".");
        positionFive.setFont(font);
        positionFive.setForeground(Color.WHITE);

        positionSix= new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL6.getPrizeLevel()-1));
        positionSix.setFont(font);
        positionSix.setForeground(Color.WHITE);
        nameSix = new JLabel (Level.LEVEL6.getPrizeLevel()+".");
        nameSix.setFont(font);
        nameSix.setForeground(Color.WHITE);


        backButton = new JButton ("Back");
        backButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension(676, 442));
        setLayout (null);

        //add components
        add (nameOne);
        add (positionOne);
        add (nameTwo);
        add (positionTwo);
        add (positionThree);
        add (nameThree);
        add (nameFour);
        add (positionFour);
        add (nameFive);
        add (positionFive);
        add (positionSix);
        add (nameSix);
        add(backButton);
        add (leaderboardTitle);

        //set component bounds (only needed by Absolute Positioning)
        //left
        nameOne.setBounds (145, 115, 195, 40);
        positionOne.setBounds (125, 115, 195, 40);

        nameThree.setBounds (145, 195, 195, 40);
        positionThree.setBounds (125, 195, 195, 40);

        nameFive.setBounds (145, 275, 195, 40);
        positionFive.setBounds (125, 275, 195, 40);

        //right
        nameTwo.setBounds (460, 115, 195, 40);
        positionTwo.setBounds (435, 115, 195, 40);

        nameFour.setBounds (460, 195, 195, 40);
        positionFour.setBounds (435, 195, 195, 40);

        nameSix.setBounds (460, 275, 195, 40);
        positionSix.setBounds (435, 275, 195, 40);

        leaderboardTitle.setBounds (280, 65, 175, 25);
        backButton.setBounds (25, 15, 80, 35);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/allBlacks.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);

    }

    public JLabel getPositionOne() {
        return positionOne;
    }

    public JLabel getPositionTwo() {
        return positionTwo;
    }

    public JLabel getPositionThree() {
        return positionThree;
    }

    public JLabel getPositionFour() {
        return positionFour;
    }

    public JLabel getPositionFive() {
        return positionFive;
    }

    public JLabel getPositionSix() {
        return positionSix;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
