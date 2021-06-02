package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeaderBoard extends JPanel {
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
    ArrayList<JLabel> labelList = new ArrayList<>();


    public LeaderBoard(ActionListener listener){

        leaderboardTitle = new JLabel ("Leaderboard");
        Font font1 = new Font("Serif", Font.BOLD, 24);
        Font font = new Font("Serif", Font.BOLD, 18);
        leaderboardTitle.setFont(font1);
        leaderboardTitle.setForeground(Color.WHITE);

        //construct components
        nameOne = new JLabel ("nameOne");
        nameOne.setFont(font);
        nameOne.setForeground(Color.WHITE);
        positionOne = new JLabel ("1.");
        positionOne.setFont(font);
        positionOne.setForeground(Color.WHITE);
        nameTwo = new JLabel ("nameTwo");
        nameTwo.setFont(font);
        nameTwo.setForeground(Color.WHITE);
        positionTwo = new JLabel ("2.");
        positionTwo.setFont(font);
        positionTwo.setForeground(Color.WHITE);
        positionThree = new JLabel ("3.");
        positionThree.setFont(font);
        positionThree.setForeground(Color.WHITE);
        nameThree = new JLabel ("nameThree");
        nameThree.setFont(font);
        nameThree.setForeground(Color.WHITE);

        nameFour = new JLabel ("nameFour");
        nameFour.setFont(font);
        nameFour.setForeground(Color.WHITE);
        positionFour= new JLabel ("4.");
        positionFour.setFont(font);
        positionFour.setForeground(Color.WHITE);
        nameFive = new JLabel ("nameFive");
        nameFive.setFont(font);
        nameFive.setForeground(Color.WHITE);
        positionFive = new JLabel ("5.");
        positionFive.setFont(font);
        positionFive.setForeground(Color.WHITE);
        positionSix= new JLabel ("6.");
        positionSix.setFont(font);
        positionSix.setForeground(Color.WHITE);
        nameSix = new JLabel ("nameSix");
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

    public JButton getBackButton() {
        return backButton;
    }
}
