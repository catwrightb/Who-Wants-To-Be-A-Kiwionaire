package PDC;

import PDC.UserPackage.User;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static PDC.Question.readInQuestions;

public class GameApplication {

    private String userAnswer;
    private boolean running;
    public ArrayList<Question> questionArrayList = new ArrayList<>();
    private int gameRounds;
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
        this.questionArrayList = readInQuestions();
        this.gameRounds = Money.LEVEL1.getPrizeLevel();

        //linelife
        this.hasFiftyFifty = true;
        this.AskTheAudience = true;
        this.phoneAFriend = true;

        //Game running
        this.running = true;
    }


    //gets the current game rounds
     public int getGameRounds(){
         return this.gameRounds;
     }


     public void usefiftyFiftyLifeLine(){
        Question currentQ = this.getCurrentQuestion();

        if (currentQ.correctAnswer.equals("A") || currentQ.correctAnswer.equals("B") ){
            currentQ.cChoice = "";
            currentQ.dChoice = "";
        }
        else if (currentQ.correctAnswer.equals("C") || currentQ.correctAnswer.equals("D") ){
            currentQ.aChoice = "";
            currentQ.bChoice = "";
        }

     }


    public void verifyAnswer(String playerAnswer){

        if (getCurrentQuestion().getCorrectAnswer().equalsIgnoreCase(playerAnswer)){
            increaseGameRound();
            gameUser.upDateScore(running, getGameRounds());
            setCurrentQuestion();
        }
        else {
            running = false;
        }

    }

    /**
     * method searches the param question array for all questions that equal the gameplay level
     * then these questions are added to a array of questions of the current level
     * then a random question is chosen from the array to be asked to the player
     *
     * @param questionArrayList passes in entire question database
     * @return Question
     */
    public Question askQuestion(ArrayList<Question> questionArrayList){
        ArrayList<Question> questionCurrentLevelList = new ArrayList<>();

        for (Question value : questionArrayList) {
            if (value.getLevel() == (this.gameRounds)) {
                questionCurrentLevelList.add(value);
            }
        }
        Random random = new Random();
        int size = questionCurrentLevelList.size();
        int randomNum = random.nextInt((size));
        currentQuestion = questionCurrentLevelList.get(randomNum);
        return questionCurrentLevelList.get(randomNum);
    }


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

    public Question selectQuestion(){
        ArrayList<Question> questionCurrentLevelList = new ArrayList<>();

        for (Question value : this.questionArrayList) {
            if (value.getLevel() == (this.gameRounds)) {
                questionCurrentLevelList.add(value);
            }
        }
        Random random = new Random();
        int size = questionCurrentLevelList.size();
        int randomNum = random.nextInt((size));

       // setCurrentQuestion(questionCurrentLevelList.get(randomNum));

        return questionCurrentLevelList.get(randomNum);
    }

    public void increaseGameRound(){
        gameRounds++;
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
            setCurrentQuestion();
        }
        return currentQuestion;
    }

    public void setCurrentQuestion() {
        this.currentQuestion = selectQuestion();
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
