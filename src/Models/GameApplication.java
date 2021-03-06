package Models;

import Database.QuestionDB;

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

        if (currentQ.getCorrectAnswerStr().equals(currentQ.aChoice) || currentQ.getCorrectAnswerStr().equals(currentQ.bChoice) ){
            currentQ.cChoice = " ";
            currentQ.dChoice = " ";
        }
        else if (currentQ.getCorrectAnswerStr().equals(currentQ.cChoice) || currentQ.getCorrectAnswerStr().equals(currentQ.dChoice) ){
            currentQ.aChoice = " ";
            currentQ.bChoice = " ";
        }

        this.setHasFiftyFifty(false);

     }


     public StringBuilder useAskAudience(){
         Question currentQ = this.getCurrentQuestion();
         StringBuilder audienceDecision = new StringBuilder("The audience think the answer is:\n");

         Random rand = new Random();
         int chance = rand.nextInt(100);

         if (chance >= 23) {
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

         this.setAskTheAudience(false);

         return audienceDecision;
     }


    public StringBuilder usePhoneAFriend(){
        Question currentQ = this.getCurrentQuestion();
        StringBuilder friendString = new StringBuilder();

        Random rand = new Random();
        int textRandom = rand.nextInt(4);

        switch (textRandom){
            case 0:
                friendString.append("Dude, it's great to hear from you!\n" +
                        "I'm not entirely sure but I think the answer is ");
                break;
            case 1:
                friendString.append("Oh my glob, I totally know this answer.\n" +
                        "The answer is for sure ");
                break;
            case 2:
                friendString.append("I'm not sure why you called me you know I failed Maths class.\n" +
                        "I guess if I have to pick I'd say the answer is ");
                break;
            case 3:
                friendString.append("Pizza Palace how can I help you . . . Oh umm I think you have the wrong number.\n" +
                        "I guess I could pick a answer though, maybe it's ");
                break;
        }


        int chance = rand.nextInt(100);

        if (chance >= 40){

            friendString.append(currentQ.getCorrectAnswerStr());
        }
        else {
            int randomAnswer = rand.nextInt(4);

            // Check if no fifty fifty was used before this lifeline
            if (!currentQ.getaChoice().isEmpty() && !currentQ.getbChoice().isEmpty()
                    && !currentQ.getcChoice().isEmpty() && !currentQ.getdChoice().isEmpty()){


                if (randomAnswer == 0) {
                    friendString.append(currentQ.getaChoice());
                }
                else if (randomAnswer == 1) {
                    friendString.append(currentQ.getbChoice());
                }
                else if (randomAnswer == 2) {
                    friendString.append(currentQ.getcChoice());
                }
                else {
                    friendString.append(currentQ.getdChoice());
                }
            }
            // Check if choice A & B are available
            else if (!currentQ.getaChoice().isEmpty() && !currentQ.getbChoice().isEmpty()) {

                randomAnswer = rand.nextInt(2);
                if (randomAnswer == 1){
                    friendString.append(currentQ.getaChoice());
                }else {
                    friendString.append(currentQ.getbChoice());
                }
            }
            // Otherwise pick between choice C & D randomly
            else {
                randomAnswer = rand.nextInt(2);
                if (randomAnswer == 1){
                    friendString.append(currentQ.getcChoice());
                }else {
                    friendString.append(currentQ.getdChoice());
                }
            }
        }
        friendString.append(".");

        this.setPhoneAFriend(false);

        return friendString;

    }


    public void verifyAnswer(String playerAnswer){

        if (getCurrentQuestion().getCorrectAnswerStr().equalsIgnoreCase(playerAnswer)){
            gameUser.upDateScore(getGameRounds());
            increaseGameRound();
            if (!isGameWon()){
                selectQuestion();
            }
        }
        else {
            running = false;
        }

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
