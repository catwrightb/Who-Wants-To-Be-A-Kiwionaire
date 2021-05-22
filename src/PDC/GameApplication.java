package PDC;

import Database.QuestionDB;
import PDC.UserPackage.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameApplication {

    private String userAnswer;
    private boolean running;
    public ArrayList<Question> questionArrayList;
    private int gameRounds;
    private boolean gameWon;
    public Question currentQuestion;

    //will need to store lifelines
    private boolean hasFiftyFifty;
    private boolean AskTheAudience;
    private boolean phoneAFriend;

    private static User gameUser;
    private final String FIFTY_FIFTY = "Fifty Fifty";
    private final String ASK_THE_AUDIENCE = "Ask The Audience";
    private final String PHONE_A_FRIEND = "Phone A Friend";


    public GameApplication(){
        //questions and rounds
        //this.questionArrayList = readInQuestions();
        this.questionArrayList = new QuestionDB().questionListCreator();
        this.gameRounds = 1;

        //linelife
        this.hasFiftyFifty = true;
        this.AskTheAudience = true;
        this.phoneAFriend = true;

        //Game running
        this.running = true;
        this.gameWon = false;
    }


    //gets the current game rounds
     public int getGameRounds(){
         return this.gameRounds;
     }


     public void useFiftyFiftyLifeLine(){
        Question currentQ = this.getCurrentQuestion();

        if (currentQ.correctAnswerChar.equals("A") || currentQ.correctAnswerChar.equals("B") ){
            currentQ.cChoice = "";
            currentQ.dChoice = "";
        }
        else if (currentQ.correctAnswerChar.equals("C") || currentQ.correctAnswerChar.equals("D") ){
            currentQ.aChoice = "";
            currentQ.bChoice = "";
        }

     }

     //TODO complete askAudience
     // Temporary solution for ask audience
     public void useAskAudience(){
         Question currentQ = this.getCurrentQuestion();
         StringBuilder audienceDecision = new StringBuilder("The audience think the answer is:\n");

         Random rand = new Random();
         int chance = rand.nextInt(100);

         if (chance >= 33) {
             audienceDecision.append(currentQ.getCorrectAnswerStr());
         } else {
             int randomAnswer = rand.nextInt(4);

             // Check if no fifty fifty was used before this lifeline
             if (!currentQ.getaChoice().isEmpty() && !currentQ.getbChoice().isEmpty()
                     && !currentQ.getcChoice().isEmpty() && !currentQ.getdChoice().isEmpty()){
                 if (randomAnswer == 0) {
                     audienceDecision.append(currentQ.getaChoice());
                 }
                 else if (randomAnswer == 1) {
                     audienceDecision.append(currentQ.getbChoice());
                 }
                 else if (randomAnswer == 2) {
                     audienceDecision.append(currentQ.getcChoice());
                 }
                 else {
                     audienceDecision.append(currentQ.getdChoice());
                 }
             }
             // Check if choice A & B are available
             else if (!currentQ.getaChoice().isEmpty() && !currentQ.getbChoice().isEmpty()) {
                 randomAnswer = rand.nextInt(2);
                 if (randomAnswer == 1){
                     audienceDecision.append(currentQ.getaChoice());
                 }else {
                     audienceDecision.append(currentQ.getbChoice());
                 }
             }
             // Otherwise pick between choice C & D randomly
             else {
                 randomAnswer = rand.nextInt(2);
                 if (randomAnswer == 1){
                     audienceDecision.append(currentQ.getcChoice());
                 }else {
                     audienceDecision.append(currentQ.getdChoice());
                 }
             }
         }
         JOptionPane.showMessageDialog(null, audienceDecision.toString(), "AUDIENCE",
                 JOptionPane.QUESTION_MESSAGE);
     }

    //TODO complete phoneAFriend
    public void usePhoneAFriend(){
        Question currentQ = this.getCurrentQuestion();

    }


    public void verifyAnswer(String playerAnswer){

        if (getCurrentQuestion().getCorrectAnswerChar().equalsIgnoreCase(playerAnswer)){
            increaseGameRound();
            gameUser.upDateScore(getGameRounds());
            if (!isGameWon()){
                selectQuestion();
            }
        }
        else {
            running = false;
        }

    }
//
//    /**
//     * method searches the param question array for all questions that equal the gameplay level
//     * then these questions are added to a array of questions of the current level
//     * then a random question is chosen from the array to be asked to the player
//     *
//     * @param questionArrayList passes in entire question database
//     * @return Question
//     */
//    public Question askQuestion(ArrayList<Question> questionArrayList){
//        ArrayList<Question> questionCurrentLevelList = new ArrayList<>();
//
//        for (Question value : questionArrayList) {
//            if (value.getLevel() == (this.gameRounds)) {
//                questionCurrentLevelList.add(value);
//            }
//        }
//        Random random = new Random();
//        int size = questionCurrentLevelList.size();
//        int randomNum = random.nextInt((size));
//        currentQuestion = questionCurrentLevelList.get(randomNum);
//        return questionCurrentLevelList.get(randomNum);
//    }


    /**
     * method checks if string contains any special chars or whitespaces
     * and removes them if they are present then returns the string
     *
     * @param answer to check if string contains any special chars or whitespace
     * @return Question
     */
    public static String checkInputForSpecialChars(String answer){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(answer);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(isStringContainsSpecialCharacter){
            //if special chars are present remove them and return
            return answer.replaceAll("[^A-Za-z0-9]","");
        }
        else {
            return answer;
        }

    }


//    /**
//     * welcomeMessage prints out the first message a user sees when running the application.
//     */
//    public static void welcomeMessage(){
//        System.out.println(":~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
//        System.out.println(" Who Wants to be a Kiwionaire? ");
//        System.out.println(":~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:\n");
//    }

//    /**
//     * prints out game instructions with keyboard keys to use
//     */
//    public static void instructionMessage(){
//        System.out.println("\n:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
//        System.out.println(" How to play \"Who Wants to be a Kiwionaire?\"");
//        System.out.println(" To play simply enter the letter (A, B, C, D) which you believe is correct to a asked question.");
//        System.out.println(" After each question round your current score will display so you can see how you are doing.");
//        System.out.println(" Remember you can quit anytime by inputting (X or x).");
//        System.out.println(":~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
//    }

//    /**
//     * Prints out game ending message
//     * there are two ending types one winning ending and one losing ending
//     * the winning ending is only used if gameRounds is greater or equal to LEVEL15
//     *
//     * @param gameUser used to print the user name and score in message
//     */
//    public void Goodbye(User gameUser){
//        if (gameRounds ameRounds >= Money.LEVEL15.getPrizeLevel()){
//            System.out.println("\n:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
//            System.out.println(" Congratulations! You Have Won \"Who Wants to be a Kiwionaire?\"!");
//            System.out.println(" "+gameUser.getUserName() +" your final score is "+ gameUser.getScore()+ "!");
//            System.out.println(":~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
//        }
//        else {
//            System.out.println("\n:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
//            System.out.println(" Thanks for playing \"Who Wants to be a Kiwionaire?\"");
//            System.out.println(" Your final score was $" + gameUser.getScore()+ ", and your game ended on question " +gameRounds +".");
//            System.out.println(" We will automatically save your last game score and username for you.");
//            System.out.println(" Make sure to play again soon to improve your score and maybe even WIN! ");
//            System.out.println(":~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
//
//        }
//
//    }

    public void selectQuestion(){
        if (gameRounds <= 15){
            ArrayList<Question> questionCurrentLevelList = new ArrayList<>();

            for (Question value : this.questionArrayList) {
                if (value.getLevel() == (this.gameRounds)) {
                    questionCurrentLevelList.add(value);
                }
            }
            Random random = new Random();
            int size = questionCurrentLevelList.size();
            int randomNum = random.nextInt((size));

             setCurrentQuestion(questionCurrentLevelList.get(randomNum));

           // return questionCurrentLevelList.get(randomNum);
        }
    }

    public void increaseGameRound(){
        if (gameRounds >= 15){
            setRunning(false);
            setGameWon(true);
        }
        else {
            gameRounds++;

        }

    }

    public boolean isHasFiftyFifty() {
        return hasFiftyFifty;
    }

    public void setHasFiftyFifty(boolean hasFiftyFifty) {
        this.hasFiftyFifty = hasFiftyFifty;
    }

    public String getFiftyFiftyString(){
        return FIFTY_FIFTY;
    }

    public boolean isAskTheAudience() {
        return AskTheAudience;
    }

    public void setAskTheAudience(boolean askTheAudience) {
        AskTheAudience = askTheAudience;
    }

    public String getAskTheAudience(){
        return ASK_THE_AUDIENCE;
    }

    public boolean isPhoneAFriend() {
        return phoneAFriend;
    }

    public void setPhoneAFriend(boolean phoneAFriend) {
        this.phoneAFriend = phoneAFriend;
    }

    public String getPhoneAFriend(){
        return PHONE_A_FRIEND;
    }

    public Question getCurrentQuestion() {
        if (currentQuestion == null){
            selectQuestion();
        }
        return currentQuestion;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setGameUser(User user) {
            gameUser = user;
    }

    public User getGameUser() {
        return gameUser;
    }



}
