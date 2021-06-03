package Views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JPanel {
    public String NAME = "mainMenu";
    JButton enterButton;
    private JLabel gameTitle;
    private JButton instructionButton;
    private JButton creditButton;
    private JButton highScoreButton;
    private JButton inputQuestion;

    public MainMenu(ActionListener listener) {
        //construct components
        enterButton = new JButton ("Enter Game");
        enterButton.addActionListener(listener);
        gameTitle = new JLabel ("Who wants to be a Kiwionaire?");
        gameTitle.setFont(new Font("Serif", Font.BOLD, 24));
        gameTitle.setForeground(Color.white);

        //---- temp button
        inputQuestion = new JButton("Temp button for Q");
        inputQuestion.addActionListener(listener);
        inputQuestion.setBounds(100,100,140,35);
        add(inputQuestion);

        //----

        instructionButton = new JButton ("Instructions");
        instructionButton.addActionListener(listener);
        creditButton = new JButton ("Credits");
        creditButton.addActionListener(listener);
        highScoreButton = new JButton ("LeaderBoard");
        highScoreButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension (650, 450));
        setLayout (null);

        //add components
        add (enterButton);
        add (gameTitle);
        add (instructionButton);
        add (creditButton);
        add (highScoreButton);

        //set component bounds
        enterButton.setBounds (265, 200, 135, 35);
        gameTitle.setBounds (170, 100, 400, 100);
        instructionButton.setBounds (75, 340, 135, 35);
        highScoreButton.setBounds (265, 340, 135, 35);
        creditButton.setBounds (470, 340, 135, 35);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Auckland.jpeg").getImage());

        panel.setSize(650,450);
        add(panel);

    }

    public JButton getCreditButton() {
        return creditButton;
    }

    public JButton getInstructionButton() {
        return instructionButton;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public JButton getHighScoreButton() {
        return highScoreButton;
    }

    public JButton getInputQuestion() {
        return inputQuestion;
    }
}
