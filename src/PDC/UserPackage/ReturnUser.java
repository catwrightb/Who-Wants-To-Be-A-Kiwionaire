package PDC.UserPackage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReturnUser extends User implements ReturnedUserInterface{
    private static final String userDatabase = "./resources/userStats.csv";

    public ReturnUser(String un, int sc) {
        this.score = sc;
        this.userName = un;
    }

    public ReturnUser() {
    }


    /**
     * Is used as an accessory to this class to scan for the user's userName which can then be used
     * within retrieveExistingUser method.
     *
     * @return userName
     */
    @Override
    public String scanReturnUserName(){
        Scanner scan =  new Scanner(System.in);
        System.out.println("What is your saved user name?");
        
        return scan.next();
    }


    /**
     * retrieveExistingUser method will read the userStats.csv file located in resources to find the
     * user's userName and their last score from when the last played the game.
     * It then sets this as the user's name and score.
     *
     * @param userName - the username of the current player to search for.
     */
    //Checks files for user
    @Override
    public void retrieveExistingUser(String userName){
        // Try / Catch block for reading a file
        
        try{
            File file = new File(userDatabase);
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = csvReader.readLine())!= null){
                String[] data = line.split("\t");

                // Check if the userName entered, already exists within the file
                if (userName.equalsIgnoreCase(data[0])){
                    setUserName(data[0]);
                    setScore(Integer.parseInt(data[1]));
                }
            }
            // Close file reader
            csvReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
