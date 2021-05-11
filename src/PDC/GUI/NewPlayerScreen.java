package PDC.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class NewPlayerScreen extends JPanel {
    String NAME = "newPlayerScreen";
     //JPasswordField passwordInput;
     JLabel userNameLabel;
     JTextField userNameInput;
     //JLabel passwordLabel;
     JButton submitButton;
     JButton exitButton;
     JButton backButton;
     JLabel instructionsText;
     JLabel jcomp9;

    public NewPlayerScreen(ActionListener listener) {
        //construct components
       // passwordInput = new JPasswordField (5);
        userNameLabel = new JLabel ("User Name");
        userNameInput = new JTextField (5);

        //passwordLabel = new JLabel ("Password");
        submitButton = new JButton ("Submit");
        exitButton = new JButton ("Exit");
        backButton = new JButton ("Back");
        instructionsText = new JLabel ("Please enter a unique UserName");
        jcomp9 = new JLabel ("You cannot use spaces in your UserName :( ");

        submitButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension (450, 368));
        setLayout (null);

        //add components
        //add (passwordInput);
        add (userNameLabel);
        add (userNameInput);
        //add (passwordLabel);
        add (submitButton);
        add (exitButton);
        add (backButton);
        add (instructionsText);
        add (jcomp9);

        //set component bounds (only needed by Absolute Positioning)
       // passwordInput.setBounds (160, 155, 160, 25);
        userNameLabel.setBounds (85, 120, 100, 25);
        userNameInput.setBounds (160, 125, 160, 20);
        //passwordLabel.setBounds (85, 155, 100, 25);
        submitButton.setBounds (180, 205, 100, 25);
        exitButton.setBounds (350, 15, 80, 30);
        backButton.setBounds (25, 15, 80, 30);
        instructionsText.setBounds (130, 35, 320, 45);
        jcomp9.setBounds (100, 70, 300, 20);
    }

}