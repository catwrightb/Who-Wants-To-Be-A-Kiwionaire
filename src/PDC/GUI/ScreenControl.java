package PDC.GUI;

import PDC.GameApplication;
import PDC.UserPackage.NewUser;
import PDC.UserPackage.ReturnUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenControl implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panelCont = new JPanel();

    CardLayout cl = new CardLayout();
    MainMenu mainMenu;
    PlayerMenu playerMenu;
    NewPlayerScreen newPlayerScreen;
    ReturnPlayerScreen returnPlayerScreen;
    QuestionPanel questionPanel;
    int height, width = 400;
    GameApplication currentGame;
    ConfirmScreen confirmScreen;
//    CorrectAnswerPanel correctAnswerPanel;
//    InCorrectAnswerPanel inCorrectAnswerPanel;

    public ScreenControl() {
        frame.setSize(width, height);

        panelCont.setLayout(cl);
        mainMenu = new MainMenu();
        playerMenu = new PlayerMenu();
        newPlayerScreen = new NewPlayerScreen(this);
        returnPlayerScreen = new ReturnPlayerScreen(this);
        questionPanel = new QuestionPanel(currentGame, this);


        panelCont.add(mainMenu, mainMenu.NAME);
        panelCont.add(playerMenu, playerMenu.NAME);
        panelCont.add(newPlayerScreen, newPlayerScreen.NAME);
        panelCont.add(returnPlayerScreen, returnPlayerScreen.NAME);
        panelCont.add(questionPanel, questionPanel.NAME);


        cl.show(panelCont, "1");

        mainMenu.enterButton.addActionListener(e -> changeCard(playerMenu.NAME));
        playerMenu.exitButton.addActionListener(e -> changeCard(mainMenu.NAME));
        playerMenu.newPlayerButton.addActionListener(e -> changeCard(newPlayerScreen.NAME));
        playerMenu.returnPlayerButton.addActionListener(e -> changeCard(returnPlayerScreen.NAME));
        newPlayerScreen.backButton.addActionListener(e -> changeCard(playerMenu.NAME));
        newPlayerScreen.exitButton.addActionListener(e -> changeCard(mainMenu.NAME));
        returnPlayerScreen.backButton.addActionListener(e -> changeCard(playerMenu.NAME));
        returnPlayerScreen.exitButton.addActionListener(e -> changeCard(mainMenu.NAME));


        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     *   changes the cardLayout to display desired panels as game moves
     *
     * @param newCard
     */
    public void changeCard(String newCard){
        cl.show(panelCont, newCard);
    }

    public void removeCard(JPanel panel){
        panelCont.remove(panel);
    }

    public void addCard(JPanel panel, String name){
        panelCont.add(panel, name);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Cast our event source into a Component, grab the components parent JPanel
        Component source = ((Component) e.getSource()).getParent();
       // Component helper = ((Component) e.getSource());

        // Route the event to the correct handler
        if (source instanceof ReturnPlayerScreen) {
            playerSelection(e);
        } else if (source instanceof QuestionPanel) {
            questionEventHandler(e);
        }
//        } else if (source instanceof PostQuestion) {
//            postQuestionEventHandler(e);
         else if (source instanceof ConfirmScreen) {
            confirmScreenLogic(e);
        }
    }


//    //handling the checking of game answer
//    private void questionViewEventHandler(ActionEvent e) {
//        boolean correctAnswer = false;
//        boolean questionAnswered = false;
//
//        if (e.getSource() == questionPanel.getButtonA()) {
//            correctAnswer = this.gameApplication.;
//            questionAnswered = true;
//        } else if (e.getSource() == questionPanel.getButtonB()) {
//            correctAnswer = this.currentGame.getCurrentRound().checkAnswer(Round.CHOICE_B);
//            questionAnswered = true;
//        } else if (e.getSource() == questionPanel.getButtonC()) {
//            correctAnswer = this.currentGame.getCurrentRound().checkAnswer(Round.CHOICE_C);
//            questionAnswered = true;
//        } else if (e.getSource() == questionPanel.getButtonD()) {
//            correctAnswer = this.currentGame.getCurrentRound().checkAnswer(Round.CHOICE_D);
//            questionAnswered = true;
////        } else if (e.getSource() == this.currentQuestionView.getBtn5050()) {
////            currentGame.useFiftyFifty();
////            currentQuestionView = new QuestionView(currentGame, this);
////            rootPanel.switchToCard(currentQuestionView);
//////            SoundView.playSound(SoundView.FIFTY_SOUND);
////        } else if (e.getSource() == currentQuestionView.getBtnSwitch()) {
////            currentGame.useSwitchQuestion();
////            currentQuestionView = new QuestionView(currentGame, this);
////            rootPanel.switchToCard(currentQuestionView);
//////            SoundView.playSound(SoundView.SWITCH_SOUND);
////        }  else if (e.getSource() == currentQuestionView.getBtnAsk()) {
////            AskTheAudience ask = currentGame.useAskTheAudience();
////            currentQuestionView = new AskTheAudienceView(currentGame, ask, this);
////            rootPanel.switchToCard(currentQuestionView);
//////            SoundView.playSound(SoundView.ASK_SOUND);
//        } else if (e.getSource() == questionPanel.getExitButton()) {
//
////            currentGame.finishGame();
////            currentPostQuestion = new PostQuestion(currentGame, this);
////            rootPanel.switchToCard(currentPostQuestion);
//        }
//
//        if (questionAnswered) {
//            if (correctAnswer) {
//                currentGame.correctAnswer();
//            } else {
//                currentGame.incorrectAnswer();
//            }
//
//            //No matter the outcome generate a new PostQuestion view from the current game and show it
//            this.currentPostQuestion = new PostQuestion(currentGame, this);
//            rootPanel.switchToCard(currentPostQuestion);
//        }
//    }


    //this wont work for larger logic to track what life line is used
    public void confirmScreenLogic(ActionEvent e){
        if (e.getSource() == confirmScreen.getYesButton()){
            removeCard(questionPanel);

            String string = confirmScreen.getCurrentLifeLine();

            if (string.equals("Fifty Fifty")){
                currentGame.usefiftyFiftyLifeLine();
                currentGame.setHasFiftyFifty(false);
            }
            else if (string.equals("Phone A Friend")){
                currentGame.setPhoneAFriend(false);
            }
            else if (string.equals("Ask The Audience")){
                currentGame.setAskTheAudience(false);
            }

            questionPanel = new QuestionPanel(currentGame, this);
            addCard(questionPanel, questionPanel.NAME);
            changeCard(questionPanel.NAME);
            removeCard(confirmScreen);

        }
        else {
            changeCard(questionPanel.NAME);
        }
    }


    public void playerSelection(ActionEvent e){
        boolean playerCreated = false;

        if (e.getSource() == returnPlayerScreen.submitButton) {

            ReturnUser returnUser = new ReturnUser();
            String text = returnPlayerScreen.userNameInput.getText();
            returnUser.retrieveExistingUser(text);

            if (returnUser.getUserName() == null) {
                JOptionPane.showMessageDialog(null, "Your name couldn't be found please try another user name or create a new player.", "INFO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                currentGame.setGameUser(returnUser);
                playerCreated = true;
            }
        }
        else if (e.getSource() == newPlayerScreen.submitButton){
            NewUser newUser = new NewUser();
            String text = newPlayerScreen.userNameInput.getText();

            if (!newUser.checkUsernameAvailability(text)) {
                JOptionPane.showMessageDialog(null, "Name is already in user please choose another user name", "INFO",
                        JOptionPane.ERROR_MESSAGE);
            }
           else if (newUser.checkUsernameAvailability(text)) {
                newUser.setUserName(text);
                currentGame.setGameUser(newUser);
                playerCreated = true;
            }
        }

        if (playerCreated){
            changeCard(questionPanel.NAME);
        }
    }

    public void questionEventHandler(ActionEvent e){
        if (e.getSource() == questionPanel.getFiftyFifty() && currentGame.isHasFiftyFifty()){
            confirmScreen = new ConfirmScreen(currentGame.getFiftyFiftyString(), this);
            panelCont.add(confirmScreen, confirmScreen.NAME);
            changeCard(confirmScreen.NAME);
        }
        else if (e.getSource() == questionPanel.getPhoneFriend() && currentGame.isPhoneAFriend()){
            confirmScreen = new ConfirmScreen(currentGame.getPhoneAFriend(), this);
            panelCont.add(confirmScreen, confirmScreen.NAME);
            changeCard(confirmScreen.NAME);
        }
        else if (e.getSource() == questionPanel.getAskAudience() && currentGame.isAskTheAudience()){
            confirmScreen = new ConfirmScreen(currentGame.getAskTheAudience(), this);
            panelCont.add(confirmScreen, confirmScreen.NAME);
            changeCard(confirmScreen.NAME);
        }
        else if (e.getSource() == questionPanel.getButtonA()){

        }
        else if (e.getSource() == questionPanel.getButtonB()){

        }
        else if (e.getSource() == questionPanel.getButtonB()){

        }
        else if (e.getSource() == questionPanel.getButtonD()){

        }
        else if (e.getSource() == questionPanel.getExitButton()){
            //exit game
            //maybe have confirm Screen ask if they want to quit or not?
        }




    }

    public void startGame(){
        currentGame = new GameApplication();


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScreenControl();
            }
        });
    }


}
