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
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.leaderBoardSet = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            leaderboard.leaderBoardSet.put(i, users.get(i));
        }

        //testing population occurring correctly
//        for (int i = 0; i < test2.leaderBoardSet.size(); i++) {
//            System.out.println(test2.leaderBoardSet.get(i));
//        }

        this.leaderBoardSet = leaderboard.leaderBoardSet;

    }

//    public static void main(String[] args) {
//        Leaderboard test = new Leaderboard();
//        test.getUsersFromDataBase(test);
//    }






}
