package PDC.GUI;

import PDC.FiftyFifty;
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
    GameApplication gameApplication;
//    CorrectAnswerPanel correctAnswerPanel;
//    InCorrectAnswerPanel inCorrectAnswerPanel;

    public ScreenControl() {
        frame.setSize(width, height);
        gameApplication = new GameApplication();

        panelCont.setLayout(cl);
        mainMenu = new MainMenu();
        playerMenu = new PlayerMenu();
        newPlayerScreen = new NewPlayerScreen(this);
        returnPlayerScreen = new ReturnPlayerScreen(this);
        questionPanel = new QuestionPanel(gameApplication, this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // Cast our event source into a Component, grab the components parent JPanel
        Component source = ((Component) e.getSource()).getParent();

        // Route the event to the correct handler
        if (source instanceof ReturnPlayerScreen) {
            playerSelection(e);
        } else if (source instanceof QuestionPanel) {
            questionEventHandler(e);
//        } else if (source instanceof PostQuestion) {
//            postQuestionEventHandler(e);
//        } else if (source instanceof LeaderboardView) {
//            leaderboardViewEventHandler();
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


    /**
    *   changes the cardLayout to display desired panels as game moves
     *
     * @param newCard
    */
    public void changeCard(String newCard){
        cl.show(panelCont, newCard);
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
                gameApplication.setGameUser(returnUser);
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
                gameApplication.setGameUser(newUser);
                playerCreated = true;
            }
        }

        if (playerCreated){
            changeCard(questionPanel.NAME);
        }
    }

    public void questionEventHandler(ActionEvent e){
        if (e.getSource() == questionPanel.getFiftyFifty()){
            int answer = JOptionPane.showInternalConfirmDialog(null, "Are you sure you want to use your Fifty Fifty lifeline?", "Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION){
                if (this.gameApplication.isHasFiftyFifty()){




                }
            }

            else if (answer == JOptionPane.NO_OPTION){
                //Close window
            }
            else if (answer == JOptionPane.CLOSED_OPTION){
                //Close window
            }

        }

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
