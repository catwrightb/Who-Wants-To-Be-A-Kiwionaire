package Views;

import Database.QuestionDB;

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
    private JTextField wrongAnswer3;
    private JButton submitButton;
    private JButton exitButton;
    private JLabel inst;
    private JLabel inst2;

    private QuestionDB questionDB;

    public NewQuestionInputPanel(ActionListener listener) {
        questionDB = new QuestionDB();

        //construct components
        questionTextArea = new JTextArea(5, 5);
        questionText = new JLabel("Question:");
        questionText.setForeground(Color.WHITE);
        correctAnsText = new JLabel("Correct Answer:");
        correctAnsText.setForeground(Color.WHITE);
        wrongAns1 = new JLabel("Wrong Answer 1:");
        wrongAns1.setForeground(Color.WHITE);
        correctAns = new JTextField(5);
        wrongAnswer1 = new JTextField(5);
        wrongAns2 = new JLabel("Wrong Answer 2:");
        wrongAns2.setForeground(Color.WHITE);
        wrongAns3 = new JLabel("Wrong answer 3:");
        wrongAns3.setForeground(Color.WHITE);
        wrongAnswer2 = new JTextField(5);
        wrongAnswer3 = new JTextField(5);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> addQuestionToDB());
        exitButton = new JButton ("Exit");
        exitButton.addActionListener(listener);
        submitButton.addActionListener(listener);
        inst = new JLabel ("Input your question, correct answer, and wrong answers below then click the submit button.");
        inst.setForeground(Color.WHITE);
        inst2 = new JLabel ("If you decide you no longer want to input a Question click the Exit button.");
        inst2.setForeground(Color.WHITE);

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
        add(wrongAnswer3);
        add(submitButton);
        add (exitButton);
        add (inst);
        add (inst2);

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
        wrongAnswer3.setBounds(70, 360, 225, 25);
        submitButton.setBounds(270, 395, 120, 35);
        exitButton.setBounds (545, 15, 80, 35);
    }

    private void addQuestionToDB() {
        String question = questionTextArea.getText();
        String correctAnswer = correctAns.getText();
        String[] wrongAnswers = new String[3];
        wrongAnswers[0] = wrongAnswer1.getText();
        wrongAnswers[1] = wrongAnswer2.getText();
        wrongAnswers[2] = wrongAnswer3.getText();

        questionDB.addQuestionToGame(question, correctAnswer, wrongAnswers);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
