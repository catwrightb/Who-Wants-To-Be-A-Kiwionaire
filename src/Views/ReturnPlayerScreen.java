package Views;

//import Models.UserPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReturnPlayerScreen extends JPanel {
    public String NAME = "returnPlayerScreen";
    //private ReturnUser returnUser;
     private JPasswordField passwordInput;
    private JLabel userNameLabel;
    public JTextField userNameInput;
    private JLabel passwordLabel;
    private JButton submitButton;
    private JButton exitButton;
     private JButton backButton;
     private JLabel instructionsText;


    public ReturnPlayerScreen(ActionListener listener) {
        //construct components
        //passwordInput = new JPasswordField (5);
        userNameLabel = new JLabel ("UserName:");
        userNameLabel.setForeground(Color.WHITE);
        userNameInput = new JTextField (5);
        //passwordLabel = new JLabel ("Password");
        submitButton = new JButton ("Submit");
        exitButton = new JButton ("Exit");
        backButton = new JButton ("Back");
        instructionsText = new JLabel ("Please enter your saved UserName");
        instructionsText.setForeground(Color.WHITE);
       // forgotPasswordButton = new JButton ("Forgot Password");


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
        //add (forgotPasswordButton);

        exitButton.addActionListener(listener);
        backButton.addActionListener(listener);
        submitButton.addActionListener(listener);

        //set component bounds (only needed by Absolute Positioning)
       // passwordInput.setBounds (160, 155, 160, 25);
        userNameLabel.setBounds (190, 185, 100, 25);
        userNameInput.setBounds (270, 185, 180, 25);
        //passwordLabel.setBounds (85, 155, 100, 25);
        submitButton.setBounds (260, 235, 100, 25);
        exitButton.setBounds (545, 15, 80, 35);
        backButton.setBounds (25, 15, 80, 35);
        instructionsText.setBounds (210, 135, 390, 25);
        //forgotPasswordButton.setBounds (155, 245, 150, 25);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Lake_Taupo.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JTextField getUserNameInput() {
        return userNameInput;
    }
}