package PDC.UserPackage;

public interface ReturnedUserInterface extends UserInterface {

    public default void retrieveExistingUser(String userName) {
    }

    public default String scanReturnUserName(){
        return null;
    }

}
