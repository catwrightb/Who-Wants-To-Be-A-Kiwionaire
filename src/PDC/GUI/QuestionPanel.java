package PDC.GUI;

import PDC.GameApplication;
import PDC.Question;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QuestionPanel extends JPanel{
    String NAME = "questionPanel";
    private JButton exitButton;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JLabel question;
    //private JButton submitButton;
    private JButton fiftyFifty;
    private JButton phoneFriend;
    private JButton askAudience;

    public QuestionPanel(GameApplication game, ActionListener listener) {

        Question q = game.selectQuestion();
        exitButton = new JButton ("Exit");

        if (!q.getaChoice().isEmpty() && !q.getbChoice().isEmpty()
                && !q.getcChoice().isEmpty() && !q.getdChoice().isEmpty()
                && game.isHasFiftyFifty() ) {

        }


        buttonA = new JButton (q.getaChoice());
        buttonB = new JButton (q.getbChoice());
        buttonC = new JButton (q.getcChoice());
        buttonD = new JButton (q.getdChoice());
        question = new JLabel (q.getQuestion());
        //submitButton = new JButton ("Submit");

        //fifty logic
        if (game.isHasFiftyFifty()){
            fiftyFifty = new JButton ("50/50");
            fiftyFifty.addActionListener(listener);
        }
        else if (!game.isHasFiftyFifty()){
            fiftyFifty.setOpaque(true);
            fiftyFifty.setEnabled(false);
        }


        phoneFriend = new JButton ("");
        askAudience = new JButton ("");

        //adjust size and set layout
        setPreferredSize (new Dimension (460, 362));
        setLayout (null);

        //add components
        add (exitButton);
        add (buttonA);
        add (buttonB);
        add (buttonC);
        add (buttonD);
        add (question);
        //add (submitButton);
        add (fiftyFifty);
        add (phoneFriend);
        add (askAudience);


        //set component bounds (only needed by Absolute Positioning)
        exitButton.setBounds (350, 15, 80, 30);
        buttonA.setBounds (65, 215, 140, 35);
        buttonB.setBounds (240, 215, 140, 35);
        buttonC.setBounds (65, 260, 140, 35);
        buttonD.setBounds (240, 260, 140, 35);
        question.setBounds (45, 55, 365, 85);
        //submitButton.setBounds (175, 320, 100, 25);
        fiftyFifty.setBounds (70, 150, 60, 40);
        phoneFriend.setBounds (190, 150, 60, 40);
        askAudience.setBounds (315, 150, 60, 40);

    }


    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getButtonA() {
        return buttonA;
    }

    public JButton getButtonB() {
        return buttonB;
    }

    public JButton getButtonC() {
        return buttonC;
    }

    public JButton getButtonD() {
        return buttonD;
    }

    public JButton getFiftyFifty() {
        return fiftyFifty;
    }

    public void setFiftyFifty(JButton fiftyFifty) {
        this.fiftyFifty = fiftyFifty;
    }

    public JButton getPhoneFriend() {
        return phoneFriend;
    }

    public void setPhoneFriend(JButton phoneFriend) {
        this.phoneFriend = phoneFriend;
    }

    public JButton getAskAudience() {
        return askAudience;
    }

    public void setAskAudience(JButton askAudience) {
        this.askAudience = askAudience;
    }
}
