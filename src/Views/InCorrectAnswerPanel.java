package Views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InCorrectAnswerPanel extends JPanel {
    public String NAME = "inCorrectAnswerPanel";
    //private JButton exitButton;
    private JLabel incorrectText;
    private JLabel correctAnswerText;
    private JButton continueButton;
    private JLabel info;


    public InCorrectAnswerPanel(int round, String correctAnswer, ActionListener listener) {
        //construct components
        //exitButton = new JButton ("Exit");
        Font incorrectFont = new Font("Serif", Font.PLAIN, 16);
        incorrectText = new JLabel ("Incorrect :( ");
        incorrectText.setForeground(Color.WHITE);
        incorrectText.setFont(incorrectFont);
        correctAnswerText = new JLabel("The correct answer was "+ correctAnswer+ ".");
        correctAnswerText.setForeground(Color.WHITE);
        correctAnswerText.setFont(incorrectFont);
        info = new JLabel ("Please press the continue button to move on.");
        info.setForeground(Color.WHITE);
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
        add(correctAnswerText);

        //set component bounds (only needed by Absolute Positioning)
        //exitButton.setBounds (350, 15, 80, 30);
        incorrectText.setBounds(270, 120,100,35);
        correctAnswerText.setBounds (180, 150, 550, 30);
        info.setBounds           (180, 180, 385, 65);
        continueButton.setBounds (270, 250, 100, 25);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Kiwi.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setContinueButton(JButton continueButton) {
        this.continueButton = continueButton;
    }
}
