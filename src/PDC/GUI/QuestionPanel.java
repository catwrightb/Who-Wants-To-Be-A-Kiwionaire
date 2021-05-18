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

    private JButton fiftyFifty;
    private JButton phoneFriend;
    private JButton askAudience;

    public QuestionPanel(GameApplication game, ActionListener listener) {

        Question currentQuestion = game.getCurrentQuestion();
        exitButton = new JButton ("Exit");
        question = new JLabel (currentQuestion.getQuestion());

        //buttons A & B
        if (!currentQuestion.getaChoice().isEmpty() && !currentQuestion.getbChoice().isEmpty()){
            buttonA = new JButton (currentQuestion.getaChoice());
            buttonA.addActionListener(listener);
            add (buttonA);
            buttonA.setBounds (65, 215, 140, 35);

            buttonB = new JButton (currentQuestion.getbChoice());
            buttonB.addActionListener(listener);
            add (buttonB);
            buttonB.setBounds (240, 215, 140, 35);
        }

        //buttons C & D
        if (!currentQuestion.getcChoice().isEmpty() && !currentQuestion.getdChoice().isEmpty()){
            buttonC = new JButton (currentQuestion.getcChoice());
            buttonC.addActionListener(listener);
            add (buttonC);
            buttonC.setBounds (65, 260, 140, 35);

            buttonD = new JButton (currentQuestion.getdChoice());
            buttonD.addActionListener(listener);
            add (buttonD);
            buttonD.setBounds (240, 260, 140, 35);
        }


        //lifeline buttons
        if (game.isHasFiftyFifty()){
            fiftyFifty = new JButton ("50/50");
            fiftyFifty.addActionListener(listener);
            this.add(fiftyFifty);
            fiftyFifty.setBounds (70, 150, 60, 40);
        }

        if (game.isAskTheAudience()){
            askAudience = new JButton ("");
            askAudience.addActionListener(listener);
            this.add(askAudience);
            askAudience.setBounds (315, 150, 60, 40);
        }

        if (game.isPhoneAFriend()){
            phoneFriend = new JButton ("");
            phoneFriend.addActionListener(listener);
            this.add(phoneFriend);
            phoneFriend.setBounds (190, 150, 60, 40);
        }


        //adjust size and set layout
        setPreferredSize (new Dimension (460, 362));
        setLayout (null);

        //add components
        add (exitButton);
        add (question);

        //set component bounds (only needed by Absolute Positioning)
        exitButton.setBounds (350, 15, 80, 30);
        question.setBounds (45, 55, 365, 85);

        this.setVisible(true);

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
