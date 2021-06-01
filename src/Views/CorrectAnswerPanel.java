package Views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CorrectAnswerPanel extends JPanel {
    public String NAME = "correctAnswerPanel";
    private JButton exitButton;
    private JLabel correctText;
    public JButton continueButton;


    public CorrectAnswerPanel(ActionListener listener) {
        //construct components
        exitButton = new JButton ("Exit");
        Font correctFont = new Font("Serif", Font.BOLD, 14);
        correctText = new JLabel ("Correct!!");
        correctText.setForeground(Color.WHITE);
        correctText.setFont(correctFont);
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
        exitButton.setBounds (545, 15, 80, 35);
        correctText.setBounds (300, 180, 100, 30);
        continueButton.setBounds (270, 240, 120, 30);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Sheep.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);
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