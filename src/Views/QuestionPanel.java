package Views;

import Models.GameApplication;
import Models.Question;
import jdk.nashorn.internal.ir.IfNode;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.*;

public class QuestionPanel extends JPanel{
    public String NAME = "questionPanel";
    private JButton exitButton;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JLabel question;
    private JLabel stats;
    private JButton fiftyFifty;
    private JButton phoneFriend;
    private JButton askAudience;

    public QuestionPanel(GameApplication game, ActionListener listener) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        Question currentQuestion = game.getCurrentQuestion();
        exitButton = new JButton ("Exit");
        exitButton.addActionListener(listener);
        question = new JLabel ("<html>" +currentQuestion.getQuestion() + "<html>");
        Font questionFont = new Font("Serif", Font.PLAIN, 16);
        question.setFont(questionFont);
        question.setForeground(Color.WHITE);
        stats = new JLabel("Score: $" + decimalFormat.format(game.getGameUser().getScore())
                + " | Question: " +game.getGameRounds());
        stats.setFont(questionFont);
        stats.setForeground(Color.WHITE);

        JButtonRandom(game);

        //TODO make sure buttons are large enough
        //buttons A & B
        if (!currentQuestion.getaChoice().equals(" ") && !currentQuestion.getbChoice().equals(" ")){
            //buttonA = new JButton (currentQuestion.getaChoice());
            buttonA.addActionListener(listener);
            add (buttonA);
            buttonA.setBounds (100, 270, 200, 35);

            //buttonB = new JButton (currentQuestion.getbChoice());
            buttonB.addActionListener(listener);
            add (buttonB);
            buttonB.setBounds (365, 270, 200, 35);
        }

        //buttons C & D
        if (!currentQuestion.getcChoice().equals(" ") && !currentQuestion.getdChoice().equals(" ")){
            //buttonC = new JButton (currentQuestion.getcChoice());
            buttonC.addActionListener(listener);
            add (buttonC);
            buttonC.setBounds (100, 335, 200, 35);

            //buttonD = new JButton (currentQuestion.getdChoice());
            buttonD.addActionListener(listener);
            add (buttonD);
            buttonD.setBounds (365, 335, 200, 35);
        }


        //lifeline buttons
        if (game.isHasFiftyFifty()){
            fiftyFifty = new JButton ("50/50");
            fiftyFifty.addActionListener(listener);
            this.add(fiftyFifty);
            fiftyFifty.setBounds (130, 200, 100, 40);
            //fiftyFifty.setBounds (130, 200, 120, 40);
        }

        if (game.isAskTheAudience()){
            askAudience = new JButton ("Audience");
            askAudience.addActionListener(listener);
            this.add(askAudience);
            askAudience.setBounds (280, 200, 100, 40);
            //askAudience.setBounds (290, 200, 120, 40);
        }

        if (game.isPhoneAFriend()){
            phoneFriend = new JButton ("Phone");
            phoneFriend.addActionListener(listener);
            this.add(phoneFriend);
            phoneFriend.setBounds (430, 200, 100, 40);
            //phoneFriend.setBounds (460, 200, 120, 40);
        }


        //adjust size and set layout
        setPreferredSize (new Dimension (460, 362));
        setLayout (null);

        //add components
        add (exitButton);
        add (question);
        add(stats);

        //set component bounds (only needed by Absolute Positioning)
        exitButton.setBounds (545, 15, 80, 35);
        question.setBounds (50, 40, 400, 150);
        stats.setBounds(35, 15, 470, 35);

        this.setVisible(true);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Milford.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);

    }

    public void JButtonRandom(GameApplication game){
        Question currentQuestion = game.getCurrentQuestion();
        Random random = new Random();

        if (!currentQuestion.getaChoice().equals(" ") && !currentQuestion.getbChoice().equals(" ")
        && !currentQuestion.getcChoice().equals(" ") && !currentQuestion.getdChoice().equals(" ")){
            int randomNumber = random.nextInt(4);

            if (randomNumber == 1){
                this.buttonA = new JButton (currentQuestion.getaChoice()); //a
                this.buttonB = new JButton(currentQuestion.getbChoice()); //b
                this.buttonC = new JButton (currentQuestion.getcChoice()); //c
                this.buttonD = new JButton(currentQuestion.getdChoice()); //d
            }
            else if (randomNumber == 2){
                this.buttonA = new JButton (currentQuestion.getcChoice()); //c
                this.buttonB = new JButton(currentQuestion.getbChoice()); //b
                this.buttonC = new JButton (currentQuestion.getaChoice()); //a
                this.buttonD = new JButton(currentQuestion.getdChoice()); //d
            }
            else if (randomNumber == 3){
                this.buttonA = new JButton (currentQuestion.getbChoice()); //b
                this.buttonB = new JButton(currentQuestion.getcChoice()); //c
                this.buttonC = new JButton (currentQuestion.getdChoice()); //d
                this.buttonD = new JButton(currentQuestion.getaChoice()); //a
            }
            else {
                this.buttonA = new JButton (currentQuestion.getcChoice()); //c
                this.buttonB = new JButton(currentQuestion.getaChoice()); //a
                this.buttonC = new JButton (currentQuestion.getdChoice()); //d
                this.buttonD = new JButton(currentQuestion.getbChoice()); //b
            }
        }
        else if (!currentQuestion.getaChoice().equals(" ") && !currentQuestion.getbChoice().equals(" ")){
            this.buttonA = new JButton (currentQuestion.getaChoice());
            this.buttonB = new JButton(currentQuestion.getbChoice());
        }
        else if (!currentQuestion.getcChoice().equals(" ") && !currentQuestion.getdChoice().equals(" ")){
            this.buttonC = new JButton (currentQuestion.getcChoice());
            this.buttonD = new JButton(currentQuestion.getdChoice());
        }



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
