package rs.ac.bg.np.praksaprojekat.exception;

public class UserNotLoggedInException extends RuntimeException{
    public UserNotLoggedInException(String message){
        super(message);
    }

    public UserNotLoggedInException(String message, Throwable t){
        super(message, t);
    }
}
