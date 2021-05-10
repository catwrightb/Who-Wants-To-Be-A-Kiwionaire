package PDC.UserPackage;

import java.util.Scanner;

public interface UserInterface {

    default void retrieveExistingUser(String string) { }

    default String scanReturnUserName(){
        return null;
    }

    default String createNewUser(){
        return null;
    }

    default String scanNewUserName(){
        return null;
    }


}
