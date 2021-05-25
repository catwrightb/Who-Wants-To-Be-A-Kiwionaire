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
        returnPlayerButton.setBounds (355, 160, 165, 35);
        newPlayerButton.setBounds (125, 160, 165, 35);
        exitButton.setBounds (545, 15, 80, 35);


        ImagePanel panel = new ImagePanel(new ImageIcon("images/Lake_Taupo.jpeg").getImage());

        panel.setSize(650,450);
        add(panel);
    }

}