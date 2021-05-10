package PDC.UserPackage;

public interface NewUserInterface extends UserInterface{

    public default String createNewUser(){
        return null;
    }

    public default String scanNewUserName(){
        return null;
    }


}
