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
     * Checks if the username is available within the database, otherwise
     * prompts the user to enter a different name.
     *
     * @param userName - the name the user want's to use to play
     * @return true/false depending if that name already exists within the database
     */
    public boolean checkUsernameAvailability(String userName){

        if (userName.isEmpty() || userName.contains(" ") || userName.contains("\t")){
            return false;
        }

        //userName = removeSpacesInString(userName);

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
