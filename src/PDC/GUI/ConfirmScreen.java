package PDC.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ConfirmScreen extends JPanel {
    String NAME = "confirmScreen";
    private JLabel infoText;
    private JButton yesButton;
    private JButton noButton;

    public ConfirmScreen(String string) {

        infoText = new JLabel ("");
        yesButton = new JButton ("Yes");
        //yesButton.addActionListener(listener);
        noButton = new JButton ("No");
       // noButton.addActionListener(listener);
        infoText.setText(string);
        infoText.setHorizontalTextPosition(JLabel.CENTER);


        //adjust size and set layout
        setPreferredSize (new Dimension(460, 362));
        setLayout (null);

        add (infoText);
        add (yesButton);
        add (noButton);

        infoText.setBounds (90, 65, 345, 85);
        yesButton.setBounds (110, 165, 100, 25);
        noButton.setBounds (260, 165, 100, 25);
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
}
