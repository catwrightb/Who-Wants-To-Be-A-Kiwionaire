package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Question {
    //private static final String questionDatabase = "./resources/Questions.csv";
    String question;
    String correctAnswerStr;
    String correctAnswerChar;
    String aChoice;
    String bChoice;
    String cChoice;
    String dChoice;
    Integer level;
    ArrayList<String> stringAnswers;
    HashSet<String> stringHashSet;

    public Question() {
    }

//    public Question(String question, String correctAnswerStr, String inputOne,
//                    String inputTwo, String inputThree) {
//        this.question = question;
//        //this.correctAnswerStr = correctAnswerStr;
//        //this.correctAnswerChar = correctAnswerChar;
//
//        stringAnswers = new ArrayList<>();
//        stringHashSet = new HashSet<>();
//        stringAnswers.add(inputOne);
//        stringAnswers.add(inputTwo);
//        stringAnswers.add(inputThree);
//        stringAnswers.add(correctAnswerStr);
//
//        stringHashSet.addAll(stringAnswers);
//
//        for (int i = 0; i < stringHashSet.size(); i++) {
//
//        }
//
//
//
//
//
//        this.aChoice = aChoice;
//        this.bChoice = bChoice;
//        this.cChoice = cChoice;
//        this.dChoice = dChoice;
//        this.level = level;
//    }

    public String getCorrectAnswerStr() {
        return correctAnswerStr;
    }

    public void setCorrectAnswerStr(String correctAnswerStr) {
        this.correctAnswerStr = correctAnswerStr;
    }

    public String getaChoice() {
        return aChoice;
    }

    public void setaChoice(String aChoice) {
        this.aChoice = aChoice;
    }

    public String getbChoice() {
        return bChoice;
    }

    public void setbChoice(String bChoice) {
        this.bChoice = bChoice;
    }

    public String getcChoice() {
        return cChoice;
    }

    public void setcChoice(String cChoice) {
        this.cChoice = cChoice;
    }

    public String getdChoice() {
        return dChoice;
    }

    public void setdChoice(String dChoice) {
        this.dChoice = dChoice;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswerChar() {
        return correctAnswerChar;
    }

    public void setCorrectAnswerChar(String correctAnswerChar) {
        this.correctAnswerChar = correctAnswerChar;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }



}
