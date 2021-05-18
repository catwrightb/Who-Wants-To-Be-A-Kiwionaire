package PDC.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JPanel {
    String NAME = "mainMenu";
    JButton enterButton;
    private JLabel gameTitle;

    public MainMenu(ActionListener listener) {
        //construct components
        enterButton = new JButton ("Enter Game");
        enterButton.addActionListener(listener);
        gameTitle = new JLabel ("Who wants to be a Kiwionaire?");

        //adjust size and set layout
        setPreferredSize (new Dimension (650, 450));
        setLayout (null);

        //add components
        add (enterButton);
        add (gameTitle);

        //set component bounds (only needed by Absolute Positioning)
        enterButton.setBounds (260, 235, 100, 25);
        gameTitle.setBounds (215, 135, 220, 30);
    }

}
