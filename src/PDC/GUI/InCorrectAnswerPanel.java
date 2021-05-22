package PDC.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InCorrectAnswerPanel extends JPanel {
    String NAME = "inCorrectAnswerPanel";
    //private JButton exitButton;
    private JLabel incorrectText;
    private JButton continueButton;
    private JLabel info;


    public InCorrectAnswerPanel(int round, ActionListener listener) {
        //construct components
        //exitButton = new JButton ("Exit");
        Font incorrectFont = new Font("Arial", Font.BOLD, 14);
        incorrectText = new JLabel ("Incorrect :(");
        incorrectText.setFont(incorrectFont);
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
        incorrectText.setBounds (280, 150, 100, 30);
        info.setBounds           (180, 180, 385, 65);
        continueButton.setBounds (270, 250, 100, 25);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
    }
}
