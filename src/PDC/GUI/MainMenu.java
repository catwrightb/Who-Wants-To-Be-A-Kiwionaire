package PDC.GUI;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JPanel {
    String NAME = "mainMenu";
    JButton enterButton;
    private JLabel gameTitle;

    public MainMenu() {
        //construct components
        enterButton = new JButton ("Enter Game");
        gameTitle = new JLabel ("Who wants to be a Kiwionaire?");

        //adjust size and set layout
        setPreferredSize (new Dimension (450, 368));
        setLayout (null);

        //add components
        add (enterButton);
        add (gameTitle);

        //set component bounds (only needed by Absolute Positioning)
        enterButton.setBounds (145, 315, 125, 30);
        gameTitle.setBounds (130, 95, 275, 90);
    }

}
