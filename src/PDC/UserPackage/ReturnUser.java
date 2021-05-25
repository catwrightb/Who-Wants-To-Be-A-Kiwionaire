package PDC.UserPackage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReturnUser extends User implements ReturnedUserInterface{
    private static final String userDatabase = "./resources/userStats.csv";

    public ReturnUser(String un) {
        this.score = 0;
        this.userName = un;
    }

    public ReturnUser() {
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
                    //ReturnUser user = new ReturnUser(data[0], Integer.parseInt(data[1]));
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
