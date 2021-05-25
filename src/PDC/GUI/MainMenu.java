package PDC.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JPanel {
    String NAME = "mainMenu";
    JButton enterButton;
    private JLabel gameTitle;

    public MainMenu(ActionListener listener) {
        //construct components
        enterButton = new JButton ("Enter Game");
        enterButton.addActionListener(listener);
        gameTitle = new JLabel ("Who wants to be a Kiwionaire?");
        gameTitle.setFont(new Font("Serif", Font.BOLD, 24));
        gameTitle.setForeground(Color.white);

        //adjust size and set layout
        setPreferredSize (new Dimension (650, 450));
        setLayout (null);

        //add components
        add (enterButton);
        add (gameTitle);

        //set component bounds
        enterButton.setBounds (260, 200, 100, 25);
        gameTitle.setBounds (150, 100, 400, 100);


        ImagePanel panel = new ImagePanel(new ImageIcon("images/Auckland.jpeg").getImage());

        panel.setSize(650,450);
        add(panel);

    }

}
