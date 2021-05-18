package PDC.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayerMenu extends JPanel {

    String NAME = "playerMenu";
     JButton returnPlayerButton;
     JButton newPlayerButton;
     JButton exitButton;

    public PlayerMenu(ActionListener listener) {
        //construct components
        returnPlayerButton = new JButton ("Returning Player");
        newPlayerButton = new JButton ("New Player");
        exitButton = new JButton ("Exit");

        returnPlayerButton.addActionListener(listener);
        newPlayerButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension (460, 368));
        setLayout (null);

        //add components
        add (returnPlayerButton);
        add (newPlayerButton);
        add (exitButton);

        //set component bounds (only needed by Absolute Positioning)
        returnPlayerButton.setBounds (235, 145, 165, 35);
        newPlayerButton.setBounds (45, 145, 165, 35);
        exitButton.setBounds (360, 5, 80, 35);
    }

}