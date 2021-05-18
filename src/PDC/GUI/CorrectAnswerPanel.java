package PDC.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CorrectAnswerPanel extends JPanel {
    String NAME = "correctAnswerPanel";
    private JButton exitButton;
    private JLabel correctText;
    public JButton continueButton;

    public CorrectAnswerPanel(ActionListener listener) {
        //construct components
        exitButton = new JButton ("Exit");
        correctText = new JLabel ("Correct!!");
        continueButton = new JButton ("Continue");

        exitButton.addActionListener(listener);
        continueButton.addActionListener(listener);

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

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JLabel getCorrectText() {
        return correctText;
    }

    public void setCorrectText(JLabel correctText) {
        this.correctText = correctText;
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
    }
}