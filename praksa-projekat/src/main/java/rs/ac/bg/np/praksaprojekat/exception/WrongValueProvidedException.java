package rs.ac.bg.np.praksaprojekat.exception;

public class WrongValueProvidedException extends RuntimeException{

    public WrongValueProvidedException(String message){
        super(message);
    }

    public WrongValueProvidedException(String message, Throwable source){
        super(message, source);
    }
}
