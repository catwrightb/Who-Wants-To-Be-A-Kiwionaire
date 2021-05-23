package PDC.GUI;

import Database.UserDB;
import PDC.GameApplication;
import PDC.Letters;
import PDC.Money;
import PDC.UserPackage.User;

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
    int height = 450;
    int width = 650;
    GameApplication currentGame;
    ConfirmScreen confirmScreen;
    CorrectAnswerPanel correctAnswerPanel;
    InCorrectAnswerPanel inCorrectAnswerPanel;
    EndGamePanel endGamePanel;
    private final int LEVELS_TO_WIN = Money.LEVEL15.getPrizeLevel()+1;

    public ScreenControl() {
        // Make UI look nice
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Make program follow system's theme.
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        frame.setSize(width, height);

        panelCont.setLayout(cl);

        // Create each panel
        mainMenu = new MainMenu(this);
        playerMenu = new PlayerMenu(this);
        newPlayerScreen = new NewPlayerScreen(this);
        returnPlayerScreen = new ReturnPlayerScreen(this);
       // questionPanel = new QuestionPanel(currentGame, this);

        // Add each panel to main JPanel
        panelCont.add(mainMenu, mainMenu.NAME);
        panelCont.add(playerMenu, playerMenu.NAME);
        panelCont.add(newPlayerScreen, newPlayerScreen.NAME);
        panelCont.add(returnPlayerScreen, returnPlayerScreen.NAME);
       // panelCont.add(questionPanel, questionPanel.NAME);

        changeCard(mainMenu.NAME);

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
        if (!panel.equals(mainMenu)){ // mainMenu panel should never be removed
            panelCont.remove(panel);
        }
    }

    public void addCard(JPanel panel, String name){
        panelCont.add(panel, name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Cast our event source into a Component, grab the components parent JPanel
        Component source = ((Component) e.getSource()).getParent();

        // Route the event to the correct handler
        if (source instanceof ReturnPlayerScreen || source instanceof NewPlayerScreen) {
            playerSelectionHandler(e);
        } else if (source instanceof QuestionPanel) {
            questionEventHandler(e);
        }
        else if (source instanceof PlayerMenu) {
            playerMenuHandler(e);
        }
         else if (source instanceof ConfirmScreen) {
            confirmScreenHandler(e);
        }
        else if (source instanceof MainMenu) {
            enterGameHandler(e);
        }
        else if (source instanceof InCorrectAnswerPanel) {
            inCorrectAnswerPanelHandler(e);
        }
        else if (source instanceof CorrectAnswerPanel){
            correctAnswerPanelHandler(e);
        }
    }

    public void correctAnswerPanelHandler(ActionEvent e){
        JPanel source = (JPanel) ((Component) e.getSource()).getParent();

        if (e.getSource() == correctAnswerPanel.getContinueButton() && !currentGame.isGameWon()){
            questionPanel = new QuestionPanel(currentGame,this);
            addCard(questionPanel, questionPanel.NAME);
            changeCard(questionPanel.NAME);
            removeCard(source);
        }

        if (e.getSource() == correctAnswerPanel.getExitButton()
                || (e.getSource() == correctAnswerPanel.getContinueButton()
                && currentGame.isGameWon())){
            endGame(source);
        }
    }

    public void inCorrectAnswerPanelHandler(ActionEvent e){
        JPanel source = (JPanel) ((Component) e.getSource()).getParent();

        if (e.getSource() == inCorrectAnswerPanel.getContinueButton()){
            endGame(source);
        }
    }

    public void endGame( JPanel source){
        endGamePanel = new EndGamePanel(currentGame,this);
        addCard(endGamePanel, endGamePanel.NAME);
        changeCard(endGamePanel.NAME);
        removeCard(source);

        endGamePanel.getContinueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCard(mainMenu.NAME);
                removeCard(endGamePanel);

                currentGame = null;
                System.gc(); //garbage collect old game
            }
        });
    }



    public void enterGameHandler(ActionEvent e){
        if (e.getSource() == mainMenu.enterButton){
            playerMenu = new PlayerMenu(this);
            addCard(playerMenu, playerMenu.NAME);
            changeCard(playerMenu.NAME);

            startGame();
        }
    }

    public void playerMenuHandler(ActionEvent e){
        if (e.getSource() == playerMenu.newPlayerButton){
            newPlayerScreen = new NewPlayerScreen(this);
            addCard(newPlayerScreen, newPlayerScreen.NAME);
            changeCard(newPlayerScreen.NAME);
            removeCard(playerMenu);
        }

        if (e.getSource() == playerMenu.returnPlayerButton){
            returnPlayerScreen = new ReturnPlayerScreen(this);
            addCard(returnPlayerScreen, returnPlayerScreen.NAME);
            changeCard(returnPlayerScreen.NAME);
            removeCard(playerMenu);
        }

        if (e.getSource() == playerMenu.exitButton){
            changeCard(mainMenu.NAME);
            removeCard(playerMenu);
        }
    }


    //this wont work for larger logic to track what life line is used
    public void confirmScreenHandler(ActionEvent e){
        if (e.getSource() == confirmScreen.getYesButton()){
            removeCard(questionPanel);

            String string = confirmScreen.getCurrentLifeLine();

            if (string.equals("Fifty Fifty")){
                currentGame.useFiftyFiftyLifeLine();
                currentGame.setHasFiftyFifty(false);
            }
            else if (string.equals("Ask The Audience")){
                currentGame.useAskAudience();
                currentGame.setAskTheAudience(false);
            }
            else if (string.equals("Phone A Friend")){
                currentGame.usePhoneAFriend();
                currentGame.setPhoneAFriend(false);
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


    public void playerSelectionHandler(ActionEvent e){
        removeCard(playerMenu);
        boolean playerCreated = false;
        JPanel source = (JPanel) ((Component) e.getSource()).getParent();

        // USER Database
        UserDB userDB = new UserDB();
        // USER OBJECT
        User gameUser = new User();

        if (e.getSource() == returnPlayerScreen.submitButton) {

            // Grab the text the user has entered
            String text = returnPlayerScreen.userNameInput.getText();
            // Retrieve the user's details
            gameUser = userDB.retrieveUser(text);

            // If the user's details can't be retrieved
            // Show an error and prompt them to try again
            if (gameUser == null){
                JOptionPane.showMessageDialog(null, "Your name couldn't be found" +
                                " please try another user name or create a new player.", "INFO",
                        JOptionPane.ERROR_MESSAGE);
            }
            else { // Setup the user's game
                currentGame.setGameUser(gameUser);
                playerCreated = true;
            }
        }

        //TODO will allow entry on nothing in text box
        if (e.getSource() == newPlayerScreen.submitButton){

            // Grab the text the user has entered
            String text = newPlayerScreen.userNameInput.getText();

            // Check if the username is available
            // Otherwise show an error
            if (!(userDB.checkUsernameAvailability(text))) {
                JOptionPane.showMessageDialog(null, "Sorry that UserName is already in User" +
                                " or you have entered a invalid UserName", "INFO",
                        JOptionPane.ERROR_MESSAGE);
            }
           else if ((userDB.checkUsernameAvailability(text))) {
               // Make sure that gameUser isn't null
                assert gameUser != null;
                // Set username
                gameUser.setUserName(text);
                // Add to the database
                userDB.addUserToDatabase(gameUser);
                // Set the current gameUser
                currentGame.setGameUser(gameUser);
                // Update boolean
                playerCreated = true;
            }
        }

        //go back to player selection
        if (e.getSource() == newPlayerScreen.backButton || e.getSource() == returnPlayerScreen.backButton){
            playerMenu = new PlayerMenu(this);
            addCard(playerMenu, playerMenu.NAME);
            changeCard(playerMenu.NAME);
            removeCard(source);
        }

        //exit to mainMenu
        if (e.getSource() == newPlayerScreen.exitButton || e.getSource() == returnPlayerScreen.exitButton){
            changeCard(mainMenu.NAME);
            removeCard(source);
        }

        if (playerCreated){
            questionPanel = new QuestionPanel(currentGame, this);
            addCard(questionPanel, questionPanel.NAME);
            changeCard(questionPanel.NAME);
            removeCard(playerMenu);
            removeCard(source);
        }
    }

    public void questionEventHandler(ActionEvent e){
        boolean checkGameStatus = false;

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
            currentGame.verifyAnswer(String.valueOf(Letters.A));
            checkGameStatus = true;
        }
        else if (e.getSource() == questionPanel.getButtonB()){
            currentGame.verifyAnswer(String.valueOf(Letters.B));
            checkGameStatus = true;
        }
        else if (e.getSource() == questionPanel.getButtonC()){
            currentGame.verifyAnswer(String.valueOf(Letters.C));
            checkGameStatus = true;
        }
        else if (e.getSource() == questionPanel.getButtonD()){
            currentGame.verifyAnswer(String.valueOf(Letters.D));
            checkGameStatus = true;
        }
        else if (e.getSource() == questionPanel.getExitButton()){
            //TODO what happens when clicked exit during question
            //exit game
            //maybe have confirm Screen ask if they want to quit or not?
        }

        if (checkGameStatus){
            removeCard(questionPanel);

            if (currentGame.isRunning()){
                correctAnswerPanel = new CorrectAnswerPanel(this);
                addCard(correctAnswerPanel, correctAnswerPanel.NAME);
                changeCard(correctAnswerPanel.NAME);
            }

            if (!currentGame.isRunning()){
                if (currentGame.isGameWon()){
                    correctAnswerPanel = new CorrectAnswerPanel(this);
                    addCard(correctAnswerPanel, correctAnswerPanel.NAME);
                    changeCard(correctAnswerPanel.NAME);
                }
                else {
                    inCorrectAnswerPanel = new InCorrectAnswerPanel(currentGame.getGameRounds(), this);
                    addCard(inCorrectAnswerPanel, inCorrectAnswerPanel.NAME);
                    changeCard(inCorrectAnswerPanel.NAME);
                }

            }

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
