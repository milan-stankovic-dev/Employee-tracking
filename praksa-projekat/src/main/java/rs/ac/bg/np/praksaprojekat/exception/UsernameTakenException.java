package rs.ac.bg.np.praksaprojekat.exception;

public class UsernameTakenException extends RuntimeException{
    public UsernameTakenException(String message) {
        super(message);
    }

    public UsernameTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
