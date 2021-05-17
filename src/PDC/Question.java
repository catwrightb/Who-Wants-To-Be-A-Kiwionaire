package PDC;
import PDC.UserPackage.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Question {
    private static final String questionDatabase = "./resources/Questions.csv";
    String question;
    String correctAnswer;
    String aChoice;
    String bChoice;
    String cChoice;
    String dChoice;
    //String[] answerChars;
    Integer level;

    public Question() {
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

//    public String[] getAnswerChars() {
//        return answerChars;
//    }

//   // public void setAnswerChars(String a, String b, String c, String d) {
//        this.answerChars = new String[]{a, b, c, d};
//    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }




    /**
     * reads in questions from the csv file database instantiates each question and adds them to a ArrayList
     *
     * @return ArrayList made up of Questions
     */
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
                q.setCorrectAnswer(data[2]);
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



    /**
     * checks the scanned answer against the correct answer for the questions
     * then calls methods to update score
     *
     * @param question the question being asked/answered
     * @param gameUser game play user
     * @param playerAnswer scanned user keyboard input
     * @return boolean returns if answer was correct or not
     */
    public boolean verifyUserAnswer(Question question, String playerAnswer, User gameUser){
        String correctAnswer = question.getCorrectAnswer();

        if (correctAnswer.equalsIgnoreCase(playerAnswer)){
            System.out.println("Correct Answer!");
            gameUser.upDateScore(true, question);
            System.out.println("~Your current score is $" + gameUser.getScore()+"~");
            return true;
        }
        else{
            System.out.println("Wrong Answer :(");
            System.out.println("The correct answer was: " + correctAnswer);
            return false;
        }
    }

//    /**
//     * toString to print out question and possible answers with ABCD options
//     *
//     * @return string
//     */
//    @Override
//    public String toString() {
//        //using enum to print question chars
//
//            String ABCD = Letters.A.name() + Letters.B.name() + Letters.C.name() + Letters.D.name();
//            StringBuilder string = new StringBuilder("Question: " + level +"\n");
//            string.append(question);
//            string.append("\n");
//
//            for (int i = 0; i < 4; i++) {
//                string.append(ABCD.charAt(i));
//                string.append(": ").append(answerChars[i]);
//                string.append("\n");
//            }
//
//            string.append("> ");
//
//            return string.toString();
//
//
//    }
}
