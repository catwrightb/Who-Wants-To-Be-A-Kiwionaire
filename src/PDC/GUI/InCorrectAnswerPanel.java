package PDC.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InCorrectAnswerPanel extends JPanel {
    String NAME = "inCorrectAnswerPanel";
    private JButton exitButton;
    private JLabel incorrectText;
    private JButton continueButton;
    private JLabel info;

    //TODO adjust placement of componets on JLabel

    public InCorrectAnswerPanel(int round, ActionListener listener) {
        //construct components
        //exitButton = new JButton ("Exit");
        incorrectText = new JLabel ("Incorrect :(");
        info = new JLabel ("Please press the continue button to move on.");
        continueButton = new JButton ("Continue");

       // exitButton.addActionListener(listener);
        continueButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize (new Dimension (460, 362));
        setLayout (null);

        //add components
        //add (exitButton);
        add (incorrectText);
        add (continueButton);
        add (info);

        //set component bounds (only needed by Absolute Positioning)
        //exitButton.setBounds (350, 15, 80, 30);
        incorrectText.setBounds (170, 280, 325, 30);
        continueButton.setBounds (270, 310, 100, 25);
        info.setBounds (180, 165, 385, 65);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
    }
}
