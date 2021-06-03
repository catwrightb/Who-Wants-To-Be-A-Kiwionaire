package Models;

import Database.UserDB;
import Views.LeaderBoardPanel;

import java.util.*;

public class Leaderboard {
    public HashMap<Integer,User> leaderBoardSet;

    public Leaderboard(HashMap<Integer, User> leaderBoardSet) {
       this.leaderBoardSet = leaderBoardSet;
    }

    public Leaderboard() {

    }


    public void getUsersFromDataBase(Leaderboard test){
        UserDB userDB = new UserDB();
        ArrayList<User> users = userDB.returningUserList();

        Collections.sort(users);
        Collections.reverse(users);

        test.getTopSixUsers(users);


    }

    public void getTopSixUsers(ArrayList<User> users){
        Leaderboard test2 = new Leaderboard();
        test2.leaderBoardSet = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            test2.leaderBoardSet.put(i, users.get(i));
        }

        for (int i = 0; i < test2.leaderBoardSet.size(); i++) {
            System.out.println(test2.leaderBoardSet.get(i));
        }

        this.leaderBoardSet = test2.leaderBoardSet;

    }

    public static void main(String[] args) {
        Leaderboard test = new Leaderboard();
        test.getUsersFromDataBase(test);
    }






}
