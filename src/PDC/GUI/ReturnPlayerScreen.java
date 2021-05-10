package PDC.GUI;

import PDC.UserPackage.ReturnUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ReturnPlayerScreen extends JPanel {
    String NAME = "returnPlayerScreen";
    ReturnUser returnUser;
     JPasswordField passwordInput;
     JLabel userNameLabel;
     JTextField userNameInput;
     JLabel passwordLabel;
     JButton submitButton;
     JButton exitButton;
     JButton backButton;
     JLabel instructionsText;
     JButton forgotPasswordButton;

    public ReturnPlayerScreen(ActionListener listener) {
        //construct components
        //passwordInput = new JPasswordField (5);
        userNameLabel = new JLabel ("User Name");
        userNameInput = new JTextField (5);
        //passwordLabel = new JLabel ("Password");
        submitButton = new JButton ("Submit");
        exitButton = new JButton ("Exit");
        backButton = new JButton ("Back");
        instructionsText = new JLabel ("Please enter your saved UserName");
       // forgotPasswordButton = new JButton ("Forgot Password");

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
        //add (forgotPasswordButton);

        submitButton.addActionListener(listener);

        //set component bounds (only needed by Absolute Positioning)
       // passwordInput.setBounds (160, 155, 160, 25);
        userNameLabel.setBounds (85, 120, 100, 25);
        userNameInput.setBounds (160, 125, 160, 20);
        //passwordLabel.setBounds (85, 155, 100, 25);
        submitButton.setBounds (180, 205, 100, 25);
        exitButton.setBounds (350, 15, 80, 30);
        backButton.setBounds (25, 15, 80, 30);
        instructionsText.setBounds (70, 55, 320, 45);
        //forgotPasswordButton.setBounds (155, 245, 150, 25);
    }

}