package PDC.GUI;

import java.awt.*;
import javax.swing.*;

public class CorrectAnswerPanel extends JPanel {
    private JButton exitButton;
    private JLabel correctText;
    private JButton continueButton;

    public CorrectAnswerPanel() {
        //construct components
        exitButton = new JButton ("Exit");
        correctText = new JLabel ("Correct!!");
        continueButton = new JButton ("Continue");

        //adjust size and set layout
        setPreferredSize (new Dimension (460, 362));
        setLayout (null);

        //add components
        add (exitButton);
        add (correctText);
        add (continueButton);

        //set component bounds (only needed by Absolute Positioning)
        exitButton.setBounds (350, 15, 80, 30);
        correctText.setBounds (190, 125, 70, 55);
        continueButton.setBounds (170, 270, 100, 25);
    }

}