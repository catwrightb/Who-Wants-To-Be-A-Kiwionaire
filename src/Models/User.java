package Models;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class User implements Comparable<User>{
    private static final String userDatabase = "./resources/userStats.csv";

    protected int score;
    protected String userName;

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * method updates players Scores based on if they answered a question correctly or not.
     * A Enum class Money is used.
     *
     *
     */
    public void upDateScore( int gameRoundWon){

            Level[] level = Level.values();

            for (Level value : level) {
                if (gameRoundWon == value.getPrizeLevel()) {
                    this.score = value.getPrizeMoney();
                }
            }

    }

    public void resetScoreToZero(){
        if (this.score > 0){
            this.setScore(0);
        }

    }


    public void updateScoreFile(){
        // Create HashMap to store user names / scores for overwriting file
        HashMap<String, Integer> users = new HashMap<>();
        try{
            // Read file & add into HashMap of users.
            File file = new File(userDatabase);
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = csvReader.readLine())!= null){
                String[] data = line.split("\t");
                String name = data[0];
                int currentScore = Integer.parseInt(data[1]);
                users.put(name, currentScore);
            }
            // Add the new user now, otherwise if already existing, update the score.
            users.put(getUserName(), getScore());

            // Now overwrite the file & import new updated scores
            BufferedWriter csvWriter = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Integer> entry:users.entrySet()){
                csvWriter.write(entry.getKey() + "\t" + entry.getValue());
                csvWriter.newLine();
            }

            // Flush & Close all writers & readers
            csvWriter.flush();
            csvWriter.close();
            csvReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "" +
                " " + userName +
                ", " + score +
                "";
    }

    @Override
    public int compareTo(User o) {
        if (this.score > o.score){
            return 1;
        }
        else if (this.score < o.score){
            return -1;
        }
        else
            return 0;
    }
}
