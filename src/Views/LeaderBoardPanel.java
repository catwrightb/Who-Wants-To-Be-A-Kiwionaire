package Views;

import javax.swing.*;
import javax.swing.border.Border;
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
    private JPanel p1;


    public LeaderBoardPanel(ActionListener listener){
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.getUsersFromDataBase(leaderboard);

        leaderboardTitle = new JLabel ("Leaderboard");
        Font titleFont = new Font("Serif", Font.BOLD, 24);
        Font textFont = new Font("Serif", Font.BOLD, 18);
        leaderboardTitle.setFont(titleFont);
        leaderboardTitle.setForeground(Color.WHITE);

        //construct components
        nameOne = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL1.getPrizeLevel()-1));
        nameOne.setFont(textFont);
        nameOne.setForeground(Color.WHITE);
        positionOne = new JLabel (Level.LEVEL1.getPrizeLevel()+")");
        positionOne.setFont(textFont);
        positionOne.setForeground(Color.WHITE);

        nameTwo = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL2.getPrizeLevel()-1));
        nameTwo.setFont(textFont);
        nameTwo.setForeground(Color.WHITE);
        positionTwo = new JLabel (Level.LEVEL2.getPrizeLevel()+")");
        positionTwo.setFont(textFont);
        positionTwo.setForeground(Color.WHITE);

        nameThree = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL3.getPrizeLevel()-1));
        nameThree.setFont(textFont);
        nameThree.setForeground(Color.WHITE);
        positionThree = new JLabel(Level.LEVEL3.getPrizeLevel()+")");
        positionThree.setFont(textFont);
        positionThree.setForeground(Color.WHITE);

        nameFour = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL4.getPrizeLevel()-1));
        nameFour.setFont(textFont);
        nameFour.setForeground(Color.WHITE);
        positionFour= new JLabel (Level.LEVEL4.getPrizeLevel()+")");
        positionFour.setFont(textFont);
        positionFour.setForeground(Color.WHITE);

        nameFive = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL5.getPrizeLevel()-1));
        nameFive.setFont(textFont);
        nameFive.setForeground(Color.WHITE);
        positionFive = new JLabel (Level.LEVEL5.getPrizeLevel()+")");
        positionFive.setFont(textFont);
        positionFive.setForeground(Color.WHITE);


        nameSix = new JLabel ("" + leaderboard.leaderBoardSet.get(Level.LEVEL6.getPrizeLevel()-1));
        nameSix.setFont(textFont);
        nameSix.setForeground(Color.WHITE);
        positionSix= new JLabel (Level.LEVEL5.getPrizeLevel()+")");
        positionSix.setFont(textFont);
        positionSix.setForeground(Color.WHITE);


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

        Border raisedbevel = BorderFactory.createRaisedBevelBorder();
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);

        //set component bounds (only needed by Absolute Positioning)
        //left
        nameOne.setBounds (130, 115, 150, 40);
        nameOne.setBorder(compound);
        positionOne.setBounds (110, 115, 195, 40);

        nameThree.setBounds (130, 195, 150, 40);
        nameThree.setBorder(compound);
        positionThree.setBounds (110, 195, 195, 40);

        nameFive.setBounds (130, 275, 150, 40);
        nameFive.setBorder(compound);
        positionFive.setBounds (110, 275, 195, 40);

        //right
        nameTwo.setBounds (440, 115, 150, 40);
        nameTwo.setBorder(compound);
        positionTwo.setBounds (420, 115, 195, 40);

        nameFour.setBounds (440, 195, 150, 40);
        nameFour.setBorder(compound);
        positionFour.setBounds (420, 195, 195, 40);

        nameSix.setBounds (440, 275, 150, 40);
        nameSix.setBorder(compound);
        positionSix.setBounds (420, 275, 195, 40);

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
