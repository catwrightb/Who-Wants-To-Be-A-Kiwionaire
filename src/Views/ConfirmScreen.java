package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfirmScreen extends JPanel {
    public String NAME = "confirmScreen";
    private JLabel infoText;
    private JLabel infoText2;

    private JButton yesButton;
    private JButton noButton;
    private String currentLifeLine = "";

    public ConfirmScreen(String string, ActionListener listener) {

        if (string.equals("exit")){
            infoText = new JLabel ("Do you want to "+ string +" your current game?");

            infoText2 = new JLabel("This will end your game and you will not be able to go back to finish later.");
            add(infoText2);
            infoText2.setForeground(Color.WHITE);
            infoText2.setBounds (90, 190, 500, 25);
        }
        else {
            infoText = new JLabel ("Do you want to use your "+ string +" lifeline?");
        }
        infoText.setForeground(Color.WHITE);


        yesButton = new JButton ("Yes");
        yesButton.addActionListener(listener);
        noButton = new JButton ("No");
        noButton.addActionListener(listener);
        //infoText.setText(string);
        infoText.setHorizontalTextPosition(JLabel.CENTER);

        currentLifeLine = string;

        //adjust size and set layout
        setPreferredSize (new Dimension(460, 362));
        setLayout (null);

        add (infoText);
        add (yesButton);
        add (noButton);

        infoText.setBounds (190, 160, 390, 25);
        yesButton.setBounds (140, 230, 165, 35);
        noButton.setBounds (365, 230, 165, 35);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Morepork.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);
    }

    public JButton getYesButton() {
        return yesButton;
    }

    public void setYesButton(JButton yesButton) {
        this.yesButton = yesButton;
    }

    public JButton getNoButton() {
        return noButton;
    }

    public void setNoButton(JButton noButton) {
        this.noButton = noButton;
    }

    public String getCurrentLifeLine() {
        return currentLifeLine;
    }

    public void setCurrentLifeLine(String currentLifeLine) {
        this.currentLifeLine = currentLifeLine;
    }
}
