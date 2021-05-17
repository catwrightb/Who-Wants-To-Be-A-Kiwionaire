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
    public int gameRounds;
    public Question question;

    //will need to store lifelines
    private boolean hasFiftyFifty;
    private boolean AskTheAudience;
    private boolean phoneAFriend;

    private static User gameUser;


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



    /**
     *
     * Main game method that features all functional code to run the game.
     */
    public void playGame(){

        //reads in array of questions
        questionArrayList = readInQuestions();

        //main gameplay method within a do while loop till user loses or wins game
        //prompting the loop to end
        do {
            gamePlayMethod(gameUser);
        }while (running);

        // Close game wide scanner
        //scan.close();
    }

    /**
     * method is used to control the gameplay of the game post instructions
     * including selecting and print random correct level questions,
     * verifying user keyboard input, checking if input is correct, and
     * progressing game.
     *
     * @param gameUser used to pass user into other methods and update score
     */
    public void gamePlayMethod(User gameUser){

        try{
            if (gameRounds <= Money.LEVEL15.getPrizeLevel()){

                Question p = askQuestion(questionArrayList);
                System.out.print("\n"+p.toString());

                //scanPlayerInput(scan);

                if (running) {
                    boolean wasCorrect = p.verifyUserAnswer(p, userAnswer, gameUser);
                    if (wasCorrect){
                        gameRounds++;
                    }
                    else {
                        running = false;
                    }
                }
                if (!running){
                    gameUser.updateScoreFile();
                    //Goodbye(gameUser);
                }
            }
            else {
                running = false;
                gameUser.updateScoreFile();
                //Goodbye(gameUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        question = questionCurrentLevelList.get(randomNum);
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
//     * Scans player keyboard input to to verify input is correctly responded to
//     * or asked user to enter new input
//     *
//     * @param scan used to scan keyboard input
//     */
//    public void scanPlayerInput(Scanner scan){
//        boolean stop = false;
//
//        do {
//            try{
//                String answer = scan.nextLine();
//                answer = checkInputForSpecialChars(answer);
//
//                if (answer.equals("X") || answer.equals("x")){
//                    stop = true;
//                    run = false;
//                    break;
//                }
//                else if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") ||
//                        answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D") ){
//
//                    userAnswer = answer;
//                    stop = true;
//                    break;
//                }
//                //Life lines commented out for now
////                if (answer.equals("1") || answer.endsWith("2")){
////                    //call to lifelineMethod
////                    stop = true;
////                    break;
////                }
//                else {
//                    throw new NumberFormatException();
//                }
//
//            } catch (InputMismatchException e) {
//                e.printStackTrace();
//            }
//            catch (NumberFormatException e){
//                System.out.println("Please enter a valid answer option 'A, B, C, D'," +
//                        //"\nOr to use a lifeline enter (1 or 2), " +
//                        "\nOr to quit the game enter 'X'.");
//
//            }
//        }while (!stop);
//
//    }


//    /**
//     * playerTypeScan method asks the user if they are a new or returning user. Based on the
//     * players response the application will then create a NewUser or will load data about
//     * a returning user.
//     *
//     * @return ReturnUser - reload all the user's previous progress, NewUser - if the user does not currently exist within the saved file
//     */
//    public static User playerTypeScan(){
//        boolean loop = true;
//
//        while (loop){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Are you a new (N) or returning player (R)?");
//            String user = scanner.nextLine();
//            user = checkInputForSpecialChars(user);
//
//            if (user.equalsIgnoreCase("R")){
//                return returnUserMethod();
//            }
//            if (user.equalsIgnoreCase("N")){
//                return new NewUser();
//            }
//            else {
//                System.out.println("\nSorry that's not a valid choice, try again.");
//            }
//        }
//
//        return null;
//    }


//    /**
//     * returnUserMethod will create a new Return user & prompt the player for their username,
//     * which will then retrieve the user's existing settings & return that to the game application.
//     *
//     * @return returnUser
//     */
//    public static User returnUserMethod(){
//        ReturnUser returnUser = new ReturnUser();
//        String name = returnUser.scanReturnUserName();
//        returnUser.retrieveExistingUser(name);
//
//        if (returnUser.getUserName() != null){
//            System.out.println("\nWelcome back "+ returnUser.getUserName() +", " +
//                    "last time you played your final score was $"+returnUser.getScore()+".");
//
//            if (returnUser.getScore() >= Money.LEVEL15.getPrizeMoney()){
//                System.out.println("Let's see if you can WIN it all again!");
//            }
//            else {
//                System.out.println("Let's see if you can beat it this game!");
//            }
//
//        }
//
//        return returnUser;
//    }


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
//        if (gameRounds >= Money.LEVEL15.getPrizeLevel()){
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




    public boolean isHasFiftyFifty() {
        return hasFiftyFifty;
    }

    public void setHasFiftyFifty(boolean hasFiftyFifty) {
        this.hasFiftyFifty = hasFiftyFifty;
    }

    public String getFiftyFiftyString(){
        String sting = "FiftyFifty";
        return sting;
    }

    public boolean isAskTheAudience() {
        return AskTheAudience;
    }

    public void setAskTheAudience(boolean askTheAudience) {
        AskTheAudience = askTheAudience;
    }

    public boolean isPhoneAFriend() {
        return phoneAFriend;
    }

    public void setPhoneAFriend(boolean phoneAFriend) {
        this.phoneAFriend = phoneAFriend;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setGameUser(User user) {
            gameUser = user;
    }

    public User getGameUser() {
        return gameUser;
    }


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
        return questionCurrentLevelList.get(randomNum);
    }
}
