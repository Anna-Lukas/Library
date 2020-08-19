package src.javastart.library.exception;

public class UsersAlreadyExistsException extends RuntimeException {
    public UsersAlreadyExistsException(String message) {
        super(message);
    }
}
