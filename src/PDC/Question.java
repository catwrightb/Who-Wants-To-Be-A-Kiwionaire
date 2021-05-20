package PDC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Question {
    //private static final String questionDatabase = "./resources/Questions.csv";
    String question;
    String correctAnswerStr;
    String correctAnswerChar;
    String aChoice;
    String bChoice;
    String cChoice;
    String dChoice;
    Integer level;

    public Question() {

    }

    public String getCorrectAnswerStr() {
        return correctAnswerStr;
    }

    public void setCorrectAnswerStr(String correctAnswerStr) {
        this.correctAnswerStr = correctAnswerStr;
    }

    public String getaChoice() {
        return aChoice;
    }

    public void setaChoice(String aChoice) {
        this.aChoice = aChoice;
    }

    public String getbChoice() {
        return bChoice;
    }

    public void setbChoice(String bChoice) {
        this.bChoice = bChoice;
    }

    public String getcChoice() {
        return cChoice;
    }

    public void setcChoice(String cChoice) {
        this.cChoice = cChoice;
    }

    public String getdChoice() {
        return dChoice;
    }

    public void setdChoice(String dChoice) {
        this.dChoice = dChoice;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswerChar() {
        return correctAnswerChar;
    }

    public void setCorrectAnswerChar(String correctAnswerChar) {
        this.correctAnswerChar = correctAnswerChar;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }






/*

    */
/**
     * reads in questions from the csv file database instantiates each question and adds them to a ArrayList
     *
     * @return ArrayList made up of Questions
     *//*

    public static ArrayList<Question> readInQuestions(){
        ArrayList<Question> questionArrayList = new ArrayList<>();

        try{
            File file = new File(questionDatabase);
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String line;

            while((line = csvReader.readLine())!= null){
                String[] data = line.split(",");
                Question q = new Question();

                q.setQuestion(data[0]);
                q.setCorrectAnswerChar(data[2]);
                q.setaChoice(data[3]);
                q.setbChoice(data[4]);
                q.setcChoice(data[5]);
                q.setdChoice(data[6]);
                //q.setAnswerChars(data[3], data[4], data[5], data[6]);
                q.setLevel(Integer.valueOf(data[7]));

                questionArrayList.add(q);
            }
            csvReader.close();

        } catch (IOException e){
            e.printStackTrace();
        }
       return questionArrayList;
    }



    */
/**
     * checks the scanned answer against the correct answer for the questions
     * then calls methods to update score
     *
     * @param question the question being asked/answered
     * @param gameUser game play user
     * @param playerAnswer scanned user keyboard input
     * @return boolean returns if answer was correct or not
     *//*

    public boolean verifyAnswer(Question question, String buttonSelected){
        String correctAnswer = question.getCorrectAnswerChar();

        if (correctAnswer.equalsIgnoreCase(buttonSelected)){
            System.out.println("Correct Answer!");
           // gameUser.upDateScore(true, question);
           // System.out.println("~Your current score is $" + gameUser.getScore()+"~");
            return true;
        }
        else{
            System.out.println("Wrong Answer :(");
            System.out.println("The correct answer was: " + correctAnswer);
            return false;
        }
    }

*/

}
