package Database;

import PDC.Question;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Jacob Tupe | 18018323
 */
public class QuestionDB {
    private static final String QUESTION_DATABASE = "./resources/Questions.csv";
    private static final String QUESTIONS_TABLE_NAME = "QUESTIONS";

    private final DBManager dbManager;
    private final Connection conn;

    public QuestionDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    public ArrayList<Question> questionListCreator(){
        ResultSet rs = dbManager.queryDB("SELECT * FROM " + QUESTIONS_TABLE_NAME);
        ArrayList<Question> questionsList = new ArrayList<>();
        try{
            while(rs.next()){
                // Create new question & populate with values
                Question q = new Question();
                q.setQuestion(rs.getString("QUESTION"));
                q.setCorrectAnswer(rs.getString("ANSWER"));
                q.setaChoice(rs.getString("CHOICE_A"));
                q.setbChoice(rs.getString("CHOICE_B"));
                q.setcChoice(rs.getString("CHOICE_C"));
                q.setdChoice(rs.getString("CHOICE_D"));
                q.setLevel(rs.getInt("LEVEL"));

                // Add question to the list
                questionsList.add(q);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return questionsList;
    }

    public void createQuestionsTable(){
        try{
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet res = dbmd.getTables(null, null, QUESTIONS_TABLE_NAME, null);

            // Check if table exists
            if(res.next()){
                System.out.println("Table Exists.");
                deleteTable(dbManager);
            }

            // Create Table
            String newTable = "CREATE TABLE " + QUESTIONS_TABLE_NAME + " (QUESTION LONG VARCHAR, ANSWER CHAR, CHOICE_A VARCHAR(255), CHOICE_B VARCHAR(255), CHOICE_C VARCHAR(255), CHOICE_D VARCHAR(255), LEVEL INT)";
            dbManager.updateDB(newTable);

            // Print completion message
            System.out.println("TABLE CREATION COMPLETED Successfully");

            // Populate Database Table
            populateTable(dbManager);
        }catch (SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    public void deleteTable(DBManager db){
        System.err.println(QUESTIONS_TABLE_NAME + " Table already exists.");
        String dropTable = "DROP TABLE " + QUESTIONS_TABLE_NAME;
        dbManager.updateDB(dropTable);
        System.out.println(QUESTIONS_TABLE_NAME + " TABLE DROPPED");
    }

    public void populateTable(DBManager dbManager){
        try{
            File file = new File(QUESTION_DATABASE);
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            String line;

            while((line = csvReader.readLine())!= null){
                // Split CSV File that stores questions
                String[] data = line.split(",");
                // Generate SQL INSERT Statement
                String sb = "INSERT INTO " + QUESTIONS_TABLE_NAME + " VALUES ('";
                // Question LONG VARCHAR
                sb += data[0] + "', '";
                // Answer CHAR
                sb += data[2] + "', '";
                // Choice_A VARCHAR
                sb += data[3] + "', '";
                // Choice_B VARCHAR
                sb += data[4] + "', '";
                // Choice_C VARCHAR
                sb += data[5] + "', '";
                // Choice_D VARCHAR
                sb += data[6] + "', ";
                // Level INT
                sb += data[7];
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
            ResultSet rs = dbManager.queryDB("SELECT * FROM " + QUESTIONS_TABLE_NAME);

            while (rs.next()){
                String question = rs.getString("QUESTION");
                String answer = rs.getString("ANSWER");
                String choiceA = rs.getString("CHOICE_A");
                String choiceB = rs.getString("CHOICE_B");
                String choiceC = rs.getString("CHOICE_C");
                String choiceD = rs.getString("CHOICE_D");

                System.out.println("==========================================");
                System.out.println("QUESTION " + question);
                System.out.println("ANSWER " + answer);
                System.out.print("A " + choiceA);
                System.out.print(" | B " + choiceB);
                System.out.print(" | C " + choiceC);
                System.out.print(" | D " + choiceD);
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
