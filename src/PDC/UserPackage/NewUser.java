package PDC.UserPackage;

import PDC.Money;

import java.io.*;
import java.util.Scanner;


public class NewUser extends User implements NewUserInterface{

    private static final String userDatabase = "./resources/userStats.csv";

    /**
     * NewUser Constructor
     */
//    public NewUser() {
//        setUserName(createNewUser());
//        setScore(0);
//    }

    public NewUser(String un){
        this.score = Money.LEVEL1.getPrizeMoney();
        this.userName = un;
    }

    public NewUser(){
    }

    /**
     * calls to scanning class to take in a string to be used as a NewUser userName
     * withing the constructor
     *
     * @return string to be used as a NewUser userName
     */
    public String createNewUser(){
       return scanNewUserName();
    }


    /**
     * Scanning class to take keyboard input from a NewUser to use for their UserName in the game.
     * Once a valid string is entered, they will be asked (Y/N) if they'd like to use the entered string or enter another
     * string. If no they will start the process again, if yes the method checkUsernameAvailability is called,
     * to make sure the string input is available to use. Once the user has entered a string available they'd like to
     * use the string is returned to be set as the UserName.
     *
     * @return string to be used as a newUser UserName
     */
    @Override
    public String scanNewUserName(){
        boolean stop = false;

        do{
            Scanner scan =  new Scanner(System.in);
            System.out.println("What should we call you? "
                    + "\nPlease create a username without any whitespaces in it."
                    + "\nFeel free to use special characters and number in your name.");
            userName = scan.nextLine();
            String answer;
            if (userName.contains(" ")||userName.contains("\t")){
                System.out.println("Sorry a username cannot contain whitespaces, please enter a name without any whitespaces.\n");
            }
            else if(!checkUsernameAvailability(userName)){
            
            }
            else {

               stop = happyWithName(userName, scan);
            }
        }while (!stop);

        return userName;
    }

    /**
     * Gets input from user if user is happy with name they entered or wants to
     * enter a new name. will deliver a boolean response back to method which called
     *
     * @param scan scanner from called method
     * @param userName entered username string
     * @return boolean tells while loop to continue in called method
     */
    public boolean happyWithName(String userName, Scanner scan){
        boolean stop = false;

        System.out.println("Nice to meet you " + userName + ". " +
                "Are you happy with this name? (Y/N)");

        do {
            String answer = scan.nextLine();

            switch (answer) {
                case "Y"://fall through
                case "y":
                    addUserToFile(userName);
                    stop = true;
                    break;
                case "N"://fall through
                case "n":
                    System.out.println("No worries mate.\n");
                    stop = true;
                    return false;
                default:
                    System.out.println("\nSorry that's not a valid response.\n" +
                            "Are you happy to use the username ("+ userName+ "), please choose (Y or N).");
                    stop = false;
                    break;
            }
        }while(!stop);

       return true;
    }

    /**
     * Checks if the username is available within the database, otherwise
     * prompts the user to enter a different name.
     *
     * @param userName - the name the user want's to use to play
     * @return true/false depending if that name already exists within the database
     */
    public boolean checkUsernameAvailability(String userName){

        if (userName.isEmpty()){
            return false;
        }

        userName = removeSpacesInString(userName);

        File file = new File(userDatabase);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split("\t");
                if (data[0].equalsIgnoreCase(userName)){
                    return false;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return true;
    }


    public String removeSpacesInString(String userName){
        if (userName.contains(" ")||userName.contains("\t")){
            userName = userName.replaceAll("\\s+","");
        }
        return userName;
    }

    /**
     * Method adds the userName to the userStats file database
     *
     * @param userName - the chosen name by the user.
     */
    private static void addUserToFile(String userName){
        File file = new File(userDatabase);
        try{
            FileWriter csvWriter = new FileWriter(file, true);
            csvWriter.write(userName + "\t" + 0 + "\n");

            csvWriter.flush();
            csvWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
