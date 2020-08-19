package src.javastart.library.exception;

public class PublicationAlredyExistsException extends RuntimeException {
    public PublicationAlredyExistsException(String message) {
        super(message);
    }
}
