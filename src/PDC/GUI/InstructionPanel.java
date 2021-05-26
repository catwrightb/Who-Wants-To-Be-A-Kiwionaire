package PDC.GUI;

import javax.swing.*;
import java.awt.*;

public class InstructionPanel extends JPanel {
    String NAME = "InstructionPanel";
    private JLabel MenuPanel;
    private JLabel text3;
    private JLabel text4;
    private JLabel text5;
    private JLabel text6;
    private JLabel text1;
    private JLabel text2;
    private JLabel text7;
    private JLabel text8;
    private JButton backButton;

    public InstructionPanel(){
        //construct components
        MenuPanel = new JLabel ("How to play \"Who Wants to be a Kiwionaire?");
        MenuPanel.setFont(new Font("Serif", Font.BOLD, 14));
        MenuPanel.setForeground(Color.WHITE);
        text3 = new JLabel ("To play simply click the button which you believe is correct to a given asked question.");
        text4 = new JLabel ("Check the upper left cornor of the game screen to see your current score and progress.");
        text5 = new JLabel ("If you ever get stuck make sure to use one of your linelines.");
        text6 = new JLabel ("But remember once you use a lifeline you can't use it again.");
        text1 = new JLabel ("The goal of the game is to answer 15 questions correctly, earning you $1,000,000 NZD");
        text2 = new JLabel ("and a oppurtunity to input your own question into the game!");
        text7 = new JLabel ("You can exit the game via the exit button in the upper right cornor of the screen.");
        text8 = new JLabel ("Once you exit a game your game will completly. ");
        backButton = new JButton ("Back");

        //adjust size and set layout
        setPreferredSize (new Dimension(650, 450));
        setLayout (null);

        //add components
        add (MenuPanel);
        add (text3);
        text3.setForeground(Color.WHITE);
        add (text4);
        text4.setForeground(Color.WHITE);
        add (text5);
        text6.setForeground(Color.WHITE);
        add (text6);
        text5.setForeground(Color.WHITE);
        add (text1);
        text1.setForeground(Color.WHITE);
        add (text2);
        text2.setForeground(Color.WHITE);
        add (text7);
        text7.setForeground(Color.WHITE);
        add (text8);
        text8.setForeground(Color.WHITE);

        //set component bounds (only needed by Absolute Positioning)
        MenuPanel.setBounds (180, 20, 340, 40);
        text3.setBounds (65, 175, 580, 55);
        text4.setBounds (65, 220, 595, 25);
        text5.setBounds (140, 235, 695, 50);
        text6.setBounds (140, 275, 405, 30);
        text1.setBounds (60, 80, 555, 40);
        text2.setBounds (125, 105, 465, 40);
        text7.setBounds (60, 320, 555, 45);
        text8.setBounds (155, 350, 335, 40);
        backButton.setBounds (25, 15, 80, 35);
        add(backButton);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Beach.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);



    }

    public JButton getBackButton() {
        return backButton;
    }
}
