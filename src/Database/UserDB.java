package Database;

import Models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    private static final String USER_DATABASE = "./resources/userStats.csv";
    private static final String USER_TABLE_NAME = "USERS";

    private final DBManager dbManager;
    private final Connection conn;

    public UserDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    public static void main(String[] args) {
        UserDB users = new UserDB();
        users.printTableContents();
    }

    public ArrayList<User> returningUserList() {
        ResultSet rs = dbManager.queryDB("SELECT * FROM " + USER_TABLE_NAME);
        ArrayList<User> users = new ArrayList<>();

        try{
            while (rs.next()){
                User gameUser = new User();
                gameUser.setUserName(rs.getString("USERNAME"));
                gameUser.setScore(rs.getInt("SCORE"));
                //user is always set with a score of zero at start of game
                //regardless of past score

                users.add(gameUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    public void addUserToDB(User user){
        String sqlAdd = "INSERT INTO " + USER_TABLE_NAME + " VALUES ('";
        sqlAdd += user.getUserName() + "', ";
        sqlAdd += user.getScore() + ")";
        // Update Database
        dbManager.updateDB(sqlAdd);

        try{
            ResultSet rs = dbManager.queryDB("SELECT * FROM " + USER_TABLE_NAME);
            while(rs.next()){
                System.out.println("Username: " + rs.getString("USERNAME"));
                System.out.println("Score: " + rs.getInt("SCORE"));
                System.out.println("=============================");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User retrieveUser(String username){
        ArrayList<User> users = returningUserList();

        for (User user: users){
            if (user.getUserName().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
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

        ArrayList<User> users = returningUserList();

        for (User name: users) {
            if (name.getUserName().equalsIgnoreCase(userName)){
                return false;
            }
        }

        return true;
    }

    public void addUserToDatabase(User user){
        String sql = "INSERT INTO " + USER_TABLE_NAME + " VALUES ('";
        sql += user.getUserName() + "', ";
        sql += user.getScore() + ")";

        dbManager.updateDB(sql);
    }

    public void createUserTable(){
        try{
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet res = dbmd.getTables(null, null, USER_TABLE_NAME, null);

            // Delete Table if Exists
            if(res.next()){
                deleteTable();
            }

            // Create Table
            String newTable = "CREATE TABLE " + USER_TABLE_NAME + " (USERNAME VARCHAR(255), SCORE INT)";
            dbManager.updateDB(newTable);

            // Print completion message
            System.out.println("TABLE CREATION COMPLETED Successfully");

            // Populate Database Table
            populateTable(dbManager);
        }catch (SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    public void deleteTable(){
        System.err.println(USER_TABLE_NAME + " Table already exists.");
        String dropTable = "DROP TABLE " + USER_TABLE_NAME;
        dbManager.updateDB(dropTable);
        System.out.println(USER_TABLE_NAME + " TABLE DROPPED");
    }

    public void populateTable(DBManager dbManager){
        try{
            File file = new File(USER_DATABASE);
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String line;

            while((line = csvReader.readLine())!= null){
                // Split CSV File that stores questions
                String[] data = line.split("\t");
                // Generate SQL INSERT Statement
                String sb = "INSERT INTO " + USER_TABLE_NAME + " VALUES ('";
                // Username VARCHAR(255)
                sb += data[0] + "', ";
                // Score INT
                sb += data[1];
                sb += ")";

                // Update Database with SQL INSERT Statement
                dbManager.updateDB(sb);
            }

            // Close the CSV Reader to prevent any leaks
            csvReader.close();
            // Console message to confirm table populated successfully
            System.out.println("Table Populated - Completed Successfully");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        String sql = "UPDATE " + USER_TABLE_NAME + " SET SCORE = " + user.getScore()
                + " WHERE USERNAME = '" + user.getUserName() + "'";
        dbManager.updateDB(sql);
    }

    // Method to check the DATABASE can be accessed & prints correctly when needing to be used
    public void printTableContents() {
        try{
            ResultSet rs = dbManager.queryDB("SELECT * FROM " + USER_TABLE_NAME);

            while (rs.next()){
                String user = rs.getString("USERNAME");
                String score = rs.getString("SCORE");

                System.out.println("===============");
                System.out.println("USER " + user);
                System.out.println("SCORE " + score);
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
