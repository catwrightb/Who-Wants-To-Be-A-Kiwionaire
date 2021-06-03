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
    private JLabel inst;
    private JLabel inst2;

    public NewQuestionInputPanel(ActionListener listener) {
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
        wrongAnswe3 = new JTextField(5);
        submitButton = new JButton("Submit");
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
        add(wrongAnswe3);
        add(submitButton);
        add (exitButton);
        add (inst);
        add (inst2);

        //set component bounds (only needed by Absolute Positioning)
        questionTextArea.setBounds (75, 130, 495, 65);
        questionText.setBounds (75, 110, 265, 25);
        correctAnsText.setBounds (75, 200, 115, 25);
        wrongAns1.setBounds (345, 200, 125, 25);
        correctAns.setBounds (70, 220, 225, 25);
        wrongAnswer1.setBounds (340, 220, 225, 25);
        wrongAns2.setBounds (75, 255, 135, 25);
        wrongAns3.setBounds (345, 255, 125, 25);
        wrongAnswer2.setBounds (70, 275, 225, 25);
        wrongAnswe3.setBounds (340, 275, 225, 25);
        submitButton.setBounds (260, 325, 120, 35);
        inst.setBounds (45, 50, 595, 40);
        inst2.setBounds (95, 70, 485, 45);
        exitButton.setBounds (545, 15, 80, 35);

        ImagePanel panel = new ImagePanel(new ImageIcon("images/Lake_Taupo.jpeg").getImage());
        panel.setSize(650,450);
        add(panel);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
