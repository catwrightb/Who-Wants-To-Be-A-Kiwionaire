package PDC.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class NewPlayerScreen extends JPanel {
    String NAME = "newPlayerScreen";
     //JPasswordField passwordInput;
     JLabel userNameLabel, label2, label3;
     JTextField userNameInput;
     //JLabel passwordLabel;
     JButton submitButton;
     JButton exitButton;
     JButton backButton;
     JLabel instructionsText;
     //JLabel jcomp9;

    public NewPlayerScreen(ActionListener listener) {
        //construct components
       // passwordInput = new JPasswordField (5);
        userNameLabel = new JLabel ("UserName: ");
        userNameInput = new JTextField (5);

        //passwordLabel = new JLabel ("Password");
        submitButton = new JButton ("Submit");
        exitButton = new JButton ("Exit");
        backButton = new JButton ("Back");
        instructionsText = new JLabel ("Please enter a unique UserName");
        label2 = new JLabel ("You cannot use spaces in your UserName :(");
        label3 = new JLabel ("But feel free to use special character, letters and numbers.");
        //jcomp9 = new JLabel ("You cannot use spaces in your UserName :( ");

        exitButton.addActionListener(listener);
        backButton.addActionListener(listener);
        submitButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension (460, 368));
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
        add (label2);
        add (label3);
        //add (jcomp9);

        //set component bounds (only needed by Absolute Positioning)
       // passwordInput.setBounds (160, 155, 160, 25);
        userNameLabel.setBounds (170, 185, 100, 25);
        userNameInput.setBounds (270, 185, 180, 25);
        //passwordLabel.setBounds (85, 155, 100, 25);
        submitButton.setBounds (260, 235, 100, 25);
        exitButton.setBounds (545, 15, 80, 35);
        backButton.setBounds (25, 15, 80, 35);
        instructionsText.setBounds (220, 70, 220, 30);
        label2.setBounds (175, 100, 340, 35);
        label3.setBounds (140, 135, 390, 25);
        //jcomp9.setBounds (100, 70, 300, 20);
    }

}