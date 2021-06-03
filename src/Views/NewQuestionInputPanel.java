package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewQuestionInputPanel extends JPanel {
    public String NAME = "newQuestionPanel";
    private JTextArea questionTextArea;
    private JLabel questionText;
    private JLabel correctAnsText;
    private JLabel wrongAns1;
    private JTextField correctAns;
    private JTextField wrongAnswer1;
    private JLabel wrongAns2;
    private JLabel wrongAns3;
    private JTextField wrongAnswer2;
    private JTextField wrongAnswe3;
    private JButton submitButton;
    private JButton exitButton;

    public NewQuestionInputPanel(ActionListener listener) {
        //construct components
        questionTextArea = new JTextArea(5, 5);
        questionText = new JLabel("Question:");
        correctAnsText = new JLabel("Correct Answer:");
        wrongAns1 = new JLabel("Wrong Answer 1:");
        correctAns = new JTextField(5);
        wrongAnswer1 = new JTextField(5);
        wrongAns2 = new JLabel("Wrong Answer 2:");
        wrongAns3 = new JLabel("Wrong answer 3:");
        wrongAnswer2 = new JTextField(5);
        wrongAnswe3 = new JTextField(5);
        submitButton = new JButton("Submit");
        exitButton = new JButton ("Exit");
        exitButton.addActionListener(listener);

        //adjust size and set layout
        setPreferredSize(new Dimension(656, 443));
        setLayout(null);

        //add components
        add(questionTextArea);
        add(questionText);
        add(correctAnsText);
        add(wrongAns1);
        add(correctAns);
        add(wrongAnswer1);
        add(wrongAns2);
        add(wrongAns3);
        add(wrongAnswer2);
        add(wrongAnswe3);
        add(submitButton);
        add (exitButton);

        //set component bounds (only needed by Absolute Positioning)
        questionTextArea.setBounds(75, 80, 495, 65);
        questionText.setBounds(75, 55, 265, 25);
        correctAnsText.setBounds(75, 155, 115, 25);
        wrongAns1.setBounds(75, 215, 125, 25);
        correctAns.setBounds(70, 175, 225, 25);
        wrongAnswer1.setBounds(70, 235, 225, 25);
        wrongAns2.setBounds(75, 280, 135, 25);
        wrongAns3.setBounds(75, 340, 125, 25);
        wrongAnswer2.setBounds(70, 300, 225, 25);
        wrongAnswe3.setBounds(70, 360, 225, 25);
        submitButton.setBounds(270, 395, 120, 35);
        exitButton.setBounds (545, 15, 80, 35);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
