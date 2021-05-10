package PDC.GUI;

import java.awt.*;
import javax.swing.*;

public class InCorrectAnswerPanel extends JPanel {
    private JButton exitButton;
    private JLabel incorrectText;
    private JButton continueButton;

    public InCorrectAnswerPanel() {
        //construct components
        exitButton = new JButton ("Exit");
        incorrectText = new JLabel ("Incorrect :(");
        continueButton = new JButton ("Continue");

        //adjust size and set layout
        setPreferredSize (new Dimension (452, 362));
        setLayout (null);

        //add components
        add (exitButton);
        add (incorrectText);
        add (continueButton);

        //set component bounds (only needed by Absolute Positioning)
        exitButton.setBounds (350, 15, 80, 30);
        incorrectText.setBounds (190, 125, 70, 55);
        continueButton.setBounds (185, 260, 100, 25);
    }


}
