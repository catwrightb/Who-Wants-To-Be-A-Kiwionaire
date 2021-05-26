package PDC.GUI;

import javax.swing.*;
import java.awt.*;

public class CreditPanel extends JPanel {
    String NAME = "CreditPanel";
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JButton backButton;

    public CreditPanel() {
        //construct components
        jcomp1 = new JLabel ("This game was created by Catharine Baker and Jacob Tupe.");
        jcomp1.setForeground(Color.WHITE);
        jcomp2 = new JLabel ("We hope you enjoy the game and thanks for playing! :)");
        jcomp2.setForeground(Color.WHITE);
        backButton = new JButton ("Back");

        //adjust size and set layout
        setPreferredSize (new Dimension (663, 456));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (145, 120, 380, 55);
        jcomp2.setBounds (160, 170, 425, 50);

        backButton.setBounds (25, 15, 80, 35);
        add(backButton);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Rockarch.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
