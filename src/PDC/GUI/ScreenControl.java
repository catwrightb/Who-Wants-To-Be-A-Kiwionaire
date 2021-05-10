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
    GameApplication gameApplication;
    CorrectAnswerPanel correctAnswerPanel;
    InCorrectAnswerPanel inCorrectAnswerPanel;

    public ScreenControl() {
        frame.setSize(width, height);
        gameApplication = new GameApplication();

        panelCont.setLayout(cl);
        mainMenu = new MainMenu();
        playerMenu = new PlayerMenu();
        newPlayerScreen = new NewPlayerScreen();
        returnPlayerScreen = new ReturnPlayerScreen();
        questionPanel = new QuestionPanel(gameApplication);

        panelCont.add(mainMenu, "1");
        panelCont.add(playerMenu, "2");
        panelCont.add(newPlayerScreen, "3");
        panelCont.add(returnPlayerScreen, "4");
        panelCont.add(questionPanel, "5");

        cl.show(panelCont, "1");

        mainMenu.enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "2");
            }

        });

        playerMenu.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "1");
            }
        });

        playerMenu.newPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "3");
            }

        });

        playerMenu.returnPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "4");
            }
        });

        //Returning player
        returnPlayerScreen.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnPlayerScreen.submitButton) {

                    ReturnUser returnUser = new ReturnUser();
                    String text = returnPlayerScreen.userNameInput.getText();
                    returnUser.retrieveExistingUser(text);

                    if (returnUser.getUserName() == null) {
                        JOptionPane.showMessageDialog(null, "Your name couldn't be found please try another user name or create a new player.", "INFO",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        gameApplication.setGameUser(returnUser);
                        cl.show(panelCont, "5");

                    }
                }
            }
        });

        //New Player
        newPlayerScreen.submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == newPlayerScreen.submitButton) {

                    NewUser newUser = new NewUser();
                    String text = newPlayerScreen.userNameInput.getText();

                    if (!newUser.checkUsernameAvailability(text)) {
                        JOptionPane.showMessageDialog(null, "Name is already in user please choose another user name", "INFO",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (newUser.checkUsernameAvailability(text)) {
                        newUser.setUserName(text);
                        gameApplication.setGameUser(newUser);
                        cl.show(panelCont, "5");
                    }
                }
            }
        });


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
        if (source instanceof QuestionPanel) {
            questionViewEventHandler(e);
//        } else if (source instanceof GetUsername) {
//            usernameEventHandler();
//        } else if (source instanceof PostQuestion) {
//            postQuestionEventHandler(e);
//        } else if (source instanceof LeaderboardView) {
//            leaderboardViewEventHandler();
        }
    }


    //handling the checking of game answer
    private void questionViewEventHandler(ActionEvent e) {
        boolean correctAnswer = false;
        boolean questionAnswered = false;

        if (e.getSource() == questionPanel.getButtonA()) {
            correctAnswer = this.gameApplication.;
            questionAnswered = true;
        } else if (e.getSource() == questionPanel.getButtonB()) {
            correctAnswer = this.currentGame.getCurrentRound().checkAnswer(Round.CHOICE_B);
            questionAnswered = true;
        } else if (e.getSource() == questionPanel.getButtonC()) {
            correctAnswer = this.currentGame.getCurrentRound().checkAnswer(Round.CHOICE_C);
            questionAnswered = true;
        } else if (e.getSource() == questionPanel.getButtonD()) {
            correctAnswer = this.currentGame.getCurrentRound().checkAnswer(Round.CHOICE_D);
            questionAnswered = true;
//        } else if (e.getSource() == this.currentQuestionView.getBtn5050()) {
//            currentGame.useFiftyFifty();
//            currentQuestionView = new QuestionView(currentGame, this);
//            rootPanel.switchToCard(currentQuestionView);
////            SoundView.playSound(SoundView.FIFTY_SOUND);
//        } else if (e.getSource() == currentQuestionView.getBtnSwitch()) {
//            currentGame.useSwitchQuestion();
//            currentQuestionView = new QuestionView(currentGame, this);
//            rootPanel.switchToCard(currentQuestionView);
////            SoundView.playSound(SoundView.SWITCH_SOUND);
//        }  else if (e.getSource() == currentQuestionView.getBtnAsk()) {
//            AskTheAudience ask = currentGame.useAskTheAudience();
//            currentQuestionView = new AskTheAudienceView(currentGame, ask, this);
//            rootPanel.switchToCard(currentQuestionView);
////            SoundView.playSound(SoundView.ASK_SOUND);
        } else if (e.getSource() == questionPanel.getExitButton()) {

//            currentGame.finishGame();
//            currentPostQuestion = new PostQuestion(currentGame, this);
//            rootPanel.switchToCard(currentPostQuestion);
        }

        if (questionAnswered) {
            if (correctAnswer) {
                currentGame.correctAnswer();
            } else {
                currentGame.incorrectAnswer();
            }

            //No matter the outcome generate a new PostQuestion view from the current game and show it
            this.currentPostQuestion = new PostQuestion(currentGame, this);
            rootPanel.switchToCard(currentPostQuestion);
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
