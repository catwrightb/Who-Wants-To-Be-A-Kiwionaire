package PDC.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfirmScreen extends JPanel {
    String NAME = "confirmScreen";
    private JLabel infoText;
    private JButton yesButton;
    private JButton noButton;
    private String currentLifeLine = "";

    public ConfirmScreen(String string, ActionListener listener) {

        infoText = new JLabel ("Do you want to use your "+ string +" lifeline?");
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

        infoText.setBounds (175, 160, 390, 25);
        yesButton.setBounds (140, 230, 165, 35);
        noButton.setBounds (365, 230, 165, 35);
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
