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

    public MainMenu(ActionListener listener) {
        //construct components
        enterButton = new JButton ("Enter Game");
        enterButton.addActionListener(listener);
        gameTitle = new JLabel ("Who wants to be a Kiwionaire?");
        gameTitle.setFont(new Font("Serif", Font.BOLD, 24));
        gameTitle.setForeground(Color.white);

        instructionButton = new JButton ("Instructions");
        instructionButton.addActionListener(listener);
        creditButton = new JButton ("Credits");
        creditButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension (650, 450));
        setLayout (null);

        //add components
        add (enterButton);
        add (gameTitle);
        add (instructionButton);
        add (creditButton);

        //set component bounds
        enterButton.setBounds (280, 200, 100, 25);
        gameTitle.setBounds (170, 100, 400, 100);
        instructionButton.setBounds (145, 340, 125, 35);
        creditButton.setBounds (395, 340, 135, 35);


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
}
