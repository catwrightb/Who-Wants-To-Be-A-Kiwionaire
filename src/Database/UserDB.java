package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
    private static final String USER_DATABASE = "./resources/userStats.csv";
    private static final String TABLE_NAME = "USERS";

    private final DBManager dbManager;
    private final Connection conn;

    public UserDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    public static void main(String[] args) {
        UserDB users = new UserDB();
        users.createUserTable();
        users.printTableContents();
    }

    public void createUserTable(){
        try{
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet res = dbmd.getTables(null, null, TABLE_NAME, null);

            // Delete Table if Exists
            if(res.next()){
                System.err.println(TABLE_NAME + " Table already exists.");
                String dropTable = "DROP TABLE " + TABLE_NAME;
                dbManager.updateDB(dropTable);
                System.out.println(TABLE_NAME + " TABLE DROPPED");
            }

            // Create Table
            String newTable = "CREATE TABLE " + TABLE_NAME + " (USERNAME VARCHAR(255), SCORE INT)";
            dbManager.updateDB(newTable);

            // Print completion message
            System.out.println("TABLE CREATION COMPLETED Successfully");

            // Populate Database Table
            populateTable(dbManager);
        }catch (SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
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
                String sb = "INSERT INTO " + TABLE_NAME + " VALUES ('";
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

    // Method to check the DATABASE can be accessed & prints correctly when needing to be used
    public void printTableContents() {
        try{
            ResultSet rs = dbManager.queryDB("SELECT * FROM " + TABLE_NAME);

            while (rs.next()){
                String user = rs.getString("USERNAME");
                String score = rs.getString("SCORE");

                System.out.println("==========================================");
                System.out.println("USER " + user);
                System.out.println("SCORE " + score);
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
