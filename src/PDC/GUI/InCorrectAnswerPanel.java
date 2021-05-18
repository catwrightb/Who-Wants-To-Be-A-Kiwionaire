package PDC.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InCorrectAnswerPanel extends JPanel {
    String NAME = "inCorrectAnswerPanel";
    private JButton exitButton;
    private JLabel incorrectText;
    private JButton continueButton;

    public InCorrectAnswerPanel(int round, ActionListener listener) {
        //construct components
        //exitButton = new JButton ("Exit");
        incorrectText = new JLabel ("Incorrect :( you've lost at question " + round);
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

        //set component bounds (only needed by Absolute Positioning)
        //exitButton.setBounds (350, 15, 80, 30);
        incorrectText.setBounds (190, 125, 70, 55);
        continueButton.setBounds (185, 260, 100, 25);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
    }
}
